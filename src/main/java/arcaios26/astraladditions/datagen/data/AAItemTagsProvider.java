package arcaios26.astraladditions.datagen.data;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.common.lib.ItemsAA;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.data.TagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.data.ExistingFileHelper;

import static arcaios26.astraladditions.common.lib.TagsAA.Items.CURIOS_RING;

public class AAItemTagsProvider extends ItemTagsProvider {

    public AAItemTagsProvider(DataGenerator gen, BlockTagsProvider blockTags, ExistingFileHelper exFileHelper) {
        super(gen, blockTags, AstralAdditions.MODID, exFileHelper);
    }

    @Override
    protected void registerTags() {
        this.tag(CURIOS_RING)
                .add(ItemsAA.ASTRAL_RING);
    }

    private TagsProvider.Builder<Item> tag(ITag.INamedTag<Item> tag) {
        return this.getOrCreateBuilder(tag);
    }
}
