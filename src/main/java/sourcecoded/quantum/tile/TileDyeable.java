package sourcecoded.quantum.tile;

import net.minecraft.nbt.NBTTagCompound;
import sourcecoded.quantum.api.block.Colourizer;
import sourcecoded.quantum.api.tileentity.IDyeable;

public class TileDyeable extends TileQuantum implements IDyeable {

    public Colourizer colour = Colourizer.PURPLE;

    @Override
    public void dye(Colourizer colour) {
        if (!worldObj.isRemote) {
            this.colour = colour;
            update();
        }
    }

    @Override
    public Colourizer getColour() {
        return colour;
    }

    @Override
    public void writeToNBT(NBTTagCompound tags) {
        super.writeToNBT(tags);

        tags.setInteger("colourIndex", colour.ordinal());
    }

    @Override
    public void readFromNBT(NBTTagCompound tags) {
        super.readFromNBT(tags);

        colour = Colourizer.values()[tags.getInteger("colourIndex")];
    }
}
