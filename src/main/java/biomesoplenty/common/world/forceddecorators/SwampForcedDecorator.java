package biomesoplenty.common.world.forceddecorators;

import java.util.Random;

import biomesoplenty.common.world.decoration.IBOPDecoration;
import biomesoplenty.common.world.features.WorldGenBOPFlora;

public class SwampForcedDecorator extends ForcedDecorator
{
	@Override
	public int getWorldGenPerChunk(String fieldName) 
	{
		if (fieldName.equals("mudPerChunk")) return 3;
		
		return 0;
	}
}