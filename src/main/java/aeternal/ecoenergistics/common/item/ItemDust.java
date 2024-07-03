package aeternal.ecoenergistics.common.item;


import aeternal.ecoenergistics.common.enums.Dust;
import mekanism.common.base.IMetaItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ItemDust extends ItemMEE implements IMetaItem {

    public ItemDust() {
        super();
        setHasSubtypes(true);
    }

    @Override
    public String getTexture(int meta) {
        return Dust.values()[meta].getName() + "Dust";
    }

    @Override
    public int getVariants() {
        return Dust.values().length;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tabs, @Nonnull NonNullList<ItemStack> itemList) {
        if (isInCreativeTab(tabs)) {
            for (Dust counter : Dust.values()) {
                itemList.add(new ItemStack(this, 1, counter.ordinal()));
            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack item) {
        return "item." + Dust.values()[item.getItemDamage()].getName().toLowerCase(Locale.ROOT) + "Dust";
    }
}