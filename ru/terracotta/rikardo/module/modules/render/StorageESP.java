package ru.terracotta.rikardo.module.modules.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.play.client.CPacketPlayer;
import ru.terracotta.rikardo.Main;
import ru.terracotta.rikardo.managers.FriendManager;
import ru.terracotta.rikardo.module.Category;
import ru.terracotta.rikardo.module.Module;
import ru.terracotta.rikardo.module.setting.settings.BooleanSetting;

import java.util.ArrayList;

public class StorageESP extends Module {
    BooleanSetting Glow;
    BooleanSetting WallHack;
    public StorageESP() {
        super("StorageESP", Category.Render, 0);
        Main.settingManager.add(Glow = new BooleanSetting("Glow", this, false));
        Main.settingManager.add(WallHack = new BooleanSetting("WallHack", this, true));
    }

    @Override
    public void onDisable() {
        super.onDisable();
        for(Entity entity : mc.world.loadedEntityList){
            if(entity.isGlowing() && entity instanceof EntityArmorStand ){
                entity.setGlowing(false);
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(Glow.getVal()){
            for(Entity entity : mc.world.loadedEntityList){
                if(!entity.isGlowing() && entity instanceof EntityArmorStand ){
                    entity.setGlowing(true);
                }
            }
        }

    }

    @Override
    public void onRender3D() {
        super.onRender3D();
        if(WallHack.getVal()){
            GlStateManager.clear((int)256);
            RenderHelper.enableStandardItemLighting();

            for (Entity entity : mc.world.loadedEntityList) {
                if (entity instanceof EntityArmorStand && entity != mc.getRenderViewEntity()) {
                    this.render(entity, mc.getRenderPartialTicks());
                }
            }
        }

    }

    void render(Entity entity, float ticks) {
        try {
            if (entity == null || entity == mc.player) {
                return;
            }
            if (entity == mc.getRenderViewEntity() && mc.gameSettings.thirdPersonView == 0) {
                return;
            }
            mc.entityRenderer.disableLightmap();
            mc.getRenderManager().renderEntityStatic(entity, ticks, false);
            mc.entityRenderer.enableLightmap();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}

