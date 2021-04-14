package arcaios26.astraladditions.init;

import arcaios26.astraladditions.Config;
import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageDiscoveryRecipe;
import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageRecipe;
import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageText;
import hellfirepvp.astralsorcery.client.gui.journal.page.JournalPageTraitRecipe;
import hellfirepvp.astralsorcery.common.data.research.ResearchNode;
import hellfirepvp.astralsorcery.common.data.research.ResearchProgression;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Objects;

public class ResearchInit {
    public static void init() {
        initDiscovery();
        initAttunement();
        initRadiance();
    }

    private static void initRadiance() {
        ResearchProgression.Registry regRadiance = ResearchProgression.RADIANCE.getRegistry();
        if (Config.ringEnabled) {
            ResearchNode resAstralRing = new ResearchNode(new ItemStack(Item.getByNameOrId("astraladditions:ring_astral")), "astraladditions.ring_astral", 8, 2);
            resAstralRing.addPage(new JournalPageText("journal.astraladditions.ring_astral.text"));
            resAstralRing.addPage(new JournalPageTraitRecipe(RecipeInit.rAstralRing));

            regRadiance.register(resAstralRing);
        }
    }

    private static void initAttunement() {
        ResearchProgression.Registry regAttunement = ResearchProgression.ATTUNEMENT.getRegistry();
        if (Config.armorEnabled) {
            ResearchNode resStarmetalArmor = new ResearchNode(new ItemStack(Objects.requireNonNull(Item.getByNameOrId("astraladditions:chestplate_starmetal"))), "astraladditions.armor_starmetal", 6, 6);
            resStarmetalArmor.addPage(new JournalPageText("journal.astraladditions.armor_starmetal.text"));
            resStarmetalArmor.addPage(new JournalPageRecipe(RecipeInit.rStarmetalHelmet));
            resStarmetalArmor.addPage(new JournalPageRecipe(RecipeInit.rStarmetalChestplate));
            resStarmetalArmor.addPage(new JournalPageRecipe(RecipeInit.rStarmetalLeggings));
            resStarmetalArmor.addPage(new JournalPageRecipe(RecipeInit.rStarmetalBoots));

            regAttunement.register(resStarmetalArmor);

            ResearchNode resTempNode = ResearchProgression.findNode("STARMETAL_RES");
            if (resTempNode != null) {
                resStarmetalArmor.addSourceConnectionFrom(resTempNode);
                resTempNode.addPage(new JournalPageRecipe(RecipeInit.rStarmetalBlock));
                resTempNode.addPage(new JournalPageRecipe(RecipeInit.rStarmetalIngot));
            }
        } else {
            ResearchNode resTempNode = ResearchProgression.findNode("STARMETAL_RES");
            if (resTempNode != null) {
                resTempNode.addPage(new JournalPageRecipe(RecipeInit.rStarmetalBlock));
                resTempNode.addPage(new JournalPageRecipe(RecipeInit.rStarmetalIngot));
            }
        }
    }

    private static void initDiscovery() {
        //add wall recipes to marble type node in journal
        ResearchNode resMarble = ResearchProgression.findNode("MARBLETYPES");
        resMarble.addPage(new JournalPageRecipe(RecipeInit.rMarbleWall));
        resMarble.addPage(new JournalPageRecipe(RecipeInit.rMarbleWallArch));
        resMarble.addPage(new JournalPageRecipe(RecipeInit.rMarbleWallBrick));
        resMarble.addPage(new JournalPageRecipe(RecipeInit.rMarbleWallChiseled));
        resMarble.addPage(new JournalPageRecipe(RecipeInit.rMarbleWallEngraved));
        resMarble.addPage(new JournalPageRecipe(RecipeInit.rMarbleWallRuned));

        //add wall recipes to sooty marble type node in journal
        ResearchNode resBlackMarble = ResearchProgression.findNode("SOOTYMARBLE");
        resBlackMarble.addPage(new JournalPageRecipe(RecipeInit.rBlackMarbleWall));
        resBlackMarble.addPage(new JournalPageRecipe(RecipeInit.rBlackMarbleWallArch));
        resBlackMarble.addPage(new JournalPageRecipe(RecipeInit.rBlackMarbleWallBrick));
        resBlackMarble.addPage(new JournalPageRecipe(RecipeInit.rBlackMarbleWallChiseled));
        resBlackMarble.addPage(new JournalPageRecipe(RecipeInit.rBlackMarbleWallEngraved));
        resBlackMarble.addPage(new JournalPageRecipe(RecipeInit.rBlackMarbleWallRuned));
    }
}
