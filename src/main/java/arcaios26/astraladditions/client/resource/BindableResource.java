package arcaios26.astraladditions.client.resource;

import arcaios26.astraladditions.AstralAdditions;
import com.mojang.blaze3d.systems.RenderSystem;
import hellfirepvp.astralsorcery.client.resource.AbstractRenderableTexture;
import hellfirepvp.astralsorcery.client.resource.AssetLibrary;
import hellfirepvp.astralsorcery.client.resource.SpriteSheetResource;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.Texture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class BindableResource extends AbstractRenderableTexture.Full {

    private Texture resource = null;
    private final String path;

    public BindableResource(String path) {
        super(AstralAdditions.key(path.replaceAll("[^a-zA-Z0-9\\.\\-]", "_")));
        this.path = path;
        allocateGlId();
    }

    public String getPath() {
        return path;
    }

    public boolean isInitialized() {
        return this.resource != null;
    }

    public Texture getResource() {
        return this.resource;
    }

    public SpriteSheetResource asSpriteSheet(int rows, int columns) {
        return new SpriteSheetResource(this, rows, columns);
    }

    void invalidateAndReload() {
        Minecraft.getInstance().getTextureManager().deleteTexture(this.getKey());
        this.resource = null;
    }

    private void allocateGlId() {
        if (this.resource != null || hellfirepvp.astralsorcery.client.resource.AssetLibrary.isReloading()) {
            return;
        }
        TextureManager mgr = Minecraft.getInstance().getTextureManager();
        this.resource = mgr.getTexture(this.getKey());
        if (this.resource == null) {
            mgr.loadTexture(this.getKey(), new SimpleTexture(new ResourceLocation(this.getPath())));
            this.resource = mgr.getTexture(this.getKey());
        }
    }

    @Override
    public void bindTexture() {
        if (AssetLibrary.isReloading()) {
            return; //we do nothing but wait.
        }
        if (this.resource == null) {
            allocateGlId();
        }
        RenderSystem.bindTexture(this.resource.getGlTextureId());
    }

    @Override
    public RenderState.TextureState asState() {
        return new RenderState.TextureState(this.getKey(), false, false) {
            @Override
            public void setupRenderState() {
                RenderSystem.enableTexture();
                BindableResource.this.bindTexture();
                BindableResource.this.resource.setBlurMipmap(false, false);
            }
        };
    }

}
