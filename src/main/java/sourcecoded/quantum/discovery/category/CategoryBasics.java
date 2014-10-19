package sourcecoded.quantum.discovery.category;

import net.minecraft.item.ItemStack;
import sourcecoded.quantum.api.discovery.DiscoveryCategory;
import sourcecoded.quantum.registry.QAItems;

public class CategoryBasics extends DiscoveryCategory {

    public CategoryBasics() {
        super("QA|Basics");

        this.displayStack = new ItemStack(QAItems.JOURNAL.getItem());

        this.setHiddenByDefault(false);
        this.setUnlockedByDefault(true);
    }
}
