package aeternal.ecoenergistics.common.world;

import java.util.Random;

import aeternal.ecoenergistics.common.EcoEnergisticsBlocks;
import aeternal.ecoenergistics.common.config.EcoConfig;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkGeneratorEnd;
import net.minecraft.world.gen.ChunkGeneratorHell;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenHandler implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (!(chunkGenerator instanceof ChunkGeneratorHell) && !(chunkGenerator instanceof ChunkGeneratorEnd)) {
            for (int i = 0; i < EcoConfig.current().generators.titaniumPerChunk.val(); i++) {
                BlockPos pos = new BlockPos(chunkX * 16 + random.nextInt(16), random.nextInt(60), (chunkZ * 16) + random.nextInt(16));
                new WorldGenMinable(EcoEnergisticsBlocks.EcoOreBlock.getStateFromMeta(0), EcoConfig.current().generators.titaniumMaxVeinSize.val(),
                        BlockMatcher.forBlock(Blocks.STONE)).generate(world, random, pos);
            }

            for (int i = 0; i < EcoConfig.current().generators.uraniumPerChunk.val(); i++) {
                BlockPos pos = new BlockPos(chunkX * 16 + random.nextInt(16), random.nextInt(30), (chunkZ * 16) + random.nextInt(16));
                new WorldGenMinable(EcoEnergisticsBlocks.EcoOreBlock.getStateFromMeta(1), EcoConfig.current().generators.uraniumMaxVeinSize.val(),
                        BlockMatcher.forBlock(Blocks.STONE)).generate(world, random, pos);
            }

            for (int i = 0; i < EcoConfig.current().generators.iridiumPerChunk.val(); i++) {
                BlockPos pos = new BlockPos(chunkX * 16 + random.nextInt(16), random.nextInt(15), (chunkZ * 16) + random.nextInt(16));
                new WorldGenMinable(EcoEnergisticsBlocks.EcoOreBlock.getStateFromMeta(2), EcoConfig.current().generators.iridiumMaxVeinSize.val(),
                        BlockMatcher.forBlock(Blocks.STONE)).generate(world, random, pos);
            }
        }
    }
}