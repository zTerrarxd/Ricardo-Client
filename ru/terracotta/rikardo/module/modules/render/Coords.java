package ru.terracotta.rikardo.module.modules.render;

import net.minecraft.client.gui.GuiScreen;
import ru.terracotta.rikardo.module.Category;
import ru.terracotta.rikardo.module.Module;
import ru.terracotta.rikardo.utils.RenderUtils;

import java.awt.*;

public class Coords extends Module {
    public Coords() {
        super("Coords", Category.Render, 0);
    }

    @Override
    public void onRender2D() {
        super.onRender2D();
        int Xpos = 7;
        int Ypos = GuiScreen.height - 7 - fr.getHeight();
        String text = "X: " + (int) mc.player.posX + " Y: " + (int) mc.player.posY + " Z: " + (int) mc.player.posZ;
        RenderUtils.drawShadowRect(Xpos, Ypos, Xpos + fr.getStringWidth(text), Ypos + fr.getHeight() + 3, 6);
        fr.drawString(text, Xpos, Ypos + 1.5, Color.white.getRGB());
    }
}
