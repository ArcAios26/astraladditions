package arcaios26.astraladditions.client.resource;

import arcaios26.astraladditions.client.registry.TexturesRegistry;
import net.minecraft.resources.IResourceManager;
import net.minecraftforge.resource.IResourceType;
import net.minecraftforge.resource.ISelectiveResourceReloadListener;
import net.minecraftforge.resource.VanillaResourceType;

import java.util.function.Predicate;

public class AssetPreLoader implements ISelectiveResourceReloadListener {

    public static final AssetPreLoader INSTANCE = new AssetPreLoader();

    private boolean isInitialized = false;

    private AssetPreLoader() {}

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager, Predicate<IResourceType> resourcePredicate) {
        if (resourcePredicate.test(VanillaResourceType.TEXTURES)) {
            if (isInitialized)
                return;

            TexturesRegistry.loadTextures();

            isInitialized = true;
        }
    }
}
