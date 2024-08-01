package creman.fog;

import creman.fog.commands.FogCommand;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Fog.MOD_ID, name = Fog.MOD_NAME, version = Fog.VERSION)
public class Fog
{
    public static final String MOD_ID = "fog";
    public static final String MOD_NAME = "Fog Util";
    public static final String VERSION = "1.0.3";

    @SidedProxy(clientSide = "creman.fog.ClientProxy", serverSide = "creman.fog.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
    @Mod.EventHandler
    public void server(FMLServerStartingEvent event) {
        proxy.server(event);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new FogCommand());
    }
}
