package aeternal.ecoenergistics.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * Item class for handling multiple ore block IDs. 0: Osmium Ore 1: Copper Ore 2: Tin Ore
 *
 * @author AidanBrady
 */
public class ItemBlockBasic extends ItemBlock {

    public Block metaBlock;

    public ItemBlockBasic(Block block) {
        super(block);
        metaBlock = block;
        setHasSubtypes(true);
    }


    @Override
    public int getMetadata(int i) {
        return i;
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack itemstack) {
        String name;
        switch (itemstack.getItemDamage()) {
            case 0:
                name = "TitaniumBlock";
                break;
            case 1:
                name = "UraniumBlock";
                break;
            case 2:
                name = "IridiumBlock";
                break;
            default:
                name = "Unknown";
                break;
        }
        return getTranslationKey() + "." + name;
    }
}