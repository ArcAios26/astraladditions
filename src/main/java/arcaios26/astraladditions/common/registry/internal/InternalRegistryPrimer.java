package arcaios26.astraladditions.common.registry.internal;

import com.google.common.collect.Lists;
import hellfirepvp.astralsorcery.common.util.MiscUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InternalRegistryPrimer {

    private final Map<Class<?>, List<IForgeRegistryEntry<?>>> primed = new HashMap<>();

    public <V extends IForgeRegistryEntry<V>> V register(V entry) {
        Class<V> type = entry.getRegistryType();
        List<IForgeRegistryEntry<?>> entries = primed.computeIfAbsent(type, k -> Lists.newLinkedList());
        entries.add(entry);
        return entry;
    }

    <T extends IForgeRegistryEntry<T>> List<?> getEntries(Class<T> type) {
        return primed.getOrDefault(type, Collections.emptyList());
    }

    @Nullable
    public <V extends IForgeRegistryEntry<V>> V getCached(IForgeRegistry<V> registry, ResourceLocation key) {
        return (V) MiscUtils.iterativeSearch(this.primed.getOrDefault(registry.getRegistrySuperType(), Collections.emptyList()),
                entry -> entry.getRegistryName().equals(key));
    }

}
