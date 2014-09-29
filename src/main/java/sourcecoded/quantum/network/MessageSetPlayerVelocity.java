package sourcecoded.quantum.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class MessageSetPlayerVelocity implements IMessage, IMessageHandler<MessageSetPlayerVelocity, IMessage> {

    public double x, y, z;

    public MessageSetPlayerVelocity() {}
    public MessageSetPlayerVelocity(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x = buf.readDouble();
        y = buf.readDouble();
        z = buf.readDouble();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeDouble(x);
        buf.writeDouble(y);
        buf.writeDouble(z);
    }

    @Override
    public IMessage onMessage(MessageSetPlayerVelocity message, MessageContext ctx) {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        player.motionX += message.x;
        player.motionY += message.y;
        player.motionZ += message.z;
        return null;
    }
}