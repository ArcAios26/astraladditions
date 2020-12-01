package arcaios26.astraladditions.util;


import com.google.common.collect.ImmutableBiMap;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

@SideOnly(Side.CLIENT)
public class ClientKeyHelper {
    public static ImmutableBiMap<KeyBinding, AAKeyBind> fromMc;
    public static ImmutableBiMap<AAKeyBind, KeyBinding> toMc;

    public static void registerBindings() {
        ImmutableBiMap.Builder<KeyBinding, AAKeyBind> builder = ImmutableBiMap.builder();
        for (AAKeyBind k : AAKeyBind.values()) {
            KeyBinding mcK = new KeyBinding(k.keyName, k.defaultKeyCode, "key.categories.astraladditions");
            builder.put(mcK, k);
            ClientRegistry.registerKeyBinding(mcK);
        }
        fromMc = builder.build();
        toMc = fromMc.inverse();
    }

    public static String getKeyName(AAKeyBind k) {
        return getKeyName(toMc.get(k));
    }

    public static String getKeyName(KeyBinding k) {
        int keyCode = k.getKeyCode();
        if (keyCode > Keyboard.getKeyCount() || keyCode < 0) return k.getDisplayName();
        return Keyboard.getKeyName(keyCode);
    }
}
