package arcaios26.astraladditions;


import arcaios26.astraladditions.util.handlers.RegistryHandler;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;


public class Config {
    private static final String CATEGORY_GENERAL = "general";

    //values to be accessed
    public static boolean ringEnabled = true;
    public static boolean armorEnabled = false;

    //called during preInit, reads config and creates it if it doesn't exist
    public static void readConfig() {
        Configuration config = RegistryHandler.config;
        try {
            config.load();
            initGeneralConfig(config);
        } catch (Exception e1) {
            AstralAdditions.log.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (config.hasChanged()) config.save();
        }
    }

    private static void initGeneralConfig(Configuration config) {
        config.addCustomCategoryComment(CATEGORY_GENERAL, "General Configuration");
        config.getBoolean("ringEnabled", CATEGORY_GENERAL, ringEnabled, "enable astral ring. default: true");
        config.getBoolean("armorEnabled", CATEGORY_GENERAL, armorEnabled, "enable Starmetal Armor. default: false");
    }
}
