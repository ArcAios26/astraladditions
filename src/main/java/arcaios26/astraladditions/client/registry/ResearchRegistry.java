package arcaios26.astraladditions.client.registry;

import arcaios26.astraladditions.client.lib.TexturesAA;
import hellfirepvp.astralsorcery.client.resource.AbstractRenderableTexture;
import hellfirepvp.astralsorcery.client.screen.journal.progression.JournalCluster;
import hellfirepvp.astralsorcery.client.screen.journal.progression.JournalProgressionClusterMapping;
import hellfirepvp.astralsorcery.common.data.research.ProgressionTier;
import hellfirepvp.astralsorcery.common.data.research.ResearchProgression;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static arcaios26.astraladditions.client.lib.ResearchProgressionAA.ASCENSION;

public class ResearchRegistry {

    private static final  Map<ResearchProgression, Boolean> isClusterRegistered = new HashMap<>();

    private ResearchRegistry() {}

    public static void registerResearchProgressions() {
        ASCENSION = registerResearchProgression("ASCENSION", ProgressionTier.TRAIT_CRAFT, ResearchProgression.RADIANCE);
    }

    public static void registerClusters() {
        registerCluster(ASCENSION, TexturesAA.TEX_GUI_CLUSTER_ASCENSION);
    }

    private static ResearchProgression registerResearchProgression(String name, ProgressionTier tier, ResearchProgression requiredProgress) {
        ResearchProgression.create(name, tier, Collections.singletonList(requiredProgress));
        isClusterRegistered.put(ResearchProgression.valueOf(name), false);
        return ResearchProgression.valueOf(name);
    }

    private static void registerCluster(ResearchProgression prog, AbstractRenderableTexture tex) {
        boolean isRegistered = isClusterRegistered.get(prog);
        if (!isRegistered)
            JournalProgressionClusterMapping.register(prog, new JournalCluster(tex, tex, 2, -5, 5, -3));
    }
}
