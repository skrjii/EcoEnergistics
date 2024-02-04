package aeternal.ecoenergistics;

import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoTransmitter.EcoTransmitterType;
import aeternal.ecoenergistics.common.item.ItemBlockEcoTransmitter;
import aeternal.ecoenergistics.common.tier.MEETiers;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

import java.util.*;

public final class EcoUtils {

    public static final EnumFacing[] SIDE_DIRS = new EnumFacing[]{EnumFacing.NORTH, EnumFacing.SOUTH, EnumFacing.WEST, EnumFacing.EAST};

    public static final Map<String, Class<?>> classesFound = new HashMap<>();

    private static final List<UUID> warnedFails = new ArrayList<>();

    private static final EnumFacing[][] baseOrientations = new EnumFacing[EnumFacing.VALUES.length][EnumFacing.VALUES.length];

    public static ItemStack getEcoTransmitter(EcoTransmitterType type, MEETiers tier, int amount) {
        ItemStack stack = new ItemStack(EcoEnergisticsBlocks.EcoTransmitter, amount, type.ordinal());
        ItemBlockEcoTransmitter itemTransmitter = (ItemBlockEcoTransmitter) stack.getItem();
        itemTransmitter.setBaseTier(stack, tier);
        return stack;
    }


}