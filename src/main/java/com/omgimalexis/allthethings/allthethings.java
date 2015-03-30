package com.omgimalexis.allthethings;

import net.minecraft.client.Minecraft;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;

import com.omgimalexis.allthethings.handler.AchievementHandler;
import com.omgimalexis.allthethings.handler.BucketHandler;
import com.omgimalexis.allthethings.handler.ChatHandler;
import com.omgimalexis.allthethings.handler.ConfigurationHandler;
import com.omgimalexis.allthethings.handler.FuelHandler;
import com.omgimalexis.allthethings.handler.GuiHandler;
import com.omgimalexis.allthethings.handler.HUDHandler;
import com.omgimalexis.allthethings.handler.PlayerLogin;
import com.omgimalexis.allthethings.handler.PotionHandler;
import com.omgimalexis.allthethings.handler.VillageHouseHandler;
import com.omgimalexis.allthethings.init.ModAchievements;
import com.omgimalexis.allthethings.init.ModArmour;
import com.omgimalexis.allthethings.init.ModBiomes;
import com.omgimalexis.allthethings.init.ModBlocks;
import com.omgimalexis.allthethings.init.ModBlocksPreItems;
import com.omgimalexis.allthethings.init.ModBuckets;
import com.omgimalexis.allthethings.init.ModCustomRecipes;
import com.omgimalexis.allthethings.init.ModDimensions;
import com.omgimalexis.allthethings.init.ModEntities;
import com.omgimalexis.allthethings.init.ModFluids;
import com.omgimalexis.allthethings.init.ModItems;
import com.omgimalexis.allthethings.init.ModMisc;
import com.omgimalexis.allthethings.init.ModOreDictRegister;
import com.omgimalexis.allthethings.init.ModPotions;
import com.omgimalexis.allthethings.init.ModRecipes;
import com.omgimalexis.allthethings.init.ModRings;
import com.omgimalexis.allthethings.init.ModRingsBaubles;
import com.omgimalexis.allthethings.init.ModTileEntities;
import com.omgimalexis.allthethings.init.ModTools;
import com.omgimalexis.allthethings.init.ModWorldGen;
import com.omgimalexis.allthethings.lib.Reference;
import com.omgimalexis.allthethings.lib.Strings;
import com.omgimalexis.allthethings.main.CommonProxy;
import com.omgimalexis.allthethings.utility.LogHelper;
import com.omgimalexis.allthethings.world.village.VillageStructureHouse;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class allthethings {
	@Mod.Instance(Reference.MOD_ID)
	public static allthethings instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LogHelper.info("OHAI");
		Strings strings = new Strings();
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		FMLCommonHandler.instance().bus().register(new PlayerLogin());
		MinecraftForge.EVENT_BUS.register(new PotionHandler());
		MinecraftForge.EVENT_BUS.register(new HUDHandler(Minecraft.getMinecraft()));
		
		if(Loader.isModLoaded("Baubles")) {
			ModRingsBaubles.init();
		} else {
			ModRings.init();
		}
		
		ModBlocksPreItems.preInit();
		ModItems.init();
		ModFluids.init();
		ModBlocks.init();
		ModBuckets.init();
		ModTools.init();
		ModArmour.init();
		ModRecipes.init();
		ModCustomRecipes.init();
		ModPotions.preInit();
		ModDimensions.init();

		if (Reference.DEBUG_MODE) {
			// ModDebug.init();
			LogHelper.info("Debug Mode is on! This means you're in a development environment, or we forgot something...");
			LogHelper.info("That means there'll be an extra tab and extra items not normally available.");
		}
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		ModBlocksPreItems.init();
		ModMisc.init();
		ModOreDictRegister.init();
		ModTileEntities.init();
		ModAchievements.init();
		ModBiomes.init();
		ModEntities.init();
		ModPotions.init();
		proxy.registerRenderers();
		GameRegistry.registerFuelHandler(new FuelHandler());
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
		VillagerRegistry.instance().registerVillageCreationHandler(new VillageHouseHandler());
		MapGenStructureIO.func_143031_a(VillageStructureHouse.class, Reference.MOD_ID+":HouseStructure");
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(new ChatHandler());
		LogHelper.info("World Gen initialised successfully!");
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		FMLCommonHandler.instance().bus().register(new AchievementHandler());
		LogHelper.info(Reference.BLOCKS_ADDED+" blocks added.");
		LogHelper.info(Reference.ITEMS_ADDED+" items added.");
	}
}