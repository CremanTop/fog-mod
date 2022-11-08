package creman.pipe.items;

import creman.pipe.Pipe;
import net.minecraft.item.Item;

public class GeneralItem extends Item {
    public GeneralItem(String Name) {
        setRegistryName(Name);
        setTranslationKey(Pipe.MOD_ID + "." + Name);
    }
}
