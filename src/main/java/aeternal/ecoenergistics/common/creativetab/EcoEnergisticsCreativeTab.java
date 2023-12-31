package aeternal.ecoenergistics.common.creativetab;

import javax.annotation.Nonnull;


import aeternal.ecoenergistics.common.item.EcoEnergisticsItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EcoEnergisticsCreativeTab extends CreativeTabs {
    public EcoEnergisticsCreativeTab() {
        super("tabEcoEnergistics");
    }

    @Nonnull
    @Override
    public ItemStack createIcon() {
        return new ItemStack(EcoEnergisticsItems.MoreSolarCell);
    }
}