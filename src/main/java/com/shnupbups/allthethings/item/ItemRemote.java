package com.shnupbups.allthethings.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemRemote extends ItemBasic {
	
	public ItemRemote(String name, CreativeTabs tab) {
		super(name, tab, 1);
	}
	
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float f1, float f2, float f3) {
		if(!world.isRemote && player.isSneaking() && itemStack.stackTagCompound != null) {
		    itemStack.stackTagCompound.setInteger("x", x);
		    itemStack.stackTagCompound.setInteger("y", y);
		    itemStack.stackTagCompound.setInteger("z", z);
		    itemStack.stackTagCompound.setInteger("side", side);
		    itemStack.stackTagCompound.setFloat("f1", f1);
		    itemStack.stackTagCompound.setFloat("f2", f2);
		    itemStack.stackTagCompound.setFloat("f3", f3);
			player.addChatComponentMessage(new ChatComponentText("Coordinates set: "+x+","+y+","+z));
			return true;
		} else if(itemStack.stackTagCompound == null) {
			itemStack.stackTagCompound = new NBTTagCompound();
		    itemStack.stackTagCompound.setInteger("x", 0);
		    itemStack.stackTagCompound.setInteger("y", -1);
		    itemStack.stackTagCompound.setInteger("z", 0);
		    itemStack.stackTagCompound.setInteger("side", 0);
		    itemStack.stackTagCompound.setFloat("f1", 0);
		    itemStack.stackTagCompound.setFloat("f2", 0);
		    itemStack.stackTagCompound.setFloat("f3", 0);
		}
		return false;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		if (!world.isRemote && !player.isSneaking() && itemStack.stackTagCompound != null) {
			int x = itemStack.stackTagCompound.getInteger("x");
		    int y = itemStack.stackTagCompound.getInteger("y");
		    int z = itemStack.stackTagCompound.getInteger("z");
		    int side = itemStack.stackTagCompound.getInteger("side");
		    float f1 = itemStack.stackTagCompound.getFloat("f1");
		    float f2 = itemStack.stackTagCompound.getFloat("f2");
		    float f3 = itemStack.stackTagCompound.getFloat("f3");
			if(x != 0 && y != -1 && z != 0) {
				world.getBlock(x, y, z).onBlockActivated(world, x, y, z, player, side, f1, f2, f3);
			}
		} else if(itemStack.stackTagCompound == null) {
			itemStack.stackTagCompound = new NBTTagCompound();
		    itemStack.stackTagCompound.setInteger("x", 0);
		    itemStack.stackTagCompound.setInteger("y", -1);
		    itemStack.stackTagCompound.setInteger("z", 0);
		    itemStack.stackTagCompound.setInteger("side", 0);
		    itemStack.stackTagCompound.setFloat("f1", 0);
		    itemStack.stackTagCompound.setFloat("f2", 0);
		    itemStack.stackTagCompound.setFloat("f3", 0);
		}
		return itemStack;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean bool) {
		if(stack.stackTagCompound != null) {
			int x = stack.stackTagCompound.getInteger("x");
			int y = stack.stackTagCompound.getInteger("y");
			int z = stack.stackTagCompound.getInteger("z");
			list.add("Shift-RClick to Save Coordinates");
			list.add("RClick to Send RClick to Coordinates");
			if(x != 0 && y != -1 && z != 0) {
				list.add("Current Coordinates: "+x+","+y+","+z);
			}
		} else {
			stack.stackTagCompound = new NBTTagCompound();
		    stack.stackTagCompound.setInteger("x", 0);
		    stack.stackTagCompound.setInteger("y", -1);
		    stack.stackTagCompound.setInteger("z", 0);
		    stack.stackTagCompound.setInteger("side", 0);
		    stack.stackTagCompound.setFloat("f1", 0);
		    stack.stackTagCompound.setFloat("f2", 0);
		    stack.stackTagCompound.setFloat("f3", 0);
		}
	}
	
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
		itemStack.stackTagCompound = new NBTTagCompound();
	    itemStack.stackTagCompound.setInteger("x", 0);
	    itemStack.stackTagCompound.setInteger("y", -1);
	    itemStack.stackTagCompound.setInteger("z", 0);
	    itemStack.stackTagCompound.setInteger("side", 0);
	    itemStack.stackTagCompound.setFloat("f1", 0);
	    itemStack.stackTagCompound.setFloat("f2", 0);
	    itemStack.stackTagCompound.setFloat("f3", 0);
	}
}
