package creman.fog.capability;

import net.minecraft.entity.player.EntityPlayerMP;

public interface IFog
{
    public void setColor(float red, float green, float blue);
    public void setDensity(float density);
    public void setNatural(boolean natural);
    public float getRed();
    public float getGreen();
    public float getBlue();
    public float getDensity();

    public boolean isNatural();

    public void sendToClient(EntityPlayerMP playerMP);
}
