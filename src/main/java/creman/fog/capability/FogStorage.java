package creman.fog.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class FogStorage implements Capability.IStorage<IFog>
{
    @Override
    public NBTBase writeNBT(Capability<IFog> capability, IFog instance, EnumFacing side)
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setFloat("red", instance.getRed());
        tag.setFloat("green", instance.getGreen());
        tag.setFloat("blue", instance.getBlue());
        tag.setFloat("density", instance.getDensity());
        return tag;
    }

    @Override
    public void readNBT(Capability<IFog> capability, IFog instance, EnumFacing side, NBTBase nbt)
    {
        NBTTagCompound compound = (NBTTagCompound) nbt;
        instance.setColor(compound.getFloat("red"), compound.getFloat("green"), compound.getFloat("blue"));
        instance.setDensity(compound.getFloat("density"));
    }
}
