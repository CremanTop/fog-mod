package creman.fog.capability;

import creman.fog.network.fog.Dispatcher;
import creman.fog.network.fog.common.PacketFog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public class FogCap implements IFog
{
    public float red = 0.474f;
    public float green = 0.646f;
    public float blue = 1.0f;
    public float density = 0.0005f;
    public boolean natural = true;

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
    public void setNatural(boolean natural) {
        this.natural = natural;
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
    public boolean isNatural() {
        return this.natural;
    }

    @Override
    public void sendToClient(EntityPlayerMP playerMP)
    {
        Dispatcher.sendTo(new PacketFog(red, green, blue, density, natural), playerMP);
    }
}
