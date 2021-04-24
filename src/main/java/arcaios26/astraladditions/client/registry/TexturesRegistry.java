package arcaios26.astraladditions.client.registry;

import static arcaios26.astraladditions.client.lib.TexturesAA.TEX_GUI_CLUSTER_ASCENSION;
import static arcaios26.astraladditions.client.resource.AssetLibrary.loadTexture;
import static arcaios26.astraladditions.client.resource.AssetLoader.TextureLocation.GUI;

public class TexturesRegistry {

    private TexturesRegistry() {}

    public static void loadTextures() {
        TEX_GUI_CLUSTER_ASCENSION = loadTexture(GUI, "book", "cluster_ascension");
    }
}
