// Date: 10/01/2015 12:55:14 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.omgimalexis.allthethings.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTurtle extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer shell;
    ModelRenderer shelltop;
    ModelRenderer frontleftfoot;
    ModelRenderer frontrightfoot;
    ModelRenderer backrightfoot;
    ModelRenderer backleftfoot;
    ModelRenderer tail;
  
  public ModelTurtle()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 39);
      head.addBox(-2F, -1F, -5F, 4, 3, 5);
      head.setRotationPoint(0F, 15F, -7F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      shell = new ModelRenderer(this, 0, 0);
      shell.addBox(-6F, -2F, 0F, 12, 7, 16);
      shell.setRotationPoint(0F, 15F, -7F);
      shell.setTextureSize(64, 64);
      shell.mirror = true;
      setRotation(shell, 0F, 0F, 0F);
      shelltop = new ModelRenderer(this, 0, 23);
      shelltop.addBox(-5F, -4F, 1F, 10, 2, 14);
      shelltop.setRotationPoint(0F, 15F, -7F);
      shelltop.setTextureSize(64, 64);
      shelltop.mirror = true;
      setRotation(shelltop, 0F, 0F, 0F);
      frontleftfoot = new ModelRenderer(this, 48, 41);
      frontleftfoot.addBox(-2F, 0F, -1F, 4, 4, 2);
      frontleftfoot.setRotationPoint(3F, 20F, -4F);
      frontleftfoot.setTextureSize(64, 64);
      frontleftfoot.mirror = true;
      setRotation(frontleftfoot, 0F, 0F, 0F);
      frontrightfoot = new ModelRenderer(this, 48, 35);
      frontrightfoot.addBox(-2F, 0F, -1F, 4, 4, 2);
      frontrightfoot.setRotationPoint(-3F, 20F, -4F);
      frontrightfoot.setTextureSize(64, 64);
      frontrightfoot.mirror = true;
      setRotation(frontrightfoot, 0F, 0F, 0F);
      backrightfoot = new ModelRenderer(this, 48, 29);
      backrightfoot.addBox(-2F, 0F, -1F, 4, 4, 2);
      backrightfoot.setRotationPoint(-3F, 20F, 5F);
      backrightfoot.setTextureSize(64, 64);
      backrightfoot.mirror = true;
      setRotation(backrightfoot, 0F, 0F, 0F);
      backleftfoot = new ModelRenderer(this, 48, 23);
      backleftfoot.addBox(-2F, 0F, -1F, 4, 4, 2);
      backleftfoot.setRotationPoint(3F, 20F, 5F);
      backleftfoot.setTextureSize(64, 64);
      backleftfoot.mirror = true;
      setRotation(backleftfoot, 0F, 0F, 0F);
      tail = new ModelRenderer(this, 56, 0);
      tail.addBox(-1F, 0F, 0F, 2, 2, 1);
      tail.setRotationPoint(0F, 15F, 9F);
      tail.setTextureSize(64, 64);
      tail.mirror = true;
      setRotation(tail, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    if (this.isChild)
    {
        float f6 = 2.0F;
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 5.0F * f5, 4.0F * f5);
        this.head.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glScalef(1.0F / f6, 1.0F / f6, 1.0F / f6);
        GL11.glTranslatef(0.0F, 24.0F * f5, 0.0F);
        this.shell.render(f5);
        this.shelltop.render(f5);
        this.tail.render(f5);
        this.frontrightfoot.render(f5);
        this.frontleftfoot.render(f5);
        this.backrightfoot.render(f5);
        this.backleftfoot.render(f5);
        GL11.glPopMatrix();
    }else {
    head.render(f5);
    shell.render(f5);
    shelltop.render(f5);
    frontleftfoot.render(f5);
    frontrightfoot.render(f5);
    backrightfoot.render(f5);
    backleftfoot.render(f5);
    tail.render(f5);
    }
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
    float f6 = (180F / (float)Math.PI);
    this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.head.rotateAngleY = f4 / (180F / (float)Math.PI);
    this.shell.rotateAngleX = ((float)Math.PI * 2F);
    this.shelltop.rotateAngleX = ((float)Math.PI * 2F);
    this.tail.rotateAngleX = ((float)Math.PI * 2F);
    this.frontrightfoot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.frontleftfoot.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.backleftfoot.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.backrightfoot.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}