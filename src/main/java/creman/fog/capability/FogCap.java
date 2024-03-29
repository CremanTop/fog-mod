package creman.fog.capability;

import creman.fog.network.fog.Dispatcher;
import creman.fog.network.fog.common.PacketFog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class FogCap implements IFog
{
    public float red = 0.0f;
    public float green = 0.0f;
    public float blue = 0.0f;
    public float density = 0.0f;

    public static IFog get(EntityPlayer player)
    {
        return player.getCapability(FogProvider.FOG_CAP, null);
    }
    @Override
    public void setColor(float red, float green, float blue)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    @Override
    public void setDensity(float density)
    {
        this.density = density;
    }

    @Override
    public float getRed()
    {
        return red;
    }

    @Override
    public float getGreen()
    {
        return green;
    }

    @Override
    public float getBlue()
    {
        return blue;
    }

    @Override
    public float getDensity()
    {
        return density;
    }

    @Override
    public void sendToClient(EntityPlayerMP playerMP)
    {
        Dispatcher.sendTo(new PacketFog(red, green, blue, density), playerMP);
    }
}
