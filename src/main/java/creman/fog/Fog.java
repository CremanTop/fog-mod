package creman.fog;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(modid = Fog.MOD_ID, name = Fog.MOD_NAME, version = Fog.VERSION)
public class Fog
{
    public static final String MOD_ID = "fog";
    public static final String MOD_NAME = "Fog Util";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "creman.fog.ClientProxy", serverSide = "creman.fog.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MOD_ID)
    public static Fog FOG;
    public static Configuration config;
    public static float red = 0f;
    public static float green = 0f;
    public static float blue = 0f;
    public static float density = 0f;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        proxy.preInit(event);

        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        red = config.getFloat("Red", "general", 0.3f, -1.0f, 1.0f, "The value of the red fog color channel");
        green = config.getFloat("Green", "general", 0.7f, -1.0f, 1.0f, "The value of the green fog color channel");
        blue = config.getFloat("Blue", "general", 1.0f, -1.0f, 1.0f, "The value of the blue fog color channel");
        density = config.getFloat("Density", "general", 0.005f, 0.0f, 1.0f, "Fog density");
        if (config.hasChanged())
        {
            config.save();
        }
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
