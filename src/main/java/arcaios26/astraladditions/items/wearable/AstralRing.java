package arcaios26.astraladditions.items.wearable;


import arcaios26.astraladditions.network.PacketHandler;
import arcaios26.astraladditions.network.packets.PktItemEffectRender;
import arcaios26.astraladditions.util.ItemHelper;
import arcaios26.astraladditions.util.Reference;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import hellfirepvp.astralsorcery.client.effect.EffectHelper;
import hellfirepvp.astralsorcery.client.effect.EntityComplexFX;
import hellfirepvp.astralsorcery.common.base.FluidRarityRegistry;
import hellfirepvp.astralsorcery.common.constellation.distribution.ConstellationSkyHandler;
import hellfirepvp.astralsorcery.common.network.PacketChannel;
import hellfirepvp.astralsorcery.common.network.packet.server.PktPlayLiquidSpring;
import hellfirepvp.astralsorcery.common.util.ByteBufUtils;
import hellfirepvp.astralsorcery.common.util.SkyCollectionHelper;
import hellfirepvp.astralsorcery.common.util.data.Vector3;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.*;
import java.util.Random;

import static arcaios26.astraladditions.util.ItemHelper.*;


public class AstralRing extends Item implements IBauble {

    private static Random rand = new Random();


    public AstralRing() {
        setRegistryName("astral_ring");
        setTranslationKey(Reference.MOD_ID + ".astral_ring");
        setMaxStackSize(1);
        setMaxDamage(0);
        setCreativeTab(CreativeTabs.TOOLS);
        addPropertyOverride(ACTIVE_NAME, ACTIVE_GETTER);

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public BaubleType getBaubleType(ItemStack itemstack) {
        return BaubleType.RING;
    }

    @Override
    public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
        World worldIn = player.getEntityWorld();
        if (itemstack.hasTagCompound()) {
            if (itemstack.getTagCompound().getBoolean(TAG_ACTIVE)) {
                if (!worldIn.isRemote) {
                    double dstr = ConstellationSkyHandler.getInstance().getCurrentDaytimeDistribution(worldIn);
                    if (dstr <= 1E-4) return;
                    if (rand.nextFloat() < dstr && rand.nextInt(15) == 0) {

                        int oX = rand.nextInt(30) * (rand.nextBoolean() ? 1 : -1);
                        int oZ = rand.nextInt(30) * (rand.nextBoolean() ? 1 : -1);

                        BlockPos pos = new BlockPos(player.getPosition()).add(oX, 0, oZ);
                        pos = worldIn.getTopSolidOrLiquidBlock(pos);
                        if (pos.getDistance(MathHelper.floor(player.posX), MathHelper.floor(player.posY), MathHelper.floor(player.posZ)) > 75) {
                            return;
                        }

                        FluidRarityRegistry.ChunkFluidEntry at = FluidRarityRegistry.getChunkEntry(worldIn.getChunk(pos));
                        FluidStack display = at == null ? new FluidStack(FluidRegistry.WATER, 1) : at.tryDrain(1, false);
                        if (display == null || display.getFluid() == null)
                            display = new FluidStack(FluidRegistry.WATER, 1);
                        PktPlayLiquidSpring pkt = new PktPlayLiquidSpring(display, new Vector3(pos).add(rand.nextFloat(), 0, rand.nextFloat()));
                        PacketChannel.CHANNEL.sendToAllAround(pkt, PacketChannel.pointFromPos(worldIn, player.getPosition(), 32));
                    }
                    PacketHandler.sendTo(new PktItemEffectRender(itemstack), (EntityPlayerMP) player);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void playEffect() {
        playStarlightFieldEffect();
    }

    @SideOnly(Side.CLIENT)
    private void playStarlightFieldEffect() {
        if (!ConstellationSkyHandler.getInstance().getSeedIfPresent(Minecraft.getMinecraft().world).isPresent()) return;

        float nightPerc = ConstellationSkyHandler.getInstance().getCurrentDaytimeDistribution(Minecraft.getMinecraft().world);
        if (nightPerc >= 0.05) {
            Color c = new Color(0, 6, 58);
            BlockPos center = Minecraft.getMinecraft().player.getPosition();
            int offsetX = center.getX();
            int offsetZ = center.getZ();
            BlockPos.PooledMutableBlockPos pos = BlockPos.PooledMutableBlockPos.retain(center);

            for (int xx = -30; xx <= 30; xx++) {
                for (int zz = -30; zz <= 30; zz++) {

                    BlockPos top = Minecraft.getMinecraft().world.getTopSolidOrLiquidBlock(pos.setPos(offsetX + xx, 0, offsetZ + zz));
                    //Can be force unwrapped since statement 2nd Line prevents non-present values.
                    Float opF = SkyCollectionHelper.getSkyNoiseDistributionClient(Minecraft.getMinecraft().world, top).get();

                    float fPerc = (float) Math.pow((opF - 0.4F) * 1.65F, 2);
                    if (opF >= 0.4F && rand.nextFloat() <= fPerc) {
                        if (rand.nextFloat() <= fPerc && rand.nextInt(6) == 0) {
                            EffectHelper.genericFlareParticle(top.getX() + rand.nextFloat(), top.getY() + 0.15, top.getZ() + rand.nextFloat())
                                    .scale(4F)
                                    .setColor(c)
                                    .enableAlphaFade(EntityComplexFX.AlphaFunction.PYRAMID)
                                    .gravity(0.004)
                                    .setAlphaMultiplier(nightPerc * fPerc);
                            if (opF >= 0.8F && rand.nextInt(3) == 0) {
                                EffectHelper.genericFlareParticle(top.getX() + rand.nextFloat(), top.getY() + 0.15, top.getZ() + rand.nextFloat())
                                        .scale(0.3F)
                                        .setColor(Color.WHITE)
                                        .gravity(0.01)
                                        .setAlphaMultiplier(nightPerc);
                            }
                        }
                    }
                }
            }

            pos.release();
        }
    }

    public static void toggleRing(ItemStack stack) {
        if (!ItemHelper.getOrCreateTag(stack).getBoolean(TAG_ACTIVE)) stack.getTagCompound().setBoolean(TAG_ACTIVE, true);
        else stack.getTagCompound().setBoolean(TAG_ACTIVE, false);
    }

    @Override
    public boolean willAutoSync(ItemStack itemstack, EntityLivingBase player) {
        return true;
    }
}
