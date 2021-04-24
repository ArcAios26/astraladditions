package arcaios26.astraladditions.client.screen.journal.progression;

import arcaios26.astraladditions.client.lib.TexturesAA;
import hellfirepvp.astralsorcery.client.resource.AbstractRenderableTexture;
import hellfirepvp.astralsorcery.client.screen.journal.progression.JournalCluster;
import hellfirepvp.astralsorcery.client.screen.journal.progression.JournalProgressionClusterMapping;
import hellfirepvp.astralsorcery.common.data.research.ResearchProgression;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class AdditionalClusterMapping  {

    private static final Map<ResearchProgression, JournalCluster> clusterMapping = new HashMap<>();

    static {
        AbstractRenderableTexture tex = TexturesAA.TEX_GUI_CLUSTER_ASCENSION;
        register(ResearchProgression.valueOf("ASCENSION"), new JournalCluster(tex, tex, -5, -5, -1, -1));
    }

    public static void register(ResearchProgression prog, JournalCluster cluster) {
        clusterMapping.put(prog, cluster);
    }

    @Nonnull
    public static JournalCluster getClusterMapping(ResearchProgression progression) {
        JournalCluster cluster = clusterMapping.get(progression);
        if (cluster == null)
            return JournalProgressionClusterMapping.getClusterMapping(progression);

        return cluster;
    }
}
