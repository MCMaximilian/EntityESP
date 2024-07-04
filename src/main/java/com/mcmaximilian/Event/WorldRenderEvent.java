package com.mcmaximilian.Event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import static com.mcmaximilian.Keybinds.ESPState;

public class WorldRenderEvent {


    @SubscribeEvent
    public void worldRenderEvent( RenderWorldLastEvent event) {

        if (ESPState.equalsIgnoreCase("off")) {
            return;
        }

        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        for (Entity entity : Minecraft.getMinecraft().theWorld.getLoadedEntityList() ) { //TODO: 모든 loading된 entity를 불러오는 class

            if ( entity instanceof EntityPlayer ) { //TODO: player인 경우

                if ( entity == Minecraft.getMinecraft().thePlayer ) {
                    continue;
                }
                if (!entity.isEntityAlive()) {
                    continue;
                }
                if ( entity.isInvisible()) {
                    continue;
                }
                //TODO: 이 3가지 경우에는 표기하지 않음

                GL11.glColor4f(0.0F, 1.0F, 0.0F, 1.0F);

                RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
                AxisAlignedBB boundingBox = entity.getEntityBoundingBox();

                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, GL11.GL_ONE,
                        GL11.GL_ZERO);

                GlStateManager.disableTexture2D();
                GlStateManager.disableLighting();
                GlStateManager.disableCull();
                GlStateManager.disableDepth();

                GlStateManager.pushMatrix();
                GlStateManager.translate(-renderManager.viewerPosX, -renderManager.viewerPosY, -renderManager.viewerPosZ);

                AxisAlignedBB adjustedBoundingBox = new AxisAlignedBB(boundingBox.minX, boundingBox.minY, boundingBox.minZ,
                        boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);

                RenderGlobal.drawSelectionBoundingBox(adjustedBoundingBox);

                GlStateManager.popMatrix();

                GlStateManager.enableDepth();
                GlStateManager.enableCull();
                GlStateManager.enableLighting();
                GlStateManager.enableTexture2D();
                GlStateManager.disableBlend();
            }
            else if ( entity instanceof EntityVillager) {
                continue;
            }
            else if ( ! (entity instanceof EntityLiving ) ) {
                continue;
            }

            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);


            RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
            AxisAlignedBB boundingBox = entity.getEntityBoundingBox();

            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, GL11.GL_ONE,
                    GL11.GL_ZERO);

            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            GlStateManager.disableDepth();

            GlStateManager.pushMatrix();
            GlStateManager.translate(-renderManager.viewerPosX, -renderManager.viewerPosY, -renderManager.viewerPosZ);

            AxisAlignedBB adjustedBoundingBox = new AxisAlignedBB(boundingBox.minX, boundingBox.minY, boundingBox.minZ,
                    boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ);

            RenderGlobal.drawSelectionBoundingBox(adjustedBoundingBox);

            GlStateManager.popMatrix();

            GlStateManager.enableDepth();
            GlStateManager.enableCull();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
            GlStateManager.disableBlend();
        }
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
    }
}
