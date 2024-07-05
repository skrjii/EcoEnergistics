package aeternal.ecoenergistics.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EcoEnergisticsCreativeTab extends CreativeTabs {

    public EcoEnergisticsCreativeTab() {
        super("tabEcoEnergistics");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(EcoEnergisticsItems.MoreSolarCell);
    }

}
