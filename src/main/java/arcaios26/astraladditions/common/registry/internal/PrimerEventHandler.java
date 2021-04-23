package arcaios26.astraladditions.common.registry.internal;

import arcaios26.astraladditions.common.registry.BlocksRegistry;
import arcaios26.astraladditions.common.registry.ItemsRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class PrimerEventHandler {

    private final InternalRegistryPrimer registry;

    public PrimerEventHandler(InternalRegistryPrimer registry) {
        this.registry = registry;
    }

    public void attachEventHandlers(IEventBus bus) {
        bus.addGenericListener(Item.class, this::registerItems);
        bus.addGenericListener(Block.class, this::registerBlocks);
    }

    private void registerRemainingData() {}

    private void registerItems(RegistryEvent.Register<Item> event) {
        ItemsRegistry.registerItems();
        ItemsRegistry.registerBlockItems();
        fillRegistry(event.getRegistry().getRegistrySuperType(), event.getRegistry());
    }

    private void registerBlocks(RegistryEvent.Register<Block> event) {
        BlocksRegistry.registerBlocks();
        fillRegistry(event.getRegistry().getRegistrySuperType(), event.getRegistry());
    }

    private <T extends IForgeRegistryEntry<T>> void fillRegistry(Class<T> registrySuperType, IForgeRegistry<T> forgeRegistry) {
        registry.getEntries(registrySuperType).forEach(e -> forgeRegistry.register((T) e));
    }
}
