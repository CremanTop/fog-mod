package creman.pipe.items;

import creman.pipe.Pipe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
//import shadows.plants2.Plants2;

//public class PotionBase extends PotionType {
//    public PotionBase(String name, PotionEffect ... types) {
//        super(Pipe.MOD_ID + "." + name, types);
//        this.setRegistryName(name);
//        //Plants2.INFO.getPotionTypeList().add(this);
//    }
//}

public class PotionStandart extends Potion
{
    public static final ResourceLocation icon = new ResourceLocation(Pipe.MOD_ID.toLowerCase(), "textures/gui/container/potion.png");

    public PotionStandart(boolean isBadEffectIn, int liquidColorIn) {
        super(isBadEffectIn, liquidColorIn);
        if (!isBadEffectIn)
            setBeneficial();
    }

    public Potion setIconIndex(int x, int y) {
        super.setIconIndex(x, y);
        return this;
    }

    public int getStatusIconIndex() {
        ITextureObject texture = (Minecraft.getMinecraft()).renderEngine.getTexture(icon);
        (Minecraft.getMinecraft()).renderEngine.bindTexture(icon);
        return super.getStatusIconIndex();
    }
}
