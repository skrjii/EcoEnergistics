package aeternal.ecoenergistics.common.tier;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public interface IEcoAlloyInteraction {
    
    void onAlloyInteraction(EntityPlayer player, ItemStack stack, @NotNull MEEAlloyTier tier);
}
