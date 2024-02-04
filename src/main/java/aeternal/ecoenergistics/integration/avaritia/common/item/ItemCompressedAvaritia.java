package aeternal.ecoenergistics.integration.avaritia.common.item;

import aeternal.ecoenergistics.common.item.IMetaItem;
import aeternal.ecoenergistics.common.item.ItemMEE;
import aeternal.ecoenergistics.integration.avaritia.common.enums.AvaritiaTiers;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public class ItemCompressedAvaritia extends ItemMEE implements IMetaItem {

    public ItemCompressedAvaritia() {
        super();
        setHasSubtypes(true);
    }

    @Override
    public String getTexture(int meta) {
        return AvaritiaTiers.values()[meta].getSimpleName() + "Compressed";
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
        return "item." + AvaritiaTiers.values()[item.getItemDamage()].getSimpleName() + "Compressed";
    }
}