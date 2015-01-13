package com.omgimalexis.allthethings.init;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.omgimalexis.allthethings.allthethings;
import com.omgimalexis.allthethings.entity.EntityMummy;
import com.omgimalexis.allthethings.entity.EntityPirate;
import com.omgimalexis.allthethings.entity.EntityTurtle;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	public static void init(){
		registerEntity();
		
		EntityRegistry.addSpawn(EntityMummy.class, 10, 1, 2, EnumCreatureType.monster, BiomeGenBase.desert);
		EntityRegistry.addSpawn(EntityTurtle.class, 20, 1, 5, EnumCreatureType.waterCreature, BiomeGenBase.beach, BiomeGenBase.ocean, BiomeGenBase.river, BiomeGenBase.swampland);
		EntityRegistry.addSpawn(EntityTurtle.class, 20, 1, 5, EnumCreatureType.creature, BiomeGenBase.beach, BiomeGenBase.ocean, BiomeGenBase.river, BiomeGenBase.swampland);
	}
	
	public static void registerEntity(){
		createEntity(EntityMummy.class, "Mummy", 0xF1EEA6, 0xDEDB7C);
		createEntity(EntityPirate.class, "Pirate", 0x000658, 0x240400);
		createEntity(EntityTurtle.class, "Tortoise", 0x007F0E, 0x605824);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColour, int spotColour){
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, allthethings.instance, 64, 1, true);
		createEgg(randomId, solidColour, spotColour);
	}

	private static void createEgg(int randomId, int solidColour, int spotColour) {
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColour, spotColour));
	}
}
