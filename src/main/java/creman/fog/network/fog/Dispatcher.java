package creman.fog.network.fog;

import creman.fog.Fog;
import creman.fog.network.AbstractDispatcher;
import creman.fog.network.fog.client.ClientHandlerFog;
import creman.fog.network.fog.common.PacketFog;
import creman.fog.network.fog.server.ServerHandlerFog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.relauncher.Side;

public class Dispatcher
{
    public static final AbstractDispatcher DISPATCHER = new AbstractDispatcher(Fog.MOD_ID)
    {
        @Override
        public void register()
        {
            register(PacketFog.class, ServerHandlerFog.class, Side.SERVER);
            register(PacketFog.class, ClientHandlerFog.class, Side.CLIENT);
        }
    };

    /**
     * Send message to players who are tracking given entity
     */
    public static void sendToTracked(Entity entity, IMessage message)
    {
        DISPATCHER.sendToTracked(entity, message);
    }

    /**
     * Send message to given player
     */
    public static void sendTo(IMessage message, EntityPlayerMP player)
    {
        DISPATCHER.sendTo(message, player);
    }

    /**
     * Send message to the server
     */
    public static void sendToServer(IMessage message)
    {
        DISPATCHER.sendToServer(message);
    }

    /**
     * Register all the networking messages and message handlers
     */
    public static void register()
    {
        DISPATCHER.register();
    }
}