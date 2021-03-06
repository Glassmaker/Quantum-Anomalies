package sourcecoded.quantum.discovery.category;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import sourcecoded.quantum.Constants;
import sourcecoded.quantum.api.discovery.DiscoveryCategory;
import sourcecoded.quantum.registry.QAItems;

public class CategoryItems extends DiscoveryCategory {

    public CategoryItems() {
        super("QA|Items");

        //this.displayStack = new ItemStack(QAItems.OBSIDIAN_JEWEL.getItem());

        this.setIcon(new ResourceLocation(Constants.MODID, "textures/gui/itemVec.png"));

        this.setHiddenByDefault(false);
        this.setUnlockedByDefault(false);
    }
}
