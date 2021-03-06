package sourcecoded.quantum.api.energy;

import net.minecraft.item.ItemStack;

/**
 * An interface for use on Items that are
 * capable of holding Rift Energy. It is
 * recommended that you use this in conjunction
 * with RiftEnergyStorage
 *
 * @see sourcecoded.quantum.api.energy.RiftEnergyStorage
 *
 * @author SourceCoded
 */
public interface IItemRiftHandler {

    /**
     * Takes rift energy from the storage
     * @param stack  The Itemstack instance of this item
     * @param amount The amount requested
     * @return The amount that was received
     */
    public int takeRiftEnergy(ItemStack stack, int amount);

    /**
     * Gives rift energy to the storage
     * @param stack The Itemstack instance of this item
     * @param amount The amount offered
     * @return The amount taken
     */
    public int giveRiftEnergy(ItemStack stack, int amount);

    /**
     * Get the amount of Rift Energy present in the storage
     */
    public int getRiftEnergy();

    /**
     * Get the maximum amount of Rift Energy the storage can hold
     */
    public int getMaxRiftEnergy();

}
