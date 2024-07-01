package aeternal.ecoenergistics.common.item;

import aeternal.ecoenergistics.common.enums.AvaritiaTiers;
import mekanism.common.base.IMetaItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public class ItemControlCircuitAvaritia extends ItemMEE implements IMetaItem {

    public ItemControlCircuitAvaritia() {
        super();
        setHasSubtypes(true);
    }

    @Override
    public String getTexture(int meta) {
        return AvaritiaTiers.values()[meta].getSimpleName() + "ControlCircuit";
    }

    @Override
    public int getVariants() {
        return AvaritiaTiers.values().length;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tabs, @Nonnull NonNullList<ItemStack> itemList) {
        if (isInCreativeTab(tabs)) {
            for (AvaritiaTiers tier : AvaritiaTiers.values()) {
                itemList.add(new ItemStack(this, 1, tier.ordinal()));
            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack item) {
        return "item." + AvaritiaTiers.values()[item.getItemDamage()].getSimpleName() + "ControlCircuit";
    }

    @Override
    public String getItemStackDisplayName(@Nonnull ItemStack itemstack) {
        if (itemstack.getItem() == this) {
            return AvaritiaTiers.values()[itemstack.getItemDamage()].getColor() + super.getItemStackDisplayName(itemstack);
        }
        return super.getItemStackDisplayName(itemstack);
    }
}
