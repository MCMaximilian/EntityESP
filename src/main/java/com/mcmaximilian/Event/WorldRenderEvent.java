package com.mcmaximilian.Event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.village.Village;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import static com.mcmaximilian.Keybinds.ESPState;

public class WorldRenderEvent {


    /**
     * URL: https://github.com/vepexlegit/PlayerESP
     * made box with EntityPosition
     */
    @SuppressWarnings("JavadocLinkAsPlainText")
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
        for (Entity entity : Minecraft.getMinecraft().theWorld.getLoadedEntityList() ) {
            if ( entity instanceof EntityPlayer ) {
                if ( entity == Minecraft.getMinecraft().thePlayer ) {
                    continue;
                }
                double x = entity.posX - Minecraft.getMinecraft().getRenderManager().viewerPosX;
                double y = entity.posY - Minecraft.getMinecraft().getRenderManager().viewerPosY;
                double z = entity.posZ - Minecraft.getMinecraft().getRenderManager().viewerPosZ;
                GL11.glColor4f(0.0F, 1.0F, 0.0F, 1.0F);
                GL11.glBegin(GL11.GL_LINE_LOOP);
                GL11.glVertex3d(x - 0.5, y, z - 0.5);
                GL11.glVertex3d(x - 0.5, y + 1.8, z - 0.5);
                GL11.glVertex3d(x + 0.5, y + 1.8, z - 0.5);
                GL11.glVertex3d(x + 0.5, y, z - 0.5);
                GL11.glEnd();
                GL11.glBegin(GL11.GL_LINE_LOOP);
                GL11.glVertex3d(x - 0.5, y, z + 0.5);
                GL11.glVertex3d(x - 0.5, y + 1.8, z + 0.5);
                GL11.glVertex3d(x + 0.5, y + 1.8, z + 0.5);
                GL11.glVertex3d(x + 0.5, y, z + 0.5);
                GL11.glEnd();
                GL11.glBegin(GL11.GL_LINES);
                GL11.glVertex3d(x - 0.5, y, z - 0.5);
                GL11.glVertex3d(x - 0.5, y, z + 0.5);
                GL11.glVertex3d(x - 0.5, y + 1.8, z - 0.5);
                GL11.glVertex3d(x - 0.5, y + 1.8, z + 0.5);
                GL11.glVertex3d(x + 0.5, y + 1.8, z - 0.5);
                GL11.glVertex3d(x + 0.5, y + 1.8, z + 0.5);
                GL11.glVertex3d(x + 0.5, y, z - 0.5);
                GL11.glVertex3d(x + 0.5, y, z + 0.5);
                GL11.glEnd();
            }
            if ( entity instanceof EntityVillager) {
                continue;
            }
            if ( ! (entity instanceof EntityLiving ) ) {
                continue;
            }
            double x = entity.posX - Minecraft.getMinecraft().getRenderManager().viewerPosX;
            double y = entity.posY - Minecraft.getMinecraft().getRenderManager().viewerPosY;
            double z = entity.posZ - Minecraft.getMinecraft().getRenderManager().viewerPosZ;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(x - 0.5, y, z - 0.5);
            GL11.glVertex3d(x - 0.5, y + 1.8, z - 0.5);
            GL11.glVertex3d(x + 0.5, y + 1.8, z - 0.5);
            GL11.glVertex3d(x + 0.5, y, z - 0.5);
            GL11.glEnd();
            GL11.glBegin(GL11.GL_LINE_LOOP);
            GL11.glVertex3d(x - 0.5, y, z + 0.5);
            GL11.glVertex3d(x - 0.5, y + 1.8, z + 0.5);
            GL11.glVertex3d(x + 0.5, y + 1.8, z + 0.5);
            GL11.glVertex3d(x + 0.5, y, z + 0.5);
            GL11.glEnd();
            GL11.glBegin(GL11.GL_LINES);
            GL11.glVertex3d(x - 0.5, y, z - 0.5);
            GL11.glVertex3d(x - 0.5, y, z + 0.5);
            GL11.glVertex3d(x - 0.5, y + 1.8, z - 0.5);
            GL11.glVertex3d(x - 0.5, y + 1.8, z + 0.5);
            GL11.glVertex3d(x + 0.5, y + 1.8, z - 0.5);
            GL11.glVertex3d(x + 0.5, y + 1.8, z + 0.5);
            GL11.glVertex3d(x + 0.5, y, z - 0.5);
            GL11.glVertex3d(x + 0.5, y, z + 0.5);
            GL11.glEnd();
        }
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
    }
}
