package creman.fog.api;

import creman.fog.ClientProxy;

public class FogUtil
{
    public static void SetFogColor(float red, float green, float blue)
    {
        ClientProxy.red = red;
        ClientProxy.green = green;
        ClientProxy.blue = blue;
    }
    public static void SetFogDensity(float density)
    {
        ClientProxy.density = density;
    }
    public static void SetFog(float red, float green, float blue, float density)
    {
        SetFogColor(red, green, blue);
        SetFogDensity(density);
    }
}
