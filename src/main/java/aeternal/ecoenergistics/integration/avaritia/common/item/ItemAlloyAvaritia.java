package aeternal.ecoenergistics.integration.avaritia.common.item;

import aeternal.ecoenergistics.common.item.IMetaItem;
import aeternal.ecoenergistics.common.item.ItemMEE;
import aeternal.ecoenergistics.integration.avaritia.common.enums.AvaritiaTiers;
import morph.avaritia.api.IHaloRenderItem;
import morph.avaritia.init.AvaritiaTextures;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;

public class ItemAlloyAvaritia extends ItemMEE implements IMetaItem {

    public ItemAlloyAvaritia() {
        super();
        setHasSubtypes(true);
    }

    @Override
    public String getTexture(int meta) {
        return AvaritiaTiers.values()[meta].getSimpleName() + "Alloy";
    }

    @Override
    public int getVariants() {
        return AvaritiaTiers.values().length;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tabs, @Nonnull NonNullList<ItemStack> itemList) {
        if (isInCreativeTab(tabs)) {
            for (AvaritiaTiers tier : AvaritiaTiers.values()) {
                itemList.add(new ItemStack(this, 1, tier.ordinal()));
            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack item) {
        return "item." + AvaritiaTiers.values()[item.getItemDamage()].getSimpleName() + "Alloy";
    }

/*    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldDrawHalo(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        return (meta >= 0 && meta <= 2);
    }

    @Override
    @SideOnly (Side.CLIENT)
    public TextureAtlasSprite getHaloTexture(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        if (meta == 0 || meta == 1 || meta == 2) {
            return AvaritiaTextures.HALO_NOISE;
        }
        return AvaritiaTextures.HALO;
    }

    @Override
    @SideOnly (Side.CLIENT)
    public int getHaloColour(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        if (meta == 0) {
            return 0x33FFFFFF;
        }
        if (meta == 1) {
            return 0x4DFFFFFF;
        }
        return 0xFF000000;
    }

    @Override
    @SideOnly (Side.CLIENT)
    public int getHaloSize(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        switch (meta) {
            case 0:
            case 1:
                return 10;
        }
        return 8;
    }

    @Override
    @SideOnly (Side.CLIENT)
    public boolean shouldDrawPulse(ItemStack itemStack) {
        int meta = itemStack.getItemDamage();
        return meta == 0 || meta == 1 || meta == 2;
    }*/
}