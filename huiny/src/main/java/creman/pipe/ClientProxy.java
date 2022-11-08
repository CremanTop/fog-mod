package creman.pipe;

import creman.pipe.commands.FogCommand;
import creman.pipe.items.Items;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ClientCommandHandler.instance.registerCommand(new FogCommand());
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        Items.initModels();
    }

    public static int red = 0;
    public static int green = 0;
    public static int blue = 0;
    public static float density = 0.03F;

    public static int getRed()
        {
            return red;
        }
    public static int getGreen()
    {
        return green;
    }
    public static int getBlue()
    {
        return blue;
    }
    public static float getDensity()
    {
        return density;
    }
}
