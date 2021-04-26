package arcaios26.astraladditions.datagen;

import arcaios26.astraladditions.datagen.assets.AABlockStateProvider;
import arcaios26.astraladditions.datagen.assets.AAItemModelProvider;
import arcaios26.astraladditions.datagen.data.AABlockTagsProvider;
import arcaios26.astraladditions.datagen.data.AAItemTagsProvider;
import arcaios26.astraladditions.datagen.data.AALanguageProvider;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AADataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        if (event.includeServer()) {
            BlockTagsProvider blockTags = new AABlockTagsProvider(gen, event.getExistingFileHelper());
            gen.addProvider(blockTags);
            gen.addProvider(new AAItemTagsProvider(gen, blockTags, event.getExistingFileHelper()));
        }

        if (event.includeClient()) {
            gen.addProvider(new AABlockStateProvider(gen, event.getExistingFileHelper()));
            gen.addProvider(new AAItemModelProvider(gen, event.getExistingFileHelper()));
            gen.addProvider(new AALanguageProvider(gen, "en_us"));
        }
    }
}
