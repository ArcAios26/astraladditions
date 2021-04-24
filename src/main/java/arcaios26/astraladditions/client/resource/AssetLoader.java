package arcaios26.astraladditions.client.resource;

import arcaios26.astraladditions.AstralAdditions;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AssetLoader {

    private AssetLoader() {}

    @OnlyIn(Dist.CLIENT)
    protected static BindableResource load(AssetLocation location, SubLocation subLocation, String name, String suffix) {
        return new BindableResource(buildResourceString(location, subLocation, name, suffix));
    }

    @OnlyIn(Dist.CLIENT)
    private static String buildResourceString(AssetLocation location, SubLocation subLocation, String name, String suffix) {
        if (name.endsWith(suffix))
            name = name.substring(0, name.length() - suffix.length());

        StringBuilder builder = new StringBuilder();
        builder.append(AstralAdditions.MODID).append(':').append(location.location).append('/');

        if (subLocation != null)
            builder.append(subLocation.getLocation()).append('/');

        builder.append(name).append(suffix);

        return builder.toString();
    }

    @OnlyIn(Dist.CLIENT)
    protected static BindableResource loadTexture(TextureLocation location, String name) {
        return load(AssetLocation.TEXTURES, location, name, ".png");
    }

    public static interface SubLocation {

        public String getLocation();

    }

    public static enum TextureLocation implements SubLocation {

        GUI("gui");

        private final String location;

        private TextureLocation(String location) { this.location = location; }


        @Override
        public String getLocation() { return location; }

    }

    public static enum AssetLocation {

        TEXTURES("textures");

        private final String location;

        private AssetLocation(String location) { this.location = location; }

    }

}
