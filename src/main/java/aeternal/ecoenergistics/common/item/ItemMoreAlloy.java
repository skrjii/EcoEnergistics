package aeternal.ecoenergistics.common.item;

import aeternal.ecoenergistics.common.capabilities.EcoCapabilities;
import aeternal.ecoenergistics.common.tier.IEcoAlloyInteraction;
import aeternal.ecoenergistics.common.tier.MEEAlloyTier;
import mekanism.common.base.IMetaItem;
import mekanism.common.config.MekanismConfig;
import mekanism.common.util.CapabilityUtils;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Locale;

public class ItemMoreAlloy extends ItemMEE implements IMetaItem {

    public ItemMoreAlloy() {
        super();
        setHasSubtypes(true);
    }

    @Override
    public String getTexture(int meta) {
        return MEEAlloyTier.values()[meta].getName() + "Alloy";
    }

    @Override
    public int getVariants() {
        return MEEAlloyTier.values().length;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tabs, @Nonnull NonNullList<ItemStack> itemList) {
        if (isInCreativeTab(tabs)) {
            for (MEEAlloyTier tier : MEEAlloyTier.values()) {
                itemList.add(new ItemStack(this, 1, tier.ordinal()));
            }
        }
    }

    @Override
    public String getItemStackDisplayName(@Nonnull ItemStack itemstack) {
        if (itemstack.getItem() == this) {
            return MEEAlloyTier.values()[itemstack.getItemDamage()].getColor() + super.getItemStackDisplayName(itemstack);
        }
        return super.getItemStackDisplayName(itemstack);
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack item) {
        return "item." + MEEAlloyTier.values()[item.getItemDamage()].getName().toLowerCase(Locale.ROOT) + "Alloy";
    }


    @Nonnull
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tile = world.getTileEntity(pos);
        ItemStack stack = player.getHeldItem(hand);
        if (MekanismConfig.current().general.allowTransmitterAlloyUpgrade.val() && CapabilityUtils.hasCapability(tile, EcoCapabilities.ALLOY_INTERACTION_CAPABILITY,side)){
            if (!world.isRemote) {
                IEcoAlloyInteraction interaction  = CapabilityUtils.getCapability(tile,EcoCapabilities.ALLOY_INTERACTION_CAPABILITY,side);
                interaction.onAlloyInteraction(player, stack, MEEAlloyTier.values()[stack.getItemDamage()]);
            }
            return EnumActionResult.SUCCESS;
        }
        return EnumActionResult.PASS;
    }

}