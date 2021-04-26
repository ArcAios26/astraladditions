package arcaios26.astraladditions.common;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.client.registry.ResearchRegistry;
import arcaios26.astraladditions.common.integrations.CuriosIntegration;
import arcaios26.astraladditions.common.registry.internal.InternalRegistryPrimer;
import arcaios26.astraladditions.common.registry.internal.PrimerEventHandler;
import hellfirepvp.astralsorcery.common.base.Mods;
import hellfirepvp.astralsorcery.common.data.research.ProgressionTier;
import hellfirepvp.astralsorcery.common.data.research.ResearchProgression;
import hellfirepvp.astralsorcery.common.integration.IntegrationCurios;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;

import java.util.Collections;

import static arcaios26.astraladditions.common.lib.BlocksAA.MARBLE_WALL;

public class CommonProxy {

    public static final ItemGroup ITEM_GROUP_AA = new ItemGroup(AstralAdditions.MODID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(MARBLE_WALL.getBlock());
        }
    };

    private InternalRegistryPrimer registryPrimer;
    private PrimerEventHandler registryEventHandler;

    public void initialize() {
        this.registryPrimer = new InternalRegistryPrimer();
        this.registryEventHandler = new PrimerEventHandler(this.registryPrimer);

       //Register new ResearchProgressions
        ResearchRegistry.registerResearchProgressions();
    }

    public void attachLifecycle(IEventBus modEventBus) {
        modEventBus.addListener(this::onCommonSetup);
        modEventBus.addListener(this::onEnqueueIMC);

        registryEventHandler.attachEventHandlers(modEventBus);
    }

    public void attachEventHandlers(IEventBus eventBus) {

    }

    private void onCommonSetup(FMLCommonSetupEvent event) {

    }

    private void onEnqueueIMC(InterModEnqueueEvent event) {
        Mods.CURIOS.executeIfPresent(() -> CuriosIntegration::initIMC);
    }

    public InternalRegistryPrimer getRegistryPrimer() {
        return registryPrimer;
    }
}
