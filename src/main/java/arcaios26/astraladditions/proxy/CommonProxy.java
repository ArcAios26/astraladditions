package arcaios26.astraladditions.proxy;

import arcaios26.astraladditions.crafting.AstralRingRecipe;
import arcaios26.astraladditions.crafting.Recipes;
import arcaios26.astraladditions.items.wearable.AstralRing;
import arcaios26.astraladditions.network.PacketHandler;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static hellfirepvp.astralsorcery.common.crafting.altar.AltarRecipeRegistry.cacheLocalRecipes;
import static hellfirepvp.astralsorcery.common.crafting.altar.AltarRecipeRegistry.registerAltarRecipe;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        PacketHandler.register();
    }

    public void init(FMLInitializationEvent event) {
        Recipes.initRecipes();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new AstralRing());
    }
}
