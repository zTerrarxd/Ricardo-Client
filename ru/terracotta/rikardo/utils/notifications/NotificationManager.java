package ru.terracotta.rikardo.utils.notifications;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import ru.terracotta.rikardo.utils.RenderUtils;
import ru.terracotta.rikardo.utils.font.CustomFontRenderer;
import ru.terracotta.rikardo.utils.font.FontUtils;

import java.awt.*;
import java.util.ArrayList;

public class NotificationManager {
    public static long MAX_TIME = 5000;
    public static CustomFontRenderer icon = new CustomFontRenderer(FontUtils.getFontFromTTF(new ResourceLocation("fonts/stylesicons.ttf"), 25, Font.PLAIN), true, true);

    public static CustomFontRenderer fr = new CustomFontRenderer(FontUtils.getFontFromTTF(new ResourceLocation("fonts/main.ttf"), 19, Font.PLAIN), true, true);
    public static ArrayList<Notification> notifications = new ArrayList<>();
    public static void add(String text, String message){
        notifications.add(new Notification(text, message));
    }

    public static void draw(Notification notification, int i){
        int x = GuiScreen.width - 100;
        int y =  (int) ((GuiScreen.height - 10) - (i * 15));
            RenderUtils.drawShadowRect(x, y, x + 100, y + 10, 5);
            icon.drawString("K", x, y + 1, Color.green.getRGB());
            fr.drawString(notification.getText() + " - " + notification.getMessage(), x + icon.getStringWidth("H"), y+5 - (fr.getHeight() / 2), Color.white.getRGB());

    }

    public static void Render(){
        int x = GuiScreen.width - 100;
        int y = GuiScreen.height - 10;
        for(int i = 0; i < notifications.size(); i++){
            if(System.currentTimeMillis() - notifications.get(i).getTime() >= MAX_TIME){
                notifications.remove(i);
            }
        }

        for(int i = 0; i < notifications.size(); i++){
            draw(notifications.get(i), i);
        }

    }
}
