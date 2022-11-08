package creman.pipe.items;

import creman.pipe.Pipe;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionChicken1 extends Item {
    public PotionChicken1(){
        setRegistryName("potion_chicken");
        setTranslationKey(Pipe.MOD_ID + ".potion_chicken");
        setCreativeTab(Pipe.ModTab);
        setMaxStackSize(1);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}

