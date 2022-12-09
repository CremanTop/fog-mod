package creman.fog;

import creman.fog.capability.FogCap;
import creman.fog.capability.FogStorage;
import creman.fog.capability.IFog;
import creman.fog.commands.FogCommand;
import creman.fog.events.EventHandler;
import creman.fog.network.fog.Dispatcher;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod.EventBusSubscriber
public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        CapabilityManager.INSTANCE.register(IFog.class, new FogStorage(), FogCap.class);
        Dispatcher.register();
    }
    public void server(FMLServerStartingEvent e) {
        e.registerServerCommand(new FogCommand());
    }
    public void init(FMLInitializationEvent e) {
    }
    public void postInit(FMLPostInitializationEvent e) {
    }
}

