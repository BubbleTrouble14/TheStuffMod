// Date: 22/4/2015 06:34:43pm, 1834
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.omgimalexis.allthethings.model;

import com.omgimalexis.allthethings.utility.LogHelper;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLyekhwrone extends ModelBase
{
  //fields
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
  
  public ModelLyekhwrone()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Body = new ModelRenderer(this, 0, 0);
      Body.addBox(-1F, 0F, -1F, 2, 1, 6);
      Body.setRotationPoint(0F, 23F, 1F);
      Body.setTextureSize(64, 32);
      Body.mirror = true;
      setRotation(Body, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 10, 0);
      Head.addBox(-1F, -3F, -2F, 2, 3, 2);
      Head.setRotationPoint(0F, 23F, 1F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Ear1 = new ModelRenderer(this, 0, 0);
      Ear1.addBox(0F, -5F, -1F, 1, 3, 1);
      Ear1.setRotationPoint(0F, 23F, 1F);
      Ear1.setTextureSize(64, 32);
      Ear1.mirror = true;
      setRotation(Ear1, -0.0523599F, 0.2617994F, 0.0872665F);
      Ear2 = new ModelRenderer(this, 0, 0);
      Ear2.addBox(-1F, -5F, -1F, 1, 3, 1);
      Ear2.setRotationPoint(0F, 23F, 1F);
      Ear2.setTextureSize(64, 32);
      Ear2.mirror = true;
      setRotation(Ear2, -0.0523599F, -0.2617994F, -0.0872665F);
      Ear2.mirror = false;
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Body.render(f5);
    Head.render(f5);
    Ear1.render(f5);
    Ear2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    int j = 0;
    this.Head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Head.offsetZ = -0.15F;
    this.Ear1.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Ear1.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Ear1.offsetZ = -0.15F;
    this.Ear2.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.Ear2.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.Ear2.offsetZ = -0.15F;
    this.Body.offsetZ = ((MathHelper.cos(f * 0.6662F) * 1.4F)*0.026F)-0.15F;
  }

}
