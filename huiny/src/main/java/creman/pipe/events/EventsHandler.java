package creman.pipe.events;

import creman.pipe.ClientProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventsHandler {
    @SubscribeEvent
    public void fogColor(EntityViewRenderEvent.FogColors e){
        if (e.getEntity() instanceof EntityPlayer) {
            if (e.getEntity().getEntityData().getBoolean("Doom_fog")) {
                e.setRed(ClientProxy.red);
                e.setGreen(ClientProxy.green);
                e.setBlue(ClientProxy.blue);
            }
            else {
                e.setRed(0);
                e.setGreen(0);
                e.setBlue(0);
            }
        }
    }

    @SubscribeEvent
    public void fogDensity(EntityViewRenderEvent.FogDensity e){
        if (e.getEntity() instanceof EntityPlayer)
        {
            e.setDensity(ClientProxy.density);
            e.setCanceled(true);
        }
    }
    @SubscribeEvent
    public void onJoin(EntityJoinWorldEvent e) {
        if (e.getEntity() instanceof EntityPlayer) {
            if (!e.getEntity().getEntityData().getBoolean("Doom_fog"))
            {
                ClientProxy.red = 256;
                ClientProxy.green = 0;
                ClientProxy.blue = 0;
                e.getEntity().getEntityData().setBoolean("Doom_fog",true);
            }
        }
    }
}
