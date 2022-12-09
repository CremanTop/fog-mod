package creman.fog.events;

import creman.fog.Fog;
import creman.fog.capability.FogCap;
import creman.fog.capability.FogProvider;
import creman.fog.capability.IFog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler
{
    @SubscribeEvent
    public void fogColor(EntityViewRenderEvent.FogColors e)
    {
        if (e.getEntity() instanceof EntityPlayer)
        {
            IFog fog = FogCap.get((EntityPlayer) e.getEntity());
            e.setRed(fog.getRed());
            e.setGreen(fog.getGreen());
            e.setBlue(fog.getBlue());
        }
    }

    @SubscribeEvent
    public void fogDensity(EntityViewRenderEvent.FogDensity e)
    {
        if (e.getEntity() instanceof EntityPlayer)
        {
            IFog fog = FogCap.get((EntityPlayer) e.getEntity());
            e.setDensity(fog.getDensity());
            e.setCanceled(true);
        }
    }
    @SubscribeEvent
    public void onJoin(EntityJoinWorldEvent e)
    {
        if (e.getEntity() instanceof EntityPlayer)
        {
            IFog fog = FogCap.get((EntityPlayer) e.getEntity());

            if (!e.getEntity().world.isRemote)
            {
                fog.sendToClient((EntityPlayerMP) e.getEntity());
            }
        }
    }

    public static final ResourceLocation FOG_CAP = new ResourceLocation(Fog.MOD_ID, "fog");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        if (!(event.getObject() instanceof EntityPlayer)) return;
        event.addCapability(FOG_CAP, new FogProvider());
    }

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event)
    {
        EntityPlayer player = event.getEntityPlayer();
        IFog fog = player.getCapability(FogProvider.FOG_CAP, null);
        IFog oldFog = event.getOriginal().getCapability(FogProvider.FOG_CAP, null);

        fog.setColor(oldFog.getRed(), oldFog.getGreen(), oldFog.getBlue());
        fog.setDensity(oldFog.getDensity());
        if (!player.world.isRemote)
        {
            fog.sendToClient((EntityPlayerMP) player);
        }
    }
}
