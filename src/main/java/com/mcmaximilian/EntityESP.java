package com.mcmaximilian;

import com.mcmaximilian.Event.KeyInputEvent;
import com.mcmaximilian.Event.WorldRenderEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import static com.mcmaximilian.Keybinds.registerKey;

@Mod(modid = EntityESP.MODID, version = EntityESP.VERSION)
public class EntityESP
{
    public static final String MODID = "EntityESP";
    public static final String VERSION = "1.0";


    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register( new KeyInputEvent() );
        MinecraftForge.EVENT_BUS.register( new com.mcmaximilian.Event.WorldRenderEvent() );
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        registerKey();
    }
}
