package arcaios26.astraladditions.client.input;

import net.minecraft.client.settings.KeyBinding;

public abstract class AAKeyBind {

    private final KeyBinding keyBind;

    protected AAKeyBind(KeyBinding keyBind) {
        this.keyBind = keyBind;
    }

    public KeyBinding getKeyBind() { return keyBind; }

    public void onKeyDown() {}

    public void onKeyUp() {}
}
