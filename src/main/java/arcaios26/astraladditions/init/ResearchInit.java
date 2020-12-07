package arcaios26.astraladditions.init;

import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageText;
import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageTraitRecipe;
import hellfirepvp.astralsorcery.common.data.research.ResearchNode;
import hellfirepvp.astralsorcery.common.data.research.ResearchProgression;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ResearchInit {
    public static void init() {
        initRadiance();
    }

    private static void initRadiance() {
        ResearchProgression.Registry regRadiance = ResearchProgression.RADIANCE.getRegistry();

        ResearchNode resAstralRing = new ResearchNode(new ItemStack(Item.getByNameOrId("astraladditions:ring_astral")), "astraladditions.ring_astral", 8, 2);
        resAstralRing.addPage(new JournalPageText("journal.astraladditions.ring_astral.text"));
        resAstralRing.addPage(new JournalPageTraitRecipe(RecipeInit.rAstralRing));

        regRadiance.register(resAstralRing);
    }
}
