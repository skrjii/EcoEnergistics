package aeternal.ecoenergistics.common.block.states;

import java.util.Locale;
import aeternal.ecoenergistics.common.block.BlockOre;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.IStringSerializable;


public class BlockStateOre extends BlockStateContainer {

    public static final PropertyEnum<EnumOreType> typeProperty = PropertyEnum.create("type", EnumOreType.class);

    public BlockStateOre(BlockOre block) {
        super(block, typeProperty);
    }

    public enum EnumOreType implements IStringSerializable {
        TITANIUM,
        URANIUM,
        IRIDIUM;

        @Override
        public String getName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}