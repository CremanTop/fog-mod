package creman.pipe.items;

import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;

public class PotionInit
{
    public static Potion PotionChicken;

    public static ArrayList<Potion> potionList = new ArrayList<>();

    public static void preparePotion()
    {
        PotionChicken = ((Potion) (new PotionStandart(false, 15739029)).setIconIndex(7, 2).setRegistryName("Chicken")).setPotionName("Potion.Chicken");
        potionList.add(PotionChicken);
    }

    public static void registerPotion(RegistryEvent.Register<Potion> e) {
        for (Potion potion : potionList)
            e.getRegistry().register(potion);
    }
}
