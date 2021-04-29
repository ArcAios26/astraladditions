package arcaios26.astraladditions.common.util;

import arcaios26.astraladditions.AstralAdditions;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;

public class ItemNBTUtils {

    public static final String ACTIVE_TAG = "active";
    public static final String ACTIVE_STARLIGHT = "starlight";
    public static final String ACTIVE_FLUID = "fluid";
    public static final ResourceLocation ACTIVE_NAME = new ResourceLocation(AstralAdditions.MODID, "active");
    public static final IItemPropertyGetter ACTIVE_GETTER = (stack, world, entity) -> stack.hasTag() && stack.getTag().getBoolean(ACTIVE_TAG) ? 1F : 0F;

    public static CompoundNBT getOrCreateTag(ItemStack stack) {
        if (!stack.hasTag())
            stack.setTag(new CompoundNBT());

        return stack.getTag();
    }
}
