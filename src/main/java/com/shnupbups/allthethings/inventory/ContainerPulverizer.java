package com.shnupbups.allthethings.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.shnupbups.allthethings.tileEntity.TileEntityPulverizer;
import com.shnupbups.allthethings.utility.CompressingRecipes;

public class ContainerPulverizer extends Container {

	public final EntityPlayer player;
	public final World world;
	public final int x;
	public final int y;
	public final int z;
	public TileEntityPulverizer tileentity;
	
	public ContainerPulverizer(EntityPlayer player, World world, int x, int y, int z) {
		this.player = player;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.tileentity = (TileEntityPulverizer) world.getTileEntity(x, y, z);
		
		this.addSlotToContainer(new Slot(tileentity, 0, 53, 39));
		this.addSlotToContainer(new SlotOutput(tileentity, 1, 103, 39));
		this.addSlotToContainer(new SlotOutput(tileentity, 2, 126, 39));
		this.addSlotToContainer(new SlotUpgrade(tileentity, 3, 116, 7));
		this.addSlotToContainer(new SlotUpgrade(tileentity, 4, 134, 7));
		this.addSlotToContainer(new SlotUpgrade(tileentity, 5, 152, 7));
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
				
			}
		}
		
		for (int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		// TODO Auto-generated method stub
		return true;
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int slotId) {
		if(CompressingRecipes.getCompressResult(player.inventory.getStackInSlot(slotId)) != null) {
			tileentity.inventory[0] = player.inventory.getStackInSlot(slotId).copy();
			player.inventory.setInventorySlotContents(slotId, null);
		}
		return player.inventory.getStackInSlot(slotId);
	}

}
