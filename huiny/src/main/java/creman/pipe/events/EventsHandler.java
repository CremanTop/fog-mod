package creman.pipe.events;

import creman.pipe.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
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
//            if (e.getEntity().world.isRemote)
//            {
//                EntityPlayer player = (EntityPlayer) e.getEntity();
//                player.sendMessage(new TextComponentString("Hello, %p!".replace("%p", player.getName())));
//            }
        }
    }
//    @SubscribeEvent
//    public void playerClone(PlayerEvent.Clone e) {
//        e.getEntityPlayer().getEntityData().setIntArray("Doom_fog",e.getOriginal().getEntityData().getIntArray("Doom_fog"));
//    }

    @SubscribeEvent
    public void bookshelfClick(PlayerInteractEvent.RightClickBlock e){
        if (e.getWorld().isRemote)
        {
            return;
        }
        Block clickedBlock = e.getWorld().getBlockState(e.getPos()).getBlock();
        if (clickedBlock.equals(Blocks.BOOKSHELF)){
            //e.getEntityPlayer().sendMessage(new TextComponentString("Да, это оно!"));
        }
    }
//    @SubscribeEvent
//    public void bookshelfClick(PlayerInteractEvent.EntityInteract e){
//        e.getEntityPlayer().sendMessage(e.getTarget().getDisplayName());
//    }
}
