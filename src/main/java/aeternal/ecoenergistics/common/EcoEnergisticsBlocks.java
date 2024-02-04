package aeternal.ecoenergistics.common;


import aeternal.ecoenergistics.Constants;
import aeternal.ecoenergistics.common.block.*;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoGenerator;
import aeternal.ecoenergistics.common.block.states.BlockStateEcoGeneratorAdd;
import aeternal.ecoenergistics.common.item.*;

import aeternal.ecoenergistics.integration.avaritia.common.block.BlockIntegratedAvaritiaGenerator;
import aeternal.ecoenergistics.integration.avaritia.common.block.states.BlockStateIntegratedAVAGenerator;
import aeternal.ecoenergistics.integration.avaritia.common.item.ItemBlockAvaritiaGenerator;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Constants.MOD_ID)
public class EcoEnergisticsBlocks {

    public static final Block EcoGenerator = BlockEcoGenerator.getGeneratorBlock(BlockStateEcoGenerator.EcoGeneratorBlock.GENERATOR_BLOCK_ECO);
    public static final Block EcoGeneratorAdd = BlockEcoGeneratorAdd.getGeneratorBlock(BlockStateEcoGeneratorAdd.EcoGeneratorBlock.GENERATOR_BLOCK_ECO2);
    public static Block EcoTransmitter = new BlockEcoTransmitter();
    public static Block OreBlock = new BlockOre();
    public static Block BlockBasic = new BlockBasic();

    public static final Block AvaritiaGenerator = BlockIntegratedAvaritiaGenerator.getGeneratorBlock(BlockStateIntegratedAVAGenerator.AvaritiaGeneratorBlock.GENERATOR_BLOCK_AVARITIA);

    public static void registerBlocks(IForgeRegistry<Block> registry) {
        registry.register(init(EcoGenerator, "EcoGenerator"));
        registry.register(init(EcoGeneratorAdd, "EcoGeneratorAdd"));
        registry.register(init(EcoTransmitter, "EcoTransmitter"));
        registry.register(init(OreBlock, "OreBlock"));
        registry.register(init(BlockBasic, "BlockBasic"));
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.register(GeneratorsItems.init(new ItemBlockGenerator(EcoGenerator), "EcoGenerator"));
        registry.register(GeneratorsItems.init(new ItemBlockGeneratorAdd(EcoGeneratorAdd), "EcoGeneratorAdd"));
        registry.register(GeneratorsItems.init(new ItemBlockEcoTransmitter(EcoTransmitter), "EcoTransmitter"));
        registry.register(GeneratorsItems.init(new ItemBlockOre(OreBlock), "OreBlock"));
        registry.register(GeneratorsItems.init(new ItemBlockBasic(BlockBasic), "BlockBasic"));
    }

    public static Block init(Block block, String name) {
        return block.setTranslationKey(name).setRegistryName(new ResourceLocation(Constants.MOD_ID, name));
    }

    public static void registerAvaritiaBlocks(IForgeRegistry<Block> registry) {
        if (Constants.AvaritiaLoaded && Constants.AvaritiaConfirm) {
            registry.register(init(AvaritiaGenerator, "AvaritiaGenerator"));
        }
    }

    public static void registerAvaritiaItemBlocks(IForgeRegistry<Item> registry) {
        if (Constants.AvaritiaLoaded && Constants.AvaritiaConfirm) {
            registry.register(GeneratorsItems.init(new ItemBlockAvaritiaGenerator(AvaritiaGenerator), "AvaritiaGenerator"));
        }
    }
}
