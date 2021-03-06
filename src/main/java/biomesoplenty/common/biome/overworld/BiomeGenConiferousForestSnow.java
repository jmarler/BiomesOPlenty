package biomesoplenty.common.biome.overworld;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import biomesoplenty.api.content.BOPCBlocks;
import biomesoplenty.common.biome.BOPOverworldBiome;
import biomesoplenty.common.world.features.WorldGenBOPDoubleFlora;
import biomesoplenty.common.world.features.WorldGenBOPFlora;
import biomesoplenty.common.world.features.WorldGenBOPTallGrass;
import biomesoplenty.common.world.features.trees.WorldGenBOPTaiga2;
import biomesoplenty.common.world.features.trees.WorldGenBOPTaiga3;
import biomesoplenty.common.configuration.BOPConfigurationTerrainGen;
// BOPConfigurationTerrainGen.heightrootmod - BOPConfigurationTerrainGen.heightVarMod

public class BiomeGenConiferousForestSnow extends BOPOverworldBiome
{
    //private static final Height biomeHeight = new Height(0.1F, 0.3F);
  	private static final Height biomeHeight = new Height(0.1F*BOPConfigurationTerrainGen.heightrootmod, 0.3F*BOPConfigurationTerrainGen.heightVarMod);
  
    public BiomeGenConiferousForestSnow(int id)
    {
        super(id);
        
        //TODO: setHeight()
        this.setHeight(biomeHeight);
        this.setEnableSnow();
        //TODO: setColor()
        this.setColor(16777215);
        this.setTemperatureRainfall(0.0F, 0.5F);

        this.spawnableCreatureList.clear();

        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.mushroomsPerChunk = 4;
        this.theBiomeDecorator.flowersPerChunk = -999;
        //                     gravelPerChunk
        this.theBiomeDecorator.sandPerChunk = -999;
        this.theBiomeDecorator.sandPerChunk2 = -999;

        this.theBiomeDecorator.bopFeatures.bopFlowersPerChunk = 3;
        this.theBiomeDecorator.bopFeatures.shrubsPerChunk = 4;
        this.theBiomeDecorator.bopFeatures.deadLeafPilesPerChunk = 8;

        this.theBiomeDecorator.bopFeatures.bopGrassPerChunk = 5;

        this.theBiomeDecorator.bopFeatures.weightedFlowerGen.put(new WorldGenBOPFlora(BOPCBlocks.flowers, 8), 8);

        this.theBiomeDecorator.bopFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(Blocks.tallgrass, 1), 0.5D);
        this.theBiomeDecorator.bopFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPCBlocks.foliage, 2), 1D);
        this.theBiomeDecorator.bopFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPCBlocks.foliage, 10), 0.5D);
        this.theBiomeDecorator.bopFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(BOPCBlocks.foliage, 11), 0.5D);
        this.theBiomeDecorator.bopFeatures.weightedGrassGen.put(new WorldGenBOPTallGrass(Blocks.tallgrass, 2), 0.25D);
        this.theBiomeDecorator.bopFeatures.weightedGrassGen.put(new WorldGenBOPDoubleFlora(3, 64), 0.25D);
    }

	@Override
    //TODO:                     getRandomWorldGenForTrees()
    public WorldGenAbstractTree func_150567_a(Random random)
    {
		return random.nextInt(6) == 0 ? new WorldGenBOPTaiga2(BOPCBlocks.logs1, BOPCBlocks.leaves2, 3, 1, false, 10, 10, 5) :
		(random.nextInt(3) == 0 ? new WorldGenBOPTaiga2(BOPCBlocks.logs1, BOPCBlocks.leaves2, 3, 1, false, 20, 15, 4) : 
		new WorldGenBOPTaiga3(BOPCBlocks.logs1, BOPCBlocks.leaves2, 3, 1, false, 35, 10, 0));
	}

    @Override
    public void decorate(World world, Random random, int chunkX, int chunkZ)
    {
        super.decorate(world, random, chunkX, chunkZ);
        int var5 = 12 + random.nextInt(6);

        for (int var6 = 0; var6 < var5; ++var6)
        {
            int x = chunkX + random.nextInt(16);
            int y = random.nextInt(28) + 4;
            int z = chunkZ + random.nextInt(16);
            
            //TODO:             getBlock()
            Block block = world.getBlock(x, y, z);

            if (block != null && block.isReplaceableOreGen(world, x, y, z, Blocks.stone))
            {
                //TODO: setBlock()
                world.setBlock(x, y, z, BOPCBlocks.gemOre, 8, 2);
            }
        }
    }
}
