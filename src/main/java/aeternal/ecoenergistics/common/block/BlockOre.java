package aeternal.ecoenergistics.common.block;

import javax.annotation.Nonnull;

import aeternal.ecoenergistics.EcoEnergistics;
import aeternal.ecoenergistics.common.block.states.BlockStateOre;
import aeternal.ecoenergistics.common.block.states.BlockStateOre.EnumOreType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockOre extends Block {

    public BlockOre() {
        super(Material.ROCK);
        setHardness(3F);
        setResistance(5F);
        setCreativeTab(EcoEnergistics.tabEcoEnergistics);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateOre(this);
    }

    @Nonnull
    @Override
    @Deprecated
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(BlockStateOre.typeProperty, BlockStateOre.EnumOreType.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(BlockStateOre.typeProperty).ordinal();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(CreativeTabs creativetabs, NonNullList<ItemStack> list) {
        for (EnumOreType ore : EnumOreType.values()) {
            list.add(new ItemStack(this, 1, ore.ordinal()));
        }
    }
}