package aeternal.ecoenergistics.common.item;

import aeternal.ecoenergistics.common.enums.Ingot;
import mekanism.common.base.IMetaItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ItemNugget extends ItemMEE implements IMetaItem {

    public ItemNugget() {
        super();
        setHasSubtypes(true);
    }

    @Override
    public String getTexture(int meta) {
        return Ingot.values()[meta].getName() + "Nugget";
    }

    @Override
    public int getVariants() {
        return Ingot.values().length;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tabs, @Nonnull NonNullList<ItemStack> itemList) {
        if (isInCreativeTab(tabs)) {
            for (Ingot counter : Ingot.values()) {
                itemList.add(new ItemStack(this, 1, counter.ordinal()));
            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack item) {
        return "item." + Ingot.values()[item.getItemDamage()].getName().toLowerCase(Locale.ROOT) + "Nugget";
    }
}