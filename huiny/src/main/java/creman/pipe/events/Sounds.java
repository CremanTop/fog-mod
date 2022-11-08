package creman.pipe.events;

import creman.pipe.Pipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Sounds {
    public static final SoundEvent PIPE = registry("pipe");

    @SubscribeEvent
    public void registerSounds(RegistryEvent.Register<SoundEvent> e) {
        ForgeRegistries.SOUND_EVENTS.register(PIPE);
    }

    private static SoundEvent registry(String name) {
        ResourceLocation uniqueName = new ResourceLocation(Pipe.MOD_ID, name);
        return new SoundEvent(uniqueName).setRegistryName(uniqueName);
    }
}
