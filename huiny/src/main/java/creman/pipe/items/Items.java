package creman.pipe.items;

import creman.pipe.Pipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Items
{
    @GameRegistry.ObjectHolder(Pipe.MOD_ID + ":pipe")
    public static pipe pipe;
    @GameRegistry.ObjectHolder(Pipe.MOD_ID + ":potion_chicken")
    public static PotionChicken1 potion_chicken;
    @SideOnly(Side.CLIENT)
    public static void initModels()
    {
        pipe.initModel();
        potion_chicken.initModel();
    }
}