package arcaios26.astraladditions.crafting;

import static hellfirepvp.astralsorcery.common.crafting.altar.AltarRecipeRegistry.cacheLocalRecipes;
import static hellfirepvp.astralsorcery.common.crafting.altar.AltarRecipeRegistry.registerAltarRecipe;

public class Recipes {
    public static AstralRingRecipe rAstralRing;

    public static void initRecipes() {
        rAstralRing = registerAltarRecipe(new AstralRingRecipe());

        cacheLocalRecipes();
    }
}
