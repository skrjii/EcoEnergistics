package aeternal.ecoenergistics.client.jei;

import aeternal.ecoenergistics.common.EcoEnergistics;
import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import aeternal.ecoenergistics.common.config.EcoConfig;
import mekanism.client.jei.MekanismJEI;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.JEIPlugin;
import net.minecraft.item.Item;

@JEIPlugin
public class EcoEnergisticsJEI implements IModPlugin {

    @Override
    public void registerItemSubtypes(ISubtypeRegistry registry) {
        registry.registerSubtypeInterpreter(Item.getItemFromBlock(EcoEnergisticsBlocks.EcoGenerator), MekanismJEI.NBT_INTERPRETER);
        registry.registerSubtypeInterpreter(Item.getItemFromBlock(EcoEnergisticsBlocks.EcoGeneratorAdd), MekanismJEI.NBT_INTERPRETER);
        if (EcoEnergistics.hooks.AvaritiaLoaded && EcoConfig.current().integration.AvaritiaEnable.val()){
            registry.registerSubtypeInterpreter(Item.getItemFromBlock(EcoEnergisticsBlocks.AvaritiaGenerator), MekanismJEI.NBT_INTERPRETER);
        }
    }
}
