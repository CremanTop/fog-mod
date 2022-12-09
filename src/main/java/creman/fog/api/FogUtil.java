package creman.fog.api;

import creman.fog.capability.FogCap;
import creman.fog.capability.IFog;
import net.minecraft.entity.player.EntityPlayerMP;

public class FogUtil
{
    public static void SetFogColor(EntityPlayerMP player, float red, float green, float blue)
    {
        if (!player.world.isRemote)
        {
            IFog fog = FogCap.get(player);
            fog.setColor(red, green, blue);
            fog.sendToClient(player);
        }
    }
    public static void SetFogDensity(EntityPlayerMP player, float density)
    {
        if (!player.world.isRemote)
        {
            IFog fog = FogCap.get(player);
            fog.setDensity(density);
            fog.sendToClient(player);
        }
    }
    public static void SetFog(EntityPlayerMP player, float red, float green, float blue, float density)
    {
        SetFogColor(player, red, green, blue);
        SetFogDensity(player, density);
    }
    public static float getRed(EntityPlayerMP player)
    {
        return FogCap.get(player).getRed();
    }
    public static float getGreen(EntityPlayerMP player)
    {
        return FogCap.get(player).getGreen();
    }
    public static float getBlue(EntityPlayerMP player)
    {
        return FogCap.get(player).getBlue();
    }
    public static float getDensity(EntityPlayerMP player)
    {
        return FogCap.get(player).getDensity();
    }
}
