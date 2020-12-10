package arcaios26.astraladditions;


import arcaios26.astraladditions.proxy.CommonProxy;
import arcaios26.astraladditions.util.handlers.RegistryHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.sql.Ref;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, dependencies = Reference.DEPENDENCIES, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class AstralAdditions {
    @Mod.Instance
    public static AstralAdditions instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        RegistryHandler.preInitRegistries(event);
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        RegistryHandler.initRegistries(event);
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        RegistryHandler.postInitRegistries(event);
    }
}
