package com.shnupbups.allthethings.handler;

import com.shnupbups.allthethings.utility.MiscUtility;

import net.minecraft.item.ItemFood;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class FoodHandler {
	@SubscribeEvent
	public void onUsed(PlayerUseItemEvent.Finish e) {
		if(e.item.getItem() != null && e.item.getItem() instanceof ItemFood) {
			e.entityPlayer.addExperience(MiscUtility.clamp(((e.entityPlayer.worldObj.rand.nextInt(((ItemFood)e.item.getItem()).func_150905_g(e.item)+1)+e.entityPlayer.worldObj.rand.nextInt((int)(((ItemFood)e.item.getItem()).func_150906_h(e.item))+1))/2), 1, 5));
		}
	}
}