package arcaios26.astraladditions.common.item.ring;

import arcaios26.astraladditions.common.CommonProxy;
import hellfirepvp.astralsorcery.client.data.config.entry.RenderingConfig;
import hellfirepvp.astralsorcery.client.effect.function.VFXColorFunction;
import hellfirepvp.astralsorcery.client.effect.handler.EffectHelper;
import hellfirepvp.astralsorcery.client.lib.EffectTemplatesAS;
import hellfirepvp.astralsorcery.common.constellation.world.DayTimeHelper;
import hellfirepvp.astralsorcery.common.lib.CapabilitiesAS;
import hellfirepvp.astralsorcery.common.lib.ColorsAS;
import hellfirepvp.astralsorcery.common.network.PacketChannel;
import hellfirepvp.astralsorcery.common.network.play.server.PktPlayEffect;
import hellfirepvp.astralsorcery.common.util.data.ByteBufUtils;
import hellfirepvp.astralsorcery.common.util.data.Vector3;
import hellfirepvp.astralsorcery.common.util.world.SkyCollectionHelper;
import hellfirepvp.astralsorcery.common.util.world.WorldSeedCache;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import top.theillusivec4.curios.api.type.capability.ICurio;
import top.theillusivec4.curios.common.capability.CurioItemCapability;

import javax.annotation.Nullable;

public class AstralRingItem extends Item {

    public AstralRingItem() {
        super(new Item.Properties().group(CommonProxy.ITEM_GROUP_AA).maxStackSize(1).defaultMaxDamage(0));
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
        return CurioItemCapability.createProvider(new ICurio() {
            @Override
            public void curioAnimate(String identifier, int index, LivingEntity livingEntity) {
                if (!(livingEntity instanceof PlayerEntity))
                    return;

                PlayerEntity player = (PlayerEntity) livingEntity;
                World world = player.getEntityWorld();

                if (WorldSeedCache.getSeedIfPresent(world.getDimensionKey()).isPresent()) {
                    float distribution = DayTimeHelper.getCurrentDaytimeDistribution(world);
                    if (distribution <= 1E-4) {
                        return;
                    }
                    BlockPos center = player.getPosition();
                    int offsetX = center.getX();
                    int offsetZ = center.getZ();
                    BlockPos.Mutable mPos = new BlockPos.Mutable();
                    int minY = RenderingConfig.CONFIG.minYFosicDisplay.get();

                    for (int xx = -48; xx <= 48; xx++) {
                        for (int zz = -48; zz <= 48; zz++) {
                            mPos.setPos(world.getHeight(Heightmap.Type.WORLD_SURFACE, mPos.setPos(offsetX + xx, 0, offsetZ + zz)));
                            mPos.setY(Math.max(mPos.getY(), minY));

                            float perc = SkyCollectionHelper.getSkyNoiseDistributionClient(world.getDimensionKey(), mPos).get();

                            float fPerc = (float) Math.pow((perc - 0.4F) * 1.65F, 2);
                            if (perc >= 0.4F && random.nextFloat() <= fPerc) {
                                if (random.nextFloat() <= fPerc && random.nextInt(6) == 0) {

                                    EffectHelper.of(EffectTemplatesAS.GENERIC_PARTICLE)
                                            .spawn(new Vector3(mPos).add(random.nextFloat(), 0.15, random.nextFloat()))
                                            .color(VFXColorFunction.constant(ColorsAS.RESONATOR_STARFIELD))
                                            .setScaleMultiplier(4F)
                                            .setAlphaMultiplier(distribution * fPerc);
                                    if (perc >= 0.8F && random.nextInt(3) == 0) {

                                        EffectHelper.of(EffectTemplatesAS.GENERIC_PARTICLE)
                                                .spawn(new Vector3(mPos).add(random.nextFloat(), 0.15, random.nextFloat()))
                                                .setScaleMultiplier(0.3F)
                                                .color(VFXColorFunction.WHITE)
                                                .setGravityStrength(-0.001F)
                                                .setAlphaMultiplier(distribution);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void curioTick(String identifier, int index, LivingEntity livingEntity) {
                World world = livingEntity.getEntityWorld();
                Entity entity = (Entity) livingEntity;

                if (!world.isRemote()) {

                    float distribution = DayTimeHelper.getCurrentDaytimeDistribution(world);
                    if (distribution <= 1E-4) {
                        return;
                    }
                    if (random.nextFloat() < distribution && random.nextInt(12) == 0) {
                        int offsetX = random.nextInt(30) * (random.nextBoolean() ? 1 : -1);
                        int offsetZ = random.nextInt(30) * (random.nextBoolean() ? 1 : -1);

                        BlockPos pos = world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                                new BlockPos(entity.getPosition()).add(offsetX, 0, offsetZ));
                        if (pos.distanceSq(entity.getPosition()) > 5625) { // 75 blocks away
                            return;
                        }

                        IChunk ch = world.getChunk(pos);
                        if (ch instanceof Chunk) {
                            ((Chunk) ch).getCapability(CapabilitiesAS.CHUNK_FLUID).ifPresent(entry -> {
                                FluidStack display = entry.drain(1, IFluidHandler.FluidAction.SIMULATE);
                                if (!display.isEmpty()) {
                                    PktPlayEffect pkt = new PktPlayEffect(PktPlayEffect.Type.LIQUID_FOUNTAIN).addData(buf -> {
                                        ByteBufUtils.writeFluidStack(buf, display);
                                        ByteBufUtils.writeVector(buf, new Vector3(pos));
                                    });
                                    PacketChannel.CHANNEL.sendToAllAround(pkt, PacketChannel.pointFromPos(world, pos, 32));
                                }
                            });
                        }
                    }

                }
            }
        });
    }
}
