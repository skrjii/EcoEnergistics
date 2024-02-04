package aeternal.ecoenergistics.common.base;


import aeternal.ecoenergistics.common.tier.MEETiers;
import net.minecraft.item.ItemStack;

public interface ITierItem {

    MEETiers getBaseTier(ItemStack stack);

    void setBaseTier(ItemStack stack, MEETiers tier);
}