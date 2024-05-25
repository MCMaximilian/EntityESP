package com.mcmaximilian.Event;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

import static com.mcmaximilian.Keybinds.ESPState;
import static com.mcmaximilian.Keybinds.ToggleESP;

public class KeyInputEvent {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event)
    {
        if(ToggleESP.isPressed()) {
            if ( ESPState.equalsIgnoreCase("off")) {
                Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("ESP is turned on" ));
                ESPState = "on";
            }
            else if ( ESPState.equalsIgnoreCase("on")) {
                Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText("ESP is turned off" ));
                ESPState = "off";
            }
        }
    }
}
