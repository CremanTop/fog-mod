package creman.fog.network.fog.client;

import creman.fog.capability.FogCap;
import creman.fog.capability.IFog;
import creman.fog.network.ClientMessageHandler;
import creman.fog.network.fog.common.PacketFog;
import net.minecraft.client.entity.EntityPlayerSP;

public class ClientHandlerFog extends ClientMessageHandler<PacketFog>
{

    @Override
    public void run(EntityPlayerSP player, PacketFog message)
    {
        IFog fog = FogCap.get(player);
        fog.setColor(message.red, message.green, message.blue);
        fog.setDensity(message.density);
        fog.setNatural(message.natural);
    }
}
