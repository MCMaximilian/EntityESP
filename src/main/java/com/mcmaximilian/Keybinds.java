package com.mcmaximilian;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Keybinds {

    public static KeyBinding ToggleESP = new KeyBinding( "entityesp.key.toggleESP", Keyboard.KEY_J , "key.categories.entityesp");

    public static String ESPState = "off" ;

    public static void registerKey() {
        ClientRegistry.registerKeyBinding( ToggleESP );
    }


}
