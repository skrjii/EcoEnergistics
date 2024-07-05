package aeternal.ecoenergistics.common.item;

import aeternal.ecoenergistics.common.enums.MoreDust;
import mekanism.common.base.IMetaItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ItemMoreDust extends ItemMEE implements IMetaItem {

    public ItemMoreDust() {
        super();
        setHasSubtypes(true);
    }

    @Override
    public String getTexture(int meta) {
        return MoreDust.values()[meta].getName() + "Dust";
    }

    @Override
    public int getVariants() {
        return MoreDust.values().length;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tabs, @Nonnull NonNullList<ItemStack> itemList) {
        if (isInCreativeTab(tabs)) {
            for (MoreDust counter : MoreDust.values()) {
                itemList.add(new ItemStack(this, 1, counter.ordinal()));
            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack item) {
        return "item." + MoreDust.values()[item.getItemDamage()].getName().toLowerCase(Locale.ROOT) + "Dust";
    }
}