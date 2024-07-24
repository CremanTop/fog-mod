package creman.fog.network.fog.server;

import creman.fog.capability.FogCap;
import creman.fog.capability.IFog;
import creman.fog.network.ServerMessageHandler;
import creman.fog.network.fog.common.PacketFog;
import net.minecraft.entity.player.EntityPlayerMP;

public class ServerHandlerFog extends ServerMessageHandler<PacketFog>
{
    @Override
    public void run(EntityPlayerMP player, PacketFog message)
    {
        IFog fog = FogCap.get(player);
        fog.setColor(message.red, message.green, message.blue);
        fog.setDensity(message.density);
        fog.setNatural(message.natural);
    }
}
