package arcaios26.astraladditions.common.lib;

import hellfirepvp.astralsorcery.common.base.Mods;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;

import static hellfirepvp.astralsorcery.common.base.Mods.CURIOS;

public class TagsAA {

    private TagsAA() {}

    public static class Items {

        public static final ITag.INamedTag<Item> CURIOS_RING = itemTag(CURIOS, "ring");

    }

    private static ITag.INamedTag<Item> itemTag(Mods mod, String name) {
        return ItemTags.makeWrapperTag(mod.key(name).toString());
    }
}
