package sourcecoded.quantum.item;

import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import sourcecoded.core.crafting.ICraftableItem;
import sourcecoded.quantum.api.CraftingContext;
import sourcecoded.quantum.api.arrangement.ArrangementRegistry;
import sourcecoded.quantum.api.arrangement.ArrangementShapedRecipe;
import sourcecoded.quantum.api.discovery.DiscoveryManager;
import sourcecoded.quantum.api.injection.IInjectorRecipe;
import sourcecoded.quantum.discovery.QADiscoveries;
import sourcecoded.quantum.entity.EntityItemJewel;
import sourcecoded.quantum.network.MessageBlockBreakFX;
import sourcecoded.quantum.network.NetworkHandler;
import sourcecoded.quantum.registry.QAItems;

import java.util.List;

public class ItemObsidianJewel extends ItemQuantum implements ICraftableItem, IInjectorRecipe {

    public ItemObsidianJewel() {
        this.setTextureName("obsidianJewel");
        this.setUnlocalizedName("itemObsidianJewel");
        setMaxDamage(0);
        setHasSubtypes(true);
        setMaxStackSize(8);
    }

    public void getSubItems(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(this, 1, 0));
        list.add(new ItemStack(this, 1, 1));
    }

    public boolean hasCustomEntity(ItemStack stack) {
        return stack.getItemDamage() == 1;
    }

    public Entity createEntity(World world, Entity location, ItemStack itemstack) {
        return new EntityItemJewel(world, location, itemstack);
    }

    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote && world.getBlock(x, y, z) == Blocks.obsidian) {
                DiscoveryManager.unlockItem(QADiscoveries.Item.INJECTION.get().getKey(), player, false);

                NetworkHandler.wrapper.sendToAllAround(new MessageBlockBreakFX(x, y, z), new NetworkRegistry.TargetPoint(world.provider.dimensionId, x, y, z, 20));
                world.setBlock(x, y, z, Blocks.air);

            item.stackSize -= 1;
            if (item.stackSize < 0)
                item = null;

            return !world.isRemote;
        }

        return false;
    }

    @Override
    public IRecipe[] getRecipes(Item item) {
        ArrangementRegistry.addRecipe(new ArrangementShapedRecipe(new ItemStack(QAItems.OBSIDIAN_JEWEL.getItem()), "ogo", "gdg", "ogo", 'o', Blocks.obsidian, 'g', Blocks.glass, 'd', Items.diamond));
        return new IRecipe[0];
    }

    public boolean hasEffect(ItemStack stack, int meta) {
        return getDamage(stack) == 1;
    }

    @Override
    public int getEnergyRequired() {
        return 100000;
    }

    @Override
    public byte getTier() {
        return 3;
    }

    @Override
    public ItemStack getInput() {
        return new ItemStack(this, 1, 0);
    }

    @Override
    public ItemStack getOutput() {
        return new ItemStack(this, 1, 1);
    }

    @Override
    public CraftingContext getContext() {
        return CraftingContext.getStandardContext();
    }
}
