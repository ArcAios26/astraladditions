package arcaios26.astraladditions.client.registry;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.client.input.AAKeyBind;
import arcaios26.astraladditions.client.input.KeyToggleRing;
import hellfirepvp.astralsorcery.common.util.MiscUtils;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import static arcaios26.astraladditions.client.lib.KeyBindingsAA.KEY_TOGGLE_RING;

public class KeyBindingsRegistry {

    private static final Set<AAKeyBind> watchedBindings = new HashSet<>();
    private static final Set<AAKeyBind> bindingsPressed = new HashSet<>();

    public static void init () {
        KEY_TOGGLE_RING = register("toggle_ring", GLFW.GLFW_KEY_I, KeyToggleRing::new);

        MinecraftForge.EVENT_BUS.addListener(KeyBindingsRegistry::onKeyInput);
    }

    private static AAKeyBind register (String name, int glfwKey) {
        return register(name, glfwKey, keyBinding -> new AAKeyBind(keyBinding) {});
    }

    private static AAKeyBind register (String name, int glfwKey, Function<KeyBinding, AAKeyBind> aaKeyBindCreator) {
        KeyBinding keyBinding = new KeyBinding(String.format("key.%s.%s", AstralAdditions.MODID, name),
                KeyConflictContext.IN_GAME, InputMappings.Type.KEYSYM, glfwKey, AstralAdditions.NAME);
        ClientRegistry.registerKeyBinding(keyBinding);
        AAKeyBind aaKeyBind = aaKeyBindCreator.apply(keyBinding);
        watchedBindings.add(aaKeyBind);
        return aaKeyBind;
    }

    private static void onKeyInput(InputEvent.KeyInputEvent event) {
        InputMappings.Input input = InputMappings.getInputByCode(event.getKey(), event.getScanCode());
        AAKeyBind eventKey = MiscUtils.iterativeSearch(watchedBindings, aaKeyBind -> aaKeyBind.getKeyBind().getKey().equals(input));
        if (eventKey != null) {
            boolean isPressed = eventKey.getKeyBind().isKeyDown();
            boolean wasPressed = bindingsPressed.contains(eventKey);
            if (isPressed != wasPressed) {
                if (isPressed) {
                    bindingsPressed.add(eventKey);
                    eventKey.onKeyDown();
                } else {
                    bindingsPressed.remove(eventKey);
                    eventKey.onKeyUp();
                }
            }
        }
    }
}
