package arcaios26.astraladditions.init;

import arcaios26.astraladditions.Reference;
import arcaios26.astraladditions.objects.armor.ArmorBase;
import arcaios26.astraladditions.objects.baubles.ItemAstralRing;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<Item> ITEMS = new ArrayList<Item>();
    //Material
    public static final ItemArmor.ArmorMaterial ARMOR_STARMETAL = EnumHelper.addArmorMaterial("armor_starmetal", Reference.MOD_ID + ":starmetal", 13, new int[]{2, 5, 5, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

    //Baubles
    public static final Item RING_ASTRAL = new ItemAstralRing("ring_astral", CreativeTabs.TOOLS);

    //Armor
    public static final Item HELMET_STARMETAL = new ArmorBase("helmet_starmetal", ARMOR_STARMETAL, 1, EntityEquipmentSlot.HEAD, CreativeTabs.COMBAT);
    public static final Item CHESTPLATE_STARMETAL = new ArmorBase("chestplate_starmetal", ARMOR_STARMETAL, 1, EntityEquipmentSlot.CHEST, CreativeTabs.COMBAT);
    public static final Item LEGGINGS_STARMETAL = new ArmorBase("leggings_starmetal", ARMOR_STARMETAL, 2, EntityEquipmentSlot.LEGS, CreativeTabs.COMBAT);
    public static final Item BOOTS_STARMETAL = new ArmorBase("boots_starmetal", ARMOR_STARMETAL, 1, EntityEquipmentSlot.FEET, CreativeTabs.COMBAT);
}
