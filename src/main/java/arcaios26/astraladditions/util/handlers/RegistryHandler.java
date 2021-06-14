package arcaios26.astraladditions.util.handlers;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.Config;
import arcaios26.astraladditions.init.BlockInit;
import arcaios26.astraladditions.init.ItemInit;
import arcaios26.astraladditions.init.RecipeInit;
import arcaios26.astraladditions.init.ResearchInit;
import arcaios26.astraladditions.util.helpers.ClientKeyHelper;
import arcaios26.astraladditions.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

@Mod.EventBusSubscriber
public class RegistryHandler {

    public static Configuration config;

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ItemInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(BlockInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ItemInit.ITEMS) {
            if (item instanceof IHasModel) {
                ((IHasModel)item).registerModels();
            }
        }

        for (Block block : BlockInit.BLOCKS) {
            if (block instanceof IHasModel) {
                ((IHasModel)block).registerModels();
            }
        }
    }

    @SubscribeEvent
    public static void onRecipeRegister(RegistryEvent.Register<IRecipe> event) {
        RecipeInit.initRecipes();
    }


    public static void preInitRegistries(FMLPreInitializationEvent event) {
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "astraladditions.cfg"));
        Config.readConfig();

        PacketHandler.init();
    }

    public static void initRegistries(FMLInitializationEvent event) {
        AstralAdditions.proxy.registerKeyBinds();
        ResearchInit.init();
    }

    public static void postInitRegistries(FMLPostInitializationEvent event) {
        if (config.hasChanged()) {
            config.save();
        }
    }
}
