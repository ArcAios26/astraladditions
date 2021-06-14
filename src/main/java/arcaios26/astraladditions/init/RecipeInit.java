package arcaios26.astraladditions.init;

import arcaios26.astraladditions.Config;
import arcaios26.astraladditions.crafting.AstralRingRecipe;
import hellfirepvp.astralsorcery.common.block.BlockBlackMarble;
import hellfirepvp.astralsorcery.common.block.BlockInfusedWood;
import hellfirepvp.astralsorcery.common.block.BlockMarble;
import hellfirepvp.astralsorcery.common.crafting.altar.recipes.DiscoveryRecipe;
import hellfirepvp.astralsorcery.common.crafting.helper.AccessibleRecipeAdapater;
import hellfirepvp.astralsorcery.common.crafting.helper.ShapedRecipe;
import hellfirepvp.astralsorcery.common.crafting.helper.ShapedRecipeSlot;
import hellfirepvp.astralsorcery.common.item.ItemCraftingComponent;
import hellfirepvp.astralsorcery.common.lib.BlocksAS;
import hellfirepvp.astralsorcery.common.util.OreDictAlias;
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
    public static AccessibleRecipeAdapater rStarmetalHelmet;
    public static AccessibleRecipeAdapater rStarmetalChestplate;
    public static AccessibleRecipeAdapater rStarmetalLeggings;
    public static AccessibleRecipeAdapater rStarmetalBoots;
    public static AccessibleRecipeAdapater rStarmetalBlock;
    public static AccessibleRecipeAdapater rStarmetalIngot;

    public static void initRecipes() {
        initVanilla();
        initDiscovery();
        initTrait();
        cacheLocalRecipes();

    }

    private static void initDiscovery() {
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWall).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWallBrick).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWallArch).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWallChiseled).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWallEngraved).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rMarbleWallRuned).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWall).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWallBrick).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWallArch).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWallChiseled).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWallEngraved).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rBlackMarbleWallRuned).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rInfusedWoodFence).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rInfusedWoodFenceGate).setPassiveStarlightRequirement(0));
        if (Config.armorEnabled) {
            registerAltarRecipe(new DiscoveryRecipe(rStarmetalHelmet).setPassiveStarlightRequirement(0));
            registerAltarRecipe(new DiscoveryRecipe(rStarmetalChestplate).setPassiveStarlightRequirement(0));
            registerAltarRecipe(new DiscoveryRecipe(rStarmetalLeggings).setPassiveStarlightRequirement(0));
            registerAltarRecipe(new DiscoveryRecipe(rStarmetalBoots).setPassiveStarlightRequirement(0));
        }
        registerAltarRecipe(new DiscoveryRecipe(rStarmetalBlock).setPassiveStarlightRequirement(0));
        registerAltarRecipe(new DiscoveryRecipe(rStarmetalIngot).setPassiveStarlightRequirement(0));
    }

    private static void initTrait() {
        rAstralRing = registerAltarRecipe(new AstralRingRecipe());
    }

    private static void initVanilla() {
        rMarbleWall = newShapedRecipe("block_marble_wall", BlockInit.BLOCK_MARBLE_WALL)
                .addPart(BlockMarble.MarbleBlockType.RAW.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rMarbleWallBrick = newShapedRecipe("block_marble_brick_wall", BlockInit.BLOCK_MARBLE_BRICK_WALL)
                .addPart(BlockMarble.MarbleBlockType.BRICKS.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rMarbleWallArch = newShapedRecipe("block_marble_arch_wall", BlockInit.BLOCK_MARBLE_ARCH_WALL)
                .addPart(BlockMarble.MarbleBlockType.ARCH.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rMarbleWallChiseled = newShapedRecipe("block_marble_chiseled_wall", BlockInit.BLOCK_MARBLE_CHISELED_WALL)
                .addPart(BlockMarble.MarbleBlockType.CHISELED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rMarbleWallEngraved = newShapedRecipe("block_marble_engraved_wall", BlockInit.BLOCK_MARBLE_ENGRAVED_WALL)
                .addPart(BlockMarble.MarbleBlockType.ENGRAVED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rMarbleWallRuned = newShapedRecipe("block_marble_runed_wall", BlockInit.BLOCK_MARBLE_RUNED_WALL)
                .addPart(BlockMarble.MarbleBlockType.RUNED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWall = newShapedRecipe("block_black_marble_wall", BlockInit.BLOCK_BLACK_MARBLE_WALL)
                .addPart(BlockBlackMarble.BlackMarbleBlockType.RAW.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWallBrick = newShapedRecipe("block_black_marble_brick_wall", BlockInit.BLOCK_BLACK_MARBLE_BRICK_WALL)
                .addPart(BlockBlackMarble.BlackMarbleBlockType.BRICKS.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWallArch = newShapedRecipe("block_black_marble_arch_wall", BlockInit.BLOCK_BLACK_MARBLE_ARCH_WALL)
                .addPart(BlockBlackMarble.BlackMarbleBlockType.ARCH.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWallChiseled = newShapedRecipe("block_black_marble_chiseled_wall", BlockInit.BLOCK_BLACK_MARBLE_CHISELED_WALL)
                .addPart(BlockBlackMarble.BlackMarbleBlockType.CHISELED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWallEngraved = newShapedRecipe("block_black_marble_engraved_wall", BlockInit.BLOCK_BLACK_MARBLE_ENGRAVED_WALL)
                .addPart(BlockBlackMarble.BlackMarbleBlockType.ENGRAVED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rBlackMarbleWallRuned = newShapedRecipe("block_black_marble_runed_wall", BlockInit.BLOCK_BLACK_MARBLE_RUNED_WALL)
                .addPart(BlockBlackMarble.BlackMarbleBlockType.RUNED.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        rInfusedWoodFence = newShapedRecipe("block_infused_wood_fence", BlockInit.BLOCK_IW_FENCE)
                .addPart(BlockInfusedWood.WoodType.PLANKS.asStack(),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_RIGHT)
                .addPart(Item.getByNameOrId("minecraft:stick"),
                        ShapedRecipeSlot.CENTER, ShapedRecipeSlot.LOWER_CENTER)
                .buildAndRegisterShapedRecipe();

        rInfusedWoodFenceGate = newShapedRecipe("block_infused_wood_fence_gate", BlockInit.BLOCK_IW_FENCE_GATE)
                .addPart(BlockInfusedWood.WoodType.PLANKS.asStack(),
                        ShapedRecipeSlot.CENTER, ShapedRecipeSlot.LOWER_CENTER)
                .addPart(Item.getByNameOrId("minecraft:stick"),
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        if (Config.armorEnabled) {
            rStarmetalHelmet = newShapedRecipe("helmet_starmetal", Item.getByNameOrId("astraladditions:helmet_starmetal"))
                    .addPart(OreDictAlias.ITEM_STARMETAL_INGOT,
                            ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                            ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_RIGHT)
                    .buildAndRegisterShapedRecipe();

            rStarmetalChestplate = newShapedRecipe("chestplate_starmetal", Item.getByNameOrId("astraladditions:chestplate_starmetal"))
                    .addPart(OreDictAlias.ITEM_STARMETAL_INGOT,
                            ShapedRecipeSlot.UPPER_LEFT, ShapedRecipeSlot.UPPER_RIGHT,
                            ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                            ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                    .buildAndRegisterShapedRecipe();

            rStarmetalLeggings = newShapedRecipe("leggings_starmetal", Item.getByNameOrId("astraladditions:leggings_starmetal"))
                    .addPart(OreDictAlias.ITEM_STARMETAL_INGOT,
                            ShapedRecipeSlot.UPPER_LEFT, ShapedRecipeSlot.UPPER_CENTER, ShapedRecipeSlot.UPPER_RIGHT,
                            ShapedRecipeSlot.LEFT, ShapedRecipeSlot.RIGHT,
                            ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_RIGHT)
                    .buildAndRegisterShapedRecipe();

            rStarmetalBoots = newShapedRecipe("boots_starmetal", Item.getByNameOrId("astraladditions:boots_starmetal"))
                    .addPart(OreDictAlias.ITEM_STARMETAL_INGOT,
                            ShapedRecipeSlot.LEFT, ShapedRecipeSlot.RIGHT,
                            ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_RIGHT)
                    .buildAndRegisterShapedRecipe();
        }

        rStarmetalBlock = newShapedRecipe("block_starmetal", BlockInit.BLOCK_STARMETAL)
                .addPart(OreDictAlias.ITEM_STARMETAL_INGOT,
                        ShapedRecipeSlot.UPPER_LEFT, ShapedRecipeSlot.UPPER_CENTER, ShapedRecipeSlot.UPPER_RIGHT,
                        ShapedRecipeSlot.LEFT, ShapedRecipeSlot.CENTER, ShapedRecipeSlot.RIGHT,
                        ShapedRecipeSlot.LOWER_LEFT, ShapedRecipeSlot.LOWER_CENTER, ShapedRecipeSlot.LOWER_RIGHT)
                .buildAndRegisterShapedRecipe();

        ItemStack ingot = ItemCraftingComponent.MetaType.STARMETAL_INGOT.asStack();
        ingot.setCount(9);
        rStarmetalIngot = newShapedRecipe("ingot_starmetal", ingot)
                .addPart(BlockInit.BLOCK_STARMETAL, ShapedRecipeSlot.CENTER)
                .forceEmptySpaces()
                .buildAndRegisterShapedRecipe();
    }
}
