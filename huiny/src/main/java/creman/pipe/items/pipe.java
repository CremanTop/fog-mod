package creman.pipe.items;

import creman.pipe.Pipe;
import creman.pipe.events.Sounds;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class pipe extends Item {
    public pipe() {
        setRegistryName("pipe");
        setTranslationKey(Pipe.MOD_ID + ".pipe");
        setCreativeTab(Pipe.ModTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        worldIn.playSound((EntityPlayer) null, playerIn.posX, playerIn.posY, playerIn.posZ, Sounds.PIPE, SoundCategory.NEUTRAL, 0.5F, 1.0F);
        return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
}
