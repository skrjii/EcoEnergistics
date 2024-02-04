package aeternal.ecoenergistics.common.block.states;


import aeternal.ecoenergistics.common.block.BlockBasic;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.IStringSerializable;

import java.util.Locale;


public class BlockStateBasic extends BlockStateContainer {

    public static final PropertyEnum<EnumBasicType> typeProperty = PropertyEnum.create("type", EnumBasicType.class);

    public BlockStateBasic(BlockBasic block) {
        super(block, typeProperty);
    }

    public enum EnumBasicType implements IStringSerializable {
        TITANIUM,
        URANIUM,
        IRIDIUM;

        @Override
        public String getName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}