package arcaios26.astraladditions.proxy;

import arcaios26.astraladditions.init.ModRecipes;
import arcaios26.astraladditions.init.ModResearch;
import arcaios26.astraladditions.items.wearable.AstralRing;
import arcaios26.astraladditions.network.PacketHandler;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        PacketHandler.register();
    }

    public void init(FMLInitializationEvent event) {
        ModRecipes.initRecipes();
    }

    public void postInit(FMLPostInitializationEvent event) {
        ModResearch.init();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new AstralRing());
    }
}
