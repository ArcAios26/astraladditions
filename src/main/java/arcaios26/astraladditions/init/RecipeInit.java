package arcaios26.astraladditions.init;

import arcaios26.astraladditions.crafting.AstralRingRecipe;
import hellfirepvp.astralsorcery.common.block.BlockBlackMarble;
import hellfirepvp.astralsorcery.common.block.BlockInfusedWood;
import hellfirepvp.astralsorcery.common.block.BlockMarble;
import hellfirepvp.astralsorcery.common.crafting.altar.recipes.DiscoveryRecipe;
import hellfirepvp.astralsorcery.common.crafting.helper.AccessibleRecipeAdapater;
import hellfirepvp.astralsorcery.common.crafting.helper.ShapedRecipeSlot;
import hellfirepvp.astralsorcery.common.lib.BlocksAS;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static hellfirepvp.astralsorcery.common.crafting.altar.AltarRecipeRegistry.*;
import static hellfirepvp.astralsorcery.common.crafting.helper.ShapedRecipe.Builder.newShapedRecipe;

public class RecipeInit {
    public static AstralRingRecipe rAstralRing;
    public static AccessibleRecipeAdapater rMarbleWall;
    public static AccessibleRecipeAdapater rMarbleWallBrick;
    public static AccessibleRecipeAdapater rMarbleWallArch;
    public static AccessibleRecipeAdapater rMarbleWallChiseled;
    public static AccessibleRecipeAdapater rMarbleWallEngraved;
    public static AccessibleRecipeAdapater rMarbleWallRuned;
    public static AccessibleRecipeAdapater rBlackMarbleWall;
    public static AccessibleRecipeAdapater rBlackMarbleWallBrick;
    public static AccessibleRecipeAdapater rBlackMarbleWallArch;
    public static AccessibleRecipeAdapater rBlackMarbleWallChiseled;
    public static AccessibleRecipeAdapater rBlackMarbleWallEngraved;
    public static AccessibleRecipeAdapater rBlackMarbleWallRuned;
    public static AccessibleRecipeAdapater rInfusedWoodFence;
    public static AccessibleRecipeAdapater rInfusedWoodFenceGate;

    public static void initRecipes() {
        initVanilla();
        initDiscovery();
        initTrait();
        cacheLocalRecipes();

    }

    private static void initDiscovery() {
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWall));
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWallBrick));
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWallArch));
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWallChiseled));
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWallEngraved));
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWallRuned));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWall));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWallBrick));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWallArch));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWallChiseled));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWallEngraved));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWallRuned));
        registerAltarRecipe(new DiscoveryRecipe(rInfusedWoodFence));
        registerAltarRecipe(new DiscoveryRecipe(rInfusedWoodFenceGate));
    }

    private static void initTrait() {
        rAstralRing = registerAltarRecipe(new AstralRingRecipe());
    }

    private static void initVanilla() {
        rMarbleWall = newShapedRecipe("block_marble_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_marble_wall")), 6))
                .addPart(BlockMarble.MarbleBlockType.RAW.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rMarbleWallBrick = newShapedRecipe("block_marble_brick_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_marble_brick_wall")), 6))
                .addPart(BlockMarble.MarbleBlockType.BRICKS.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rMarbleWallArch = newShapedRecipe("block_marble_arch_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_marble_arch_wall")), 6))
                .addPart(BlockMarble.MarbleBlockType.ARCH.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rMarbleWallChiseled = newShapedRecipe("block_marble_chiseled_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_marble_chiseled_wall")), 6))
                .addPart(BlockMarble.MarbleBlockType.CHISELED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rMarbleWallEngraved = newShapedRecipe("block_marble_engraved_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_marble_engraved_wall")), 6))
                .addPart(BlockMarble.MarbleBlockType.ENGRAVED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rMarbleWallRuned = newShapedRecipe("block_marble_runed_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_marble_runed_wall")), 6))
                .addPart(BlockMarble.MarbleBlockType.RUNED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWall = newShapedRecipe("block_black_marble_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_black_marble_wall")), 6))
                .addPart(BlockBlackMarble.BlackMarbleBlockType.RAW.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWallBrick = newShapedRecipe("block_black_marble_brick_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_black_marble_brick_wall")), 6))
                .addPart(BlockBlackMarble.BlackMarbleBlockType.BRICKS.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWallArch = newShapedRecipe("block_black_marble_arch_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_black_marble_arch_wall")), 6))
                .addPart(BlockBlackMarble.BlackMarbleBlockType.ARCH.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWallChiseled = newShapedRecipe("block_black_marble_chiseled_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_black_marble_chiseled_wall")), 6))
                .addPart(BlockBlackMarble.BlackMarbleBlockType.CHISELED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWallEngraved = newShapedRecipe("block_black_marble_engraved_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_black_marble_engraved_wall")), 6))
                .addPart(BlockBlackMarble.BlackMarbleBlockType.ENGRAVED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWallRuned = newShapedRecipe("block_black_marble_runed_wall", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_black_marble_runed_wall")), 6))
                .addPart(BlockBlackMarble.BlackMarbleBlockType.RUNED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rInfusedWoodFence = newShapedRecipe("block_infused_wood_fence", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_infused_wood_fence")), 3))
                .addPart(BlockInfusedWood.WoodType.PLANKS.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_RIGHT)
                .addPart(Item.getByNameOrId("minecraft:stick"),
                        ShapedRecipeSlot.CENTER, ShapedRecipeSlot.LOWER_CENTER)
                .buildAndRegisterShapedRecipe();

        rInfusedWoodFenceGate = newShapedRecipe("block_infused_wood_fence_gate", new ItemStack(Item.getItemFromBlock(Block.getBlockFromName("astraladditions:block_infused_wood_fence_gate"))))
                .addPart(BlockInfusedWood.WoodType.PLANKS.asStack(),
                        ShapedRecipeSlot.CENTER, ShapedRecipeSlot.LOWER_CENTER)
                .addPart(Item.getByNameOrId("minecraft:stick"),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();
    }
}
