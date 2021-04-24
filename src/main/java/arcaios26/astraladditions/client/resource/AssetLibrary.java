package arcaios26.astraladditions.client.resource;

import arcaios26.astraladditions.AstralAdditions;
import hellfirepvp.astralsorcery.client.resource.AbstractRenderableTexture;
import hellfirepvp.astralsorcery.common.util.object.CacheReference;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.resource.IResourceType;
import net.minecraftforge.resource.ISelectiveResourceReloadListener;
import net.minecraftforge.resource.VanillaResourceType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AssetLibrary implements ISelectiveResourceReloadListener {

    public static AssetLibrary INSTANCE = new AssetLibrary();
    private static boolean isReloading = false;

    private static Map<AssetLoader.SubLocation, Map<String, BindableResource>> loadedTextures = new HashMap<>();

    private AssetLibrary() {}

    public static Supplier<AbstractRenderableTexture> loadReference(AssetLoader.TextureLocation location, String... path) {
        return new CacheReference<>(() -> loadTexture(location, path));
    }

    public static AbstractRenderableTexture loadTexture(AssetLoader.TextureLocation location, String... path) {
        String name = String.join("/", path);
        if (name.endsWith(".png"))
            throw new IllegalArgumentException("Tried to loadTexture with appended .png from the AssetLibrary");

        return loadedTextures.computeIfAbsent(location, l -> new HashMap<>())
                .computeIfAbsent(name, str -> AssetLoader.loadTexture(location, str));
    }

    public static boolean isReloading() { return isReloading; }

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager, Predicate<IResourceType> resourcePredicate) {
        if (isReloading || !resourcePredicate.test(VanillaResourceType.TEXTURES))
            return;

        isReloading = true;
        AstralAdditions.log.info("[AssetLibrary] Refreshing and Invalidating Resources");

        for (Map<String, BindableResource> map : loadedTextures.values())
            map.values().forEach(BindableResource::invalidateAndReload);

        isReloading = false;
        AstralAdditions.log.info("[AssetLibrary] Successfully reloaded library.");
    }

}
