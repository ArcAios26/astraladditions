package arcaios26.astraladditions.util;

import org.lwjgl.input.Keyboard;

public enum AAKeyBind {
    RING_TOGGLE("astraladditions.key.ring_toggle", Keyboard.KEY_NUMPAD0);

    public final String keyName;
    public final int defaultKeyCode;

    AAKeyBind(String keyName, int defaultKeyCode) {
        this.keyName = keyName;
        this.defaultKeyCode = defaultKeyCode;
    }
}
