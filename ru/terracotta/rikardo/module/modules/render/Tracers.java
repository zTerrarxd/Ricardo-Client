package ru.terracotta.rikardo.module.modules.render;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;
import ru.terracotta.rikardo.managers.FriendManager;
import ru.terracotta.rikardo.module.Category;
import ru.terracotta.rikardo.module.Module;
import ru.terracotta.rikardo.utils.RenderUtil;

import java.awt.*;

public class Tracers extends Module {
    public Tracers() {
        super("Tracers", Category.Render, 0);
    }

    @Override
    public void onRender3D() {
        super.onRender3D();
        mc.gameSettings.viewBobbing = false;
        //Tracers.mc.entityRenderer.setupCameraTransform(event.getPartialTicks(), 2);
        //Tracers.mc.gameSettings.viewBobbing = old;
        GL11.glPushMatrix();
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(1.5f);

        for (Entity entity : mc.world.loadedEntityList) {
            if (entity == mc.player || !(entity instanceof EntityPlayer)) continue;
            assert (mc.getRenderViewEntity() != null);
            mc.player.getDistanceToEntity(entity);
            double d = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) - mc.getRenderManager().viewerPosX;
            double d2 = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) - mc.getRenderManager().viewerPosY;
            double d3 = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) - mc.getRenderManager().viewerPosZ;
            if(FriendManager.isFriend(entity.getName())){
                RenderUtil.setColor(RenderUtil.injectAlpha(Color.magenta, 150) );

            } else{
                RenderUtil.setColor(RenderUtil.injectAlpha(new Color(255, 255, 255), 150) );

            }

            Vec3d vec3d = new Vec3d(0.0, 0.0, 1.0);
            vec3d = vec3d.rotatePitch(-((float)Math.toRadians(mc.player.rotationPitch)));
            Vec3d vec3d2 = vec3d.rotateYaw(-((float)Math.toRadians(mc.player.rotationYaw)));
            GL11.glBegin(2);
            GL11.glVertex3d(vec3d2.xCoord, (double)mc.player.getEyeHeight() + vec3d2.yCoord, vec3d2.zCoord);
            GL11.glVertex3d(d, d2 + 1.1, d3);
            GL11.glEnd();
        }
        GL11.glDisable(3042);
        GL11.glDepthMask(true);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glPopMatrix();
    }
}
