package arcaios26.astraladditions.datagen.data;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.common.lib.BlocksAA;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class AALanguageProvider extends LanguageProvider {

    public AALanguageProvider(DataGenerator gen, String locale) {
        super (gen, AstralAdditions.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add(BlocksAA.BLACK_MARBLE_WALL.getTranslationKey(), "Sooty Marble Wall");
    }
}
