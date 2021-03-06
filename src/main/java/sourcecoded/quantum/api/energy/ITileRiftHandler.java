package sourcecoded.quantum.api.energy;

/**
 * An interface for use with TileEntities
 * that are capable of holding RiftEnergy.
 * It is recommended that you use this with
 * RiftEnergyStorage
 *
 * @see sourcecoded.quantum.api.energy.RiftEnergyStorage
 *
 * @author SourceCoded
 */
public interface ITileRiftHandler {

    /**
     * Takes rift energy from the storage
     * @param amount The amount requested
     * @return The amount that was received
     */
    public int takeRiftEnergy(int amount);

    /**
     * Gives rift energy to the storage
     * @param amount The amount offered
     * @return The amount taken
     */
    public int giveRiftEnergy(int amount);

    /**
     * Get the amount of Rift Energy present in the storage
     */
    public int getRiftEnergy();

    /**
     * Get the maximum amount of Rift Energy the storage can hold
     */
    public int getMaxRiftEnergy();

    /**
     * Get the behavior of the handler when receiving energy
     */
    public EnergyBehaviour getBehaviour();

}
