package aeternal.ecoenergistics.common.item;

import aeternal.ecoenergistics.common.enums.Compressed;
import mekanism.common.base.IMetaItem;
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
            for (Compressed counter : Compressed.values()) {
                itemList.add(new ItemStack(this, 1, counter.ordinal()));
            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack item) {
        return "item." + Compressed.values()[item.getItemDamage()].getName().toLowerCase(Locale.ROOT) + "Compressed";
    }
}
