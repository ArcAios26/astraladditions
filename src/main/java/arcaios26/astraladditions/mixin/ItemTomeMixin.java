package arcaios26.astraladditions.mixin;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.client.lib.TexturesAA;
import arcaios26.astraladditions.client.registry.ResearchRegistry;
import hellfirepvp.astralsorcery.client.resource.AbstractRenderableTexture;
import hellfirepvp.astralsorcery.client.screen.journal.progression.JournalCluster;
import hellfirepvp.astralsorcery.client.screen.journal.progression.JournalProgressionClusterMapping;
import hellfirepvp.astralsorcery.common.data.research.ResearchProgression;
import hellfirepvp.astralsorcery.common.item.ItemTome;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(ItemTome.class)
public class ItemTomeMixin {

    @Inject(method = "onItemRightClick", at = @At(value = "HEAD"), remap = false)
    public void onItemRightClickHead(World world, PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult<ItemStack>> ci) {
        if (world.isRemote()) {
            ResearchRegistry.registerClusters();
        }
    }
}
