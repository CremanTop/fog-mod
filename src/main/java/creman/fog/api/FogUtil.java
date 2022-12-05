package creman.fog.api;

import creman.fog.ClientProxy;
import creman.fog.capability.FogCap;
import creman.fog.capability.IFog;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class FogUtil
{
    public static void SetFogColor(EntityPlayerMP player, float red, float green, float blue)
    {
        IFog fog = FogCap.get(player);
        fog.setColor(red, green, blue);
        fog.sendToClient(player);
        if (!player.world.isRemote)
        {
            fog.sendToClient(player);
        }
    }
    public static void SetFogDensity(EntityPlayerMP player, float density)
    {
        IFog fog = FogCap.get(player);
        fog.setDensity(density);
        if (!player.world.isRemote)
        {
            fog.sendToClient(player);
        }
    }
    public static void SetFog(EntityPlayerMP player, float red, float green, float blue, float density)
    {
        SetFogColor(player, red, green, blue);
        SetFogDensity(player, density);
    }
}
