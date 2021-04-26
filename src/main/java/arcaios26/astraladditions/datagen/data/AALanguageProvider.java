package arcaios26.astraladditions.datagen.data;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.common.CommonProxy;
import arcaios26.astraladditions.common.lib.BlocksAA;
import arcaios26.astraladditions.common.lib.ItemsAA;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class AALanguageProvider extends LanguageProvider {

    public AALanguageProvider(DataGenerator gen, String locale) {
        super (gen, AstralAdditions.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        //Item Groups
        add(CommonProxy.ITEM_GROUP_AA.getGroupName().getString(), AstralAdditions.NAME);

        //Blocks
        add(BlocksAA.BLACK_MARBLE_WALL.getTranslationKey(), "Sooty Marble Wall");
        add(BlocksAA.BLACK_MARBLE_WALL_ARCH.getTranslationKey(), "Sooty Marble Arch Wall");
        add(BlocksAA.BLACK_MARBLE_WALL_BRICKS.getTranslationKey(), "Sooty Marble Brick Wall");
        add(BlocksAA.BLACK_MARBLE_WALL_RUNED.getTranslationKey(), "Sooty Runed Marble Wall");
        add(BlocksAA.BLACK_MARBLE_WALL_CHISELED.getTranslationKey(), "Sooty Chiseled Marble Wall");
        add(BlocksAA.BLACK_MARBLE_WALL_ENGRAVED.getTranslationKey(), "Sooty Engraved Marble Wall");
        add(BlocksAA.MARBLE_WALL.getTranslationKey(), "Marble Wall");
        add(BlocksAA.MARBLE_WALL_ARCH.getTranslationKey(), "Marble Arch Wall");
        add(BlocksAA.MARBLE_WALL_BRICKS.getTranslationKey(), "Marble Brick Wall");
        add(BlocksAA.MARBLE_WALL_RUNED.getTranslationKey(), "Runed Marble Wall");
        add(BlocksAA.MARBLE_WALL_CHISELED.getTranslationKey(), "Chiseled Marble Wall");
        add(BlocksAA.MARBLE_WALL_ENGRAVED.getTranslationKey(), "Engraved Marble Wall");
        add(BlocksAA.STARMETAL_WALL.getTranslationKey(), "Starmetal Wall");
        add(BlocksAA.INFUSED_WOOD_FENCE.getTranslationKey(), "Infused Wood Fence");
        add(BlocksAA.INFUSED_WOOD_FENCE_GATE.getTranslationKey(), "Infused Wood Fence Gate");
        add(BlocksAA.VIBRANT_INFUSED_WOOD_FENCE.getTranslationKey(), "Vibrant Infused Wood Fence");
        add(BlocksAA.VIBRANT_INFUSED_WOOD_FENCE_GATE.getTranslationKey(), "Vibrant Infused Wood Fence Gate");
        add(BlocksAA.STARMETAL_FENCE.getTranslationKey(), "Starmetal Fence");
        add(BlocksAA.STARMETAL_FENCE_GATE.getTranslationKey(), "Starmetal Fence Gate");

        //Items
        add(ItemsAA.ASTRAL_RING.getTranslationKey(), "Astral Ring");

        //Research Clusters
        add("astralsorcery.journal.research.ascension", "Ascension");
    }
}
