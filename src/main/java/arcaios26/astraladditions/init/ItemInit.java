package arcaios26.astraladditions.init;

import arcaios26.astraladditions.AstralAdditions;
import arcaios26.astraladditions.Config;
import arcaios26.astraladditions.Reference;
import arcaios26.astraladditions.objects.armor.ArmorBase;
import arcaios26.astraladditions.objects.baubles.ItemAstralRing;
import arcaios26.astraladditions.util.handlers.RegistryHandler;
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
    public static final ItemArmor.ArmorMaterial ARMOR_STARMETAL = EnumHelper.addArmorMaterial("armor_starmetal", Reference.MOD_ID + ":starmetal", 13, new int[]{2, 5, 6, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5F);

    //Baubles
    public static final Item RING_ASTRAL = new ItemAstralRing("ring_astral", AstralAdditions.AATAB);

    //Armor
    public static final Item HELMET_STARMETAL = new ArmorBase("helmet_starmetal", ARMOR_STARMETAL, 1, EntityEquipmentSlot.HEAD, AstralAdditions.AATAB);
    public static final Item CHESTPLATE_STARMETAL = new ArmorBase("chestplate_starmetal", ARMOR_STARMETAL, 1, EntityEquipmentSlot.CHEST, AstralAdditions.AATAB);
    public static final Item LEGGINGS_STARMETAL = new ArmorBase("leggings_starmetal", ARMOR_STARMETAL, 2, EntityEquipmentSlot.LEGS, AstralAdditions.AATAB);
    public static final Item BOOTS_STARMETAL = new ArmorBase("boots_starmetal", ARMOR_STARMETAL, 1, EntityEquipmentSlot.FEET, AstralAdditions.AATAB);

}
