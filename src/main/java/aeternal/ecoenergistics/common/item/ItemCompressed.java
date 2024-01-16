package aeternal.ecoenergistics.common.item;


import aeternal.ecoenergistics.common.enums.Compressed;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ItemCompressed extends ItemMEE implements IMetaItem {

    public ItemCompressed() {
        super();
        setHasSubtypes(true);
    }

    @Override
    public String getTexture(int meta) {
        return Compressed.values()[meta].getName() + "Compressed";
    }

    @Override
    public int getVariants() {
        return Compressed.values().length;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tabs, @Nonnull NonNullList<ItemStack> itemList) {
        if (isInCreativeTab(tabs)) {
            for (int counter = 0; counter < Compressed.values().length; counter++) {
                itemList.add(new ItemStack(this, 1, counter));
            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack item) {
        if (item.getItemDamage() <= Compressed.values().length - 1) {
            return "item." + Compressed.values()[item.getItemDamage()].getName().toLowerCase(Locale.ROOT) + "Compressed";
        }
        return "Invalid";
    }
}