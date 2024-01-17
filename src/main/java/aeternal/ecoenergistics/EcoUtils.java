package aeternal.ecoenergistics;
import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoTransmitter;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoTransmitter.EcoTransmitterType;
import aeternal.ecoenergistics.common.item.ItemBlockEcoTransmitter;
import aeternal.ecoenergistics.common.tier.MEETiers;
import mekanism.common.MekanismBlocks;

import mekanism.common.tier.BaseTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

import java.util.*;

/**
 * Utilities used by Mekanism. All miscellaneous methods are located here.
 *
 * @author AidanBrady
 */
public final class EcoUtils {

    public static final EnumFacing[] SIDE_DIRS = new EnumFacing[]{EnumFacing.NORTH, EnumFacing.SOUTH, EnumFacing.WEST, EnumFacing.EAST};

    public static final Map<String, Class<?>> classesFound = new HashMap<>();

    private static final List<UUID> warnedFails = new ArrayList<>();
    /**
     * Pre-calculated cache of translated block orientations
     */
    private static final EnumFacing[][] baseOrientations = new EnumFacing[EnumFacing.VALUES.length][EnumFacing.VALUES.length];



    public static ItemStack getEcoTransmitter(EcoTransmitterType type, MEETiers tier, int amount) {
        ItemStack stack = new ItemStack(EcoEnergisticsBlocks.EcoTransmitter, amount, type.ordinal());
        ItemBlockEcoTransmitter itemTransmitter = (ItemBlockEcoTransmitter) stack.getItem();
        itemTransmitter.setBaseTier(stack, tier);
        return stack;
    }


}