package arcaios26.astraladditions.util.handlers;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.init.BlockInit;
import arcaios26.astraladditions.init.RecipeInit;
import arcaios26.astraladditions.init.ItemInit;
import arcaios26.astraladditions.init.ResearchInit;
import arcaios26.astraladditions.objects.blocks.BlockMarbleWall;
import arcaios26.astraladditions.util.helpers.ClientKeyHelper;
import arcaios26.astraladditions.util.interfaces.IHasModel;
import hellfirepvp.astralsorcery.common.crafting.helper.AccessibleRecipeAdapater;
import hellfirepvp.astralsorcery.common.lib.BlocksAS;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler {
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
        PacketHandler.init();
    }

    public static void initRegistries(FMLInitializationEvent event) {
        
        ClientKeyHelper.registerBindings();
        ResearchInit.init();
    }

    public static void postInitRegistries(FMLPostInitializationEvent event) {

    }
}
