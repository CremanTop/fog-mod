package creman.pipe;

import creman.pipe.events.EventsHandler;
import creman.pipe.events.Sounds;
import creman.pipe.items.GeneralItem;
import creman.pipe.items.PotionChicken1;
import creman.pipe.items.PotionInit;
import creman.pipe.items.pipe;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        MinecraftForge.EVENT_BUS.register(new EventsHandler());
        MinecraftForge.EVENT_BUS.register(new Sounds());
    }
    public void init(FMLInitializationEvent e) {
    }
    public void postInit(FMLPostInitializationEvent e) {
    }
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new pipe());
        event.getRegistry().register(new PotionChicken1());
        event.getRegistry().register((new GeneralItem("PotionChicken")).setCreativeTab(Pipe.ModTab));
    }

    @SubscribeEvent
    public static void registerPotion(RegistryEvent.Register<Potion> event) {
        PotionInit.preparePotion();
        PotionInit.registerPotion(event);
    }

//    @SubscribeEvent
//    public static void registerPotionType(RegistryEvent.Register<PotionType> event) {
//        PotionTypeInit.preparePotionType();
//        PotionTypeInit.registerPotionType(event);
//    }
}

