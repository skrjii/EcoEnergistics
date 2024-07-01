package aeternal.ecoenergistics.common.item;


import aeternal.ecoenergistics.common.enums.Rods;
import mekanism.common.base.IMetaItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ItemRods extends ItemMEE implements IMetaItem {

    public ItemRods() {
        super();
        setHasSubtypes(true);
    }

    @Override
    public String getTexture(int meta) {
        return Rods.values()[meta].getName() + "Rod";
    }

    @Override
    public int getVariants() {
        return Rods.values().length;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tabs, @Nonnull NonNullList<ItemStack> itemList) {
        if (isInCreativeTab(tabs)) {
            for (int counter = 0; counter < Rods.values().length; counter++) {
                itemList.add(new ItemStack(this, 1, counter));
            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack item) {
        if (item.getItemDamage() <= Rods.values().length - 1) {
            return "item." + Rods.values()[item.getItemDamage()].getName().toLowerCase(Locale.ROOT) + "Rod";
        }
        return "Invalid";
    }
}