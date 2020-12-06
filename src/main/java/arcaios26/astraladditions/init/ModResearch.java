package arcaios26.astraladditions.init;

import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageText;
import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageTraitRecipe;
import hellfirepvp.astralsorcery.common.data.research.ResearchNode;
import hellfirepvp.astralsorcery.common.data.research.ResearchProgression;
import hellfirepvp.astralsorcery.common.registry.RegistryResearch;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import static hellfirepvp.astralsorcery.common.registry.RegistryBookLookups.registerItemLookup;

public class ModResearch {
    public static void init() {
        initRadiance();
    }

    private static void initRadiance() {
        ResearchProgression.Registry regRadiance = ResearchProgression.RADIANCE.getRegistry();

        ResearchNode resAstralRing = new ResearchNode(new ItemStack(Item.getByNameOrId("astraladditions:astral_ring")), "astraladditions.astral_ring", 8, 2);
        resAstralRing.addPage(new JournalPageText("journal.astraladditions.astral_ring.text"));
        resAstralRing.addPage(new JournalPageTraitRecipe(ModRecipes.rAstralRing));
        
        regRadiance.register(resAstralRing);
    }
}
