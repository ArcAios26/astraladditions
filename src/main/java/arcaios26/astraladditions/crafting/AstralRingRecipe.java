package arcaios26.astraladditions.crafting;

import arcaios26.astraladditions.init.ItemInit;
import hellfirepvp.astralsorcery.common.crafting.altar.recipes.TraitRecipe;
import hellfirepvp.astralsorcery.common.crafting.helper.ShapeMap;
import hellfirepvp.astralsorcery.common.crafting.helper.ShapedRecipe;
import hellfirepvp.astralsorcery.common.crafting.helper.ShapedRecipeSlot;
import hellfirepvp.astralsorcery.common.item.ItemCraftingComponent;
import hellfirepvp.astralsorcery.common.item.tool.ItemSkyResonator;
import hellfirepvp.astralsorcery.common.lib.BlocksAS;
import hellfirepvp.astralsorcery.common.lib.Constellations;
import hellfirepvp.astralsorcery.common.lib.ItemsAS;
import hellfirepvp.astralsorcery.common.tile.TileAltar;
import hellfirepvp.astralsorcery.common.tile.base.TileReceiverBaseInventory;
import hellfirepvp.astralsorcery.common.util.OreDictAlias;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Objects;

import static hellfirepvp.astralsorcery.common.item.tool.ItemSkyResonator.getUpgrades;
import static net.minecraft.item.Item.*;

public class AstralRingRecipe extends TraitRecipe {
    public AstralRingRecipe() {
        super(ShapedRecipe.Builder.newShapedRecipe("internal/altar/ring_astral", getByNameOrId("astraladditions:ring_astral"))
                .addPart(ItemSkyResonator.setCurrentUpgradeUnsafe(ItemSkyResonator.setUpgradeUnlocked(ItemSkyResonator.setEnhanced(new ItemStack(ItemsAS.skyResonator)), ItemSkyResonator.ResonatorUpgrade.FLUID_FIELDS), ItemSkyResonator.ResonatorUpgrade.FLUID_FIELDS), ShapedRecipeSlot.CENTER)
                .addPart(OreDictAlias.ITEM_STARMETAL_DUST, ShapedRecipeSlot.LEFT, ShapedRecipeSlot.RIGHT, ShapedRecipeSlot.UPPER_CENTER)
                .addPart(BlocksAS.fluidLiquidStarlight, ShapedRecipeSlot.LOWER_CENTER)
                .unregisteredAccessibleShapedRecipe());

        setAttItem(ItemCraftingComponent.MetaType.RESO_GEM.asStack(), AttunementAltarSlot.UPPER_LEFT, AttunementAltarSlot.UPPER_RIGHT, AttunementAltarSlot.LOWER_LEFT, AttunementAltarSlot.LOWER_RIGHT);

        addOuterTraitItem(ItemCraftingComponent.MetaType.RESO_GEM.asStack());
        addOuterTraitItem(ItemCraftingComponent.MetaType.RESO_GEM.asStack());
        addOuterTraitItem(ItemCraftingComponent.MetaType.RESO_GEM.asStack());

        setRequiredConstellation(Constellations.aevitas);
    }

    @Override
    public boolean matches(TileAltar altar, TileReceiverBaseInventory.ItemHandlerTile invHandler, boolean ignoreStarlightRequirement) {
        ItemStack center = invHandler.getStackInSlot(ShapedRecipeSlot.CENTER.getSlotID());
        if (center.isEmpty() || !(center.getItem() instanceof ItemSkyResonator)) {
            return false;
        }

        List<ItemSkyResonator.ResonatorUpgrade> out = getUpgrades(center);
        return out.contains(ItemSkyResonator.ResonatorUpgrade.FLUID_FIELDS) && super.matches(altar, invHandler, ignoreStarlightRequirement);
    }

    @Nonnull
    @Override
    public ItemStack getOutput(ShapeMap centralGridMap, TileAltar altar) {
        return new ItemStack(Objects.requireNonNull(getByNameOrId("astraladditions:astral_ring")));
    }
}

