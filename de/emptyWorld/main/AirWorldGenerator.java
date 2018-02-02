package de.emptyWorld.main;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.World;
import org.bukkit.block.Block;

public class AirWorldGenerator extends ChunkGenerator
{
	public byte[] generate(World world, Random random, int cx, int cz)
	{
		return new byte[65536];
	}

	@Override
	public Location getFixedSpawnLocation(World world, Random random)
	{
		Location loc = new Location(world, 0, 64,0);
		world = loc.getWorld();
		loc.setY(loc.getY() - 1); 
		Block b = world.getBlockAt(loc); 
		b.setType(Material.GLOWSTONE);
		return new Location(world, 0, 64, 0);
	}
}