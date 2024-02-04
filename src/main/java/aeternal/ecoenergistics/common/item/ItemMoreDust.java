package aeternal.ecoenergistics.common.item;

import java.util.Locale;
import javax.annotation.Nonnull;

import aeternal.ecoenergistics.common.enums.MoreDust;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

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
            for (int counter = 0; counter < MoreDust.values().length; counter++) {
                itemList.add(new ItemStack(this, 1, counter));
            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack item) {
        if (item.getItemDamage() <= MoreDust.values().length - 1) {
            return "item." + MoreDust.values()[item.getItemDamage()].getName().toLowerCase(Locale.ROOT) + "Dust";
        }
        return "Invalid";
    }
}