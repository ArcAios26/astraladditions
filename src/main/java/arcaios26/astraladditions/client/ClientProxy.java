package arcaios26.astraladditions.client;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.client.lib.TexturesAA;
import arcaios26.astraladditions.client.registry.KeyBindingsRegistry;
import arcaios26.astraladditions.client.resource.AssetLibrary;
import arcaios26.astraladditions.client.resource.AssetPreLoader;
import arcaios26.astraladditions.common.CommonProxy;
import hellfirepvp.astralsorcery.client.resource.AbstractRenderableTexture;
import hellfirepvp.astralsorcery.client.screen.journal.progression.JournalCluster;
import hellfirepvp.astralsorcery.client.screen.journal.progression.JournalProgressionClusterMapping;
import hellfirepvp.astralsorcery.common.data.research.ResearchProgression;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void initialize() {
        if (!AstralAdditions.isDoingDataGeneration()) {
            IReloadableResourceManager resourceManager = (IReloadableResourceManager) Minecraft.getInstance().getResourceManager();
            resourceManager.addReloadListener(AssetLibrary.INSTANCE);
            resourceManager.addReloadListener(AssetPreLoader.INSTANCE);
        }

        super.initialize();
    }

    @Override
    public void attachLifecycle(IEventBus modEventBus) {
        super.attachLifecycle(modEventBus);

        modEventBus.addListener(this::onClientSetup);
    }

    @Override
    public void attachEventHandlers(IEventBus eventBus) {
        super.attachEventHandlers(eventBus);
    }

    private void onClientSetup(FMLClientSetupEvent event) {
        KeyBindingsRegistry.init();


    }
}
