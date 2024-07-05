package aeternal.ecoenergistics.common.item;

import java.util.List;
import javax.annotation.Nonnull;

import aeternal.ecoenergistics.common.EcoEnergistics;
import aeternal.ecoenergistics.common.base.EcoITierItem;
import aeternal.ecoenergistics.common.tier.EcoCableTier;
import aeternal.ecoenergistics.common.tier.EcoPipeTier;
import aeternal.ecoenergistics.common.tier.EcoTubeTier;
import aeternal.ecoenergistics.common.tier.MEETiers;
import aeternal.ecoenergistics.common.tile.transmitter.TileEntityEcoSidedPipe;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoTransmitter.EcoTransmitterType;
import mcmultipart.api.multipart.IMultipart;
import mekanism.api.EnumColor;
import mekanism.api.transmitters.TransmissionType;
import mekanism.client.MekKeyHandler;
import mekanism.client.MekanismKeyHandler;
import mekanism.common.Mekanism;
import mekanism.common.integration.MekanismHooks;
import mekanism.common.integration.multipart.MultipartMekanism;
import mekanism.common.item.ItemBlockMultipartAble;


import mekanism.common.util.LangUtils;
import mekanism.common.util.MekanismUtils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockEcoTransmitter extends ItemBlockMultipartAble implements EcoITierItem {

    public Block metaBlock;

    public ItemBlockEcoTransmitter(Block block) {
        super(block);
        metaBlock = block;
        setHasSubtypes(true);
        setCreativeTab(EcoEnergistics.tabEcoEnergistics);
    }

    @Override
    public int getMetadata(int i) {
        return i;
    }

    @Override
    public boolean placeBlockAt(@Nonnull ItemStack stack, @Nonnull EntityPlayer player, World world, @Nonnull BlockPos pos, EnumFacing side, float hitX, float hitY,
                                float hitZ, @Nonnull IBlockState state) {
        boolean place = super.placeBlockAt(stack, player, world, pos, side, hitX, hitY, hitZ, state);
        if (place) {
            TileEntityEcoSidedPipe tileEntity = (TileEntityEcoSidedPipe) world.getTileEntity(pos);
            tileEntity.setBaseTier(getBaseTier(stack));
            if (!world.isRemote) {
                Mekanism.packetHandler.sendUpdatePacket(tileEntity);
            }
        }
        return place;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@Nonnull ItemStack itemstack, World world, @Nonnull List<String> list, @Nonnull ITooltipFlag flag) {
        if (!MekKeyHandler.getIsKeyPressed(MekanismKeyHandler.sneakKey)) {
            TransmissionType transmission = EcoTransmitterType.values()[itemstack.getItemDamage()].getTransmission();
            MEETiers tier = getBaseTier(itemstack);
            if (transmission == TransmissionType.ENERGY) {
                list.add(EnumColor.INDIGO + LangUtils.localize("tooltip.capacity") + ": " + EnumColor.GREY +
                        MekanismUtils.getEnergyDisplay(EcoCableTier.get(tier).getCableCapacity()) + "/t");
            } else if (transmission == TransmissionType.FLUID) {
                list.add(EnumColor.INDIGO + LangUtils.localize("tooltip.capacity") + ": " + EnumColor.GREY + EcoPipeTier.get(tier).getPipeCapacity() + "mB/t");
                list.add(EnumColor.INDIGO + LangUtils.localize("tooltip.pumpRate") + ": " + EnumColor.GREY + EcoPipeTier.get(tier).getPipePullAmount() + "mB/t");
            } else if (transmission == TransmissionType.GAS) {
                list.add(EnumColor.INDIGO + LangUtils.localize("tooltip.capacity") + ": " + EnumColor.GREY + EcoTubeTier.get(tier).getTubeCapacity() + "mB/t");
                list.add(EnumColor.INDIGO + LangUtils.localize("tooltip.pumpRate") + ": " + EnumColor.GREY + EcoTubeTier.get(tier).getTubePullAmount() + "mB/t");
            } /*else if (transmission == TransmissionType.ITEM) {
                list.add(EnumColor.INDIGO + LangUtils.localize("tooltip.speed") + ": " + EnumColor.GREY + (TransporterTier.get(tier).getSpeed() / (100 / 20)) + " m/s");
                list.add(EnumColor.INDIGO + LangUtils.localize("tooltip.pumpRate") + ": " + EnumColor.GREY + TransporterTier.get(tier).getPullAmount() * 2 + "/s");
            } else if (transmission == TransmissionType.HEAT) {
                list.add(EnumColor.INDIGO + LangUtils.localize("tooltip.conduction") + ": " + EnumColor.GREY + ConductorTier.get(tier).getInverseConduction());
                list.add(EnumColor.INDIGO + LangUtils.localize("tooltip.insulation") + ": " + EnumColor.GREY + ConductorTier.get(tier).getBaseConductionInsulation());
                list.add(EnumColor.INDIGO + LangUtils.localize("tooltip.heatCapacity") + ": " + EnumColor.GREY + ConductorTier.get(tier).getInverseHeatCapacity());
            }*/
            list.add(LangUtils.localize("tooltip.hold") + " " + EnumColor.AQUA + GameSettings.getKeyDisplayString(MekanismKeyHandler.sneakKey.getKeyCode()) +
                    EnumColor.GREY + " " + LangUtils.localize("tooltip.forDetails"));
        } else {
            EcoTransmitterType type = EcoTransmitterType.values()[itemstack.getItemDamage()];
            switch (type) {
                case UNIVERSAL_CABLE:
                    list.add(EnumColor.DARK_GREY + LangUtils.localize("tooltip.capableTrans") + ":");
                    list.add("- " + EnumColor.PURPLE + "RF " + EnumColor.GREY + "(ThermalExpansion)");
                    list.add("- " + EnumColor.PURPLE + "EU " + EnumColor.GREY + "(IndustrialCraft)");
                    list.add("- " + EnumColor.PURPLE + "Joules " + EnumColor.GREY + "(Mekanism)");
                    break;
                case MECHANICAL_PIPE:
                    list.add(EnumColor.DARK_GREY + LangUtils.localize("tooltip.capableTrans") + ":");
                    list.add("- " + EnumColor.PURPLE + LangUtils.localize("tooltip.fluids") + " " + EnumColor.GREY + "(MinecraftForge)");
                    break;
                case PRESSURIZED_TUBE:
                    list.add(EnumColor.DARK_GREY + LangUtils.localize("tooltip.capableTrans") + ":");
                    list.add("- " + EnumColor.PURPLE + LangUtils.localize("tooltip.gasses") + " (Mekanism)");
                    break;

            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack stack) {
        EcoTransmitterType type = EcoTransmitterType.get(stack.getItemDamage());
        String name = type.getTranslationKey();
        if (type.hasTiers()) {
            MEETiers tier = getBaseTier(stack);
            name = tier.getSimpleName() + name;
        }
        return getTranslationKey() + "." + name;
    }

    @Override
    public MEETiers getBaseTier(ItemStack itemstack) {
        if (!itemstack.hasTagCompound()) {
            return MEETiers.ADVANCED;
        }
        return MEETiers.values()[itemstack.getTagCompound().getInteger("tier")];
    }

    @Override
    public void setBaseTier(ItemStack itemstack, MEETiers tier) {
        if (!itemstack.hasTagCompound()) {
            itemstack.setTagCompound(new NBTTagCompound());
        }
        itemstack.getTagCompound().setInteger("tier", tier.ordinal());
    }

    @Override
    @Optional.Method(modid = MekanismHooks.MCMULTIPART_MOD_ID)
    protected IMultipart getMultiPart() {
        return MultipartMekanism.TRANSMITTER_MP;
    }
}