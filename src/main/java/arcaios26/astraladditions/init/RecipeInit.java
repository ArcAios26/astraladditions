package arcaios26.astraladditions.init;

import arcaios26.astraladditions.crafting.AstralRingRecipe;

import static hellfirepvp.astralsorcery.common.crafting.altar.AltarRecipeRegistry.cacheLocalRecipes;
import static hellfirepvp.astralsorcery.common.crafting.altar.AltarRecipeRegistry.registerAltarRecipe;

public class RecipeInit {
    public static AstralRingRecipe rAstralRing;

    public static void initRecipes() {
        rAstralRing = registerAltarRecipe(new AstralRingRecipe());

        cacheLocalRecipes();
    }
}
