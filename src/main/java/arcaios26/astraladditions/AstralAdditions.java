package arcaios26.astraladditions;


import arcaios26.astraladditions.creativetabs.AATab;
import arcaios26.astraladditions.proxy.CommonProxy;
import arcaios26.astraladditions.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class AstralAdditions {
    @Mod.Instance
    public static AstralAdditions instance;

    public static Logger log = LogManager.getLogger(Reference.NAME);

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    //Tabs
    public static final CreativeTabs AATAB = new AATab(Reference.MOD_ID);

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) { RegistryHandler.preInitRegistries(event); }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        RegistryHandler.initRegistries(event);
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) { RegistryHandler.postInitRegistries(event); }
}
