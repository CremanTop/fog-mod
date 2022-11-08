package creman.pipe;

import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = Pipe.MOD_ID,
        name = Pipe.MOD_NAME,
        version = Pipe.VERSION
)
public class Pipe {

    public static final String MOD_ID = "fogutil";
    public static final String MOD_NAME = "Fog Util";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "creman.pipe.ClientProxy", serverSide = "creman.pipe.CommonProxy")
    public static CommonProxy proxy;
    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static Pipe INSTANCE;

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
}
