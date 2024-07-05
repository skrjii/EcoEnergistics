package aeternal.ecoenergistics.common.capabilities;

import aeternal.ecoenergistics.common.tier.IEcoAlloyInteraction;
import aeternal.ecoenergistics.common.tier.MEEAlloyTier;
import mekanism.common.capabilities.DefaultStorageHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.CapabilityManager;
import org.jetbrains.annotations.NotNull;

public class DefaultEcoAlloyInteraction  implements IEcoAlloyInteraction {

    public static void register() {
        CapabilityManager.INSTANCE.register(IEcoAlloyInteraction.class,new DefaultStorageHelper.NullStorage<>(),DefaultEcoAlloyInteraction::new);
    }

    @Override
    public void onAlloyInteraction(EntityPlayer player, ItemStack stack, @NotNull MEEAlloyTier tier) {

    }
}
