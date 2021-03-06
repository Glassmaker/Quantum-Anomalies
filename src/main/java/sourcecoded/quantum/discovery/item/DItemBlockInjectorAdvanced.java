package sourcecoded.quantum.discovery.item;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import sourcecoded.quantum.Constants;
import sourcecoded.quantum.api.discovery.DiscoveryItem;
import sourcecoded.quantum.api.discovery.DiscoveryPage;
import sourcecoded.quantum.api.injection.InjectorRegistry;
import sourcecoded.quantum.discovery.QADiscoveries;
import sourcecoded.quantum.registry.QABlocks;

public class DItemBlockInjectorAdvanced extends DiscoveryItem {
    public DItemBlockInjectorAdvanced() {
        super("QA|InjectionAdv");

        this.icon = new ResourceLocation(Constants.MODID, "textures/gui/dropVec.png");

        this.x = 100; this.y = 130;

        this.setHiddenByDefault(false);
        this.setUnlockedByDefault(false);

        this.setSpecial(true);

        this.addParent(QADiscoveries.Item.INJECTION_BLOCKS.get().getKey());
        this.addParent(QADiscoveries.Item.INJECTION.get().getKey());

        this.addPage(new DiscoveryPage(this.getUnlocalizedName(), this.getPrefixKey() + ".page.0"));
        this.addPage(new DiscoveryPage(this.getUnlocalizedName(), new ResourceLocation(Constants.MODID, "textures/discovery/injection_1.png"),this.getPrefixKey() + ".page.1"));
        this.addPage(new DiscoveryPage(this.getUnlocalizedName(), new ResourceLocation(Constants.MODID, "textures/discovery/injection_2.png"),this.getPrefixKey() + ".page.2"));
        this.addPage(new DiscoveryPage(this.getUnlocalizedName(), new ResourceLocation(Constants.MODID, "textures/discovery/injection_3.png"),this.getPrefixKey() + ".page.3"));
    }
}