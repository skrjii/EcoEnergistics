package aeternal.ecoenergistics.common.block;

import aeternal.ecoenergistics.EcoEnergistics;

import aeternal.ecoenergistics.common.block.states.BlockStateBasic;
import aeternal.ecoenergistics.common.block.states.BlockStateBasic.EnumBasicType;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import javax.annotation.Nonnull;

public class BlockBasic extends Block {

    public BlockBasic() {
        super(Material.ROCK);
        setHardness(3F);
        setResistance(5F);
        setCreativeTab(EcoEnergistics.tabEcoEnergistics);
    }

    @Nonnull
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateBasic(this);
    }

    @Nonnull
    @Override
    @Deprecated
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(BlockStateBasic.typeProperty, EnumBasicType.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(BlockStateBasic.typeProperty).ordinal();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(CreativeTabs creativetabs, NonNullList<ItemStack> list) {
        for (EnumBasicType ore : EnumBasicType.values()) {
            list.add(new ItemStack(this, 1, ore.ordinal()));
        }
    }
}