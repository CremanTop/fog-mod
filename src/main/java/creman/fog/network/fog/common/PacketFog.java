package creman.fog.network.fog.common;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketFog implements IMessage
{
    public float red = 0.0f;
    public float green = 0.0f;
    public float blue = 0.0f;
    public float density = 0.0f;
    public boolean natural = true;

    public PacketFog()
    {
        super();
    }

    public PacketFog(float red, float green, float blue, float density, boolean natural)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.density = density;
        this.natural = natural;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.red = buf.readFloat();
        this.green = buf.readFloat();
        this.blue = buf.readFloat();
        this.density = buf.readFloat();
        this.natural = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeFloat(red);
        buf.writeFloat(green);
        buf.writeFloat(blue);
        buf.writeFloat(density);
        buf.writeBoolean(natural);
    }
}
