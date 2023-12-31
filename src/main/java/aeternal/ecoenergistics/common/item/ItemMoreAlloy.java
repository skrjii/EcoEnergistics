package aeternal.ecoenergistics.common.item;

import java.util.Locale;
import javax.annotation.Nonnull;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemMoreAlloy extends ItemMEE implements IMetaItem {

    public static String[] en_USNames = {"Advanced", "Hybrid", "PerfectHybrid", "Quantum", "Spectral", "Protonic", "Singular","Diffractive","Photonic","Neutron",};

    public ItemMoreAlloy() {
        super();
        setHasSubtypes(true);
    }

    @Override
    public String getTexture(int meta) {
        return en_USNames[meta] + "Alloy";
    }

    @Override
    public int getVariants() {
        return en_USNames.length;
    }

    @Override
    public void getSubItems(@Nonnull CreativeTabs tabs, @Nonnull NonNullList<ItemStack> itemList) {
        if (isInCreativeTab(tabs)) {
            for (int counter = 0; counter < en_USNames.length; counter++) {
                itemList.add(new ItemStack(this, 1, counter));
            }
        }
    }

    @Nonnull
    @Override
    public String getTranslationKey(ItemStack item) {
        return "item." + en_USNames[item.getItemDamage()].toLowerCase(Locale.ROOT) + "Alloy";
    }
}