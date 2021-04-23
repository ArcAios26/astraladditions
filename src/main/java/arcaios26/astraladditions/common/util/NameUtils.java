package arcaios26.astraladditions.common.util;

import arcaios26.astraladditions.AstralAdditions;
import com.google.common.base.CaseFormat;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class NameUtils {

    public static ResourceLocation fromClass(Object object) {
        return fromClass(object, null);
    }

    public static ResourceLocation fromClass(Class<?> object) {
        return fromClass(object, null);
    }

    public static ResourceLocation fromClass(Object object, @Nullable String cutPrefix) {
        return fromClass(object, cutPrefix, null);
    }

    public static ResourceLocation fromClass(Class<?> object, @Nullable String cutPrefix) {
        return fromClass(object, cutPrefix, null);
    }

    public static ResourceLocation fromClass(Object object, @Nullable String cutPrefix, @Nullable String cutSuffix) {
        return fromClass(object.getClass(), cutPrefix, cutSuffix);
    }

    public static ResourceLocation fromClass(Class<?> object, @Nullable String cutPrefix, @Nullable String cutSuffix) {
        String name = object.getSimpleName();
        if (object.getEnclosingClass() != null) {
            name = object.getEnclosingClass().getSimpleName() + name;
        }
        if (cutPrefix != null && name.startsWith(cutPrefix)) {
            name = name.substring(cutPrefix.length());
        }
        if (cutSuffix != null && name.endsWith(cutSuffix)) {
            name = name.substring(0, name.length() - cutSuffix.length());
        }
        name = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, name);
        return AstralAdditions.key(name);
    }
}
