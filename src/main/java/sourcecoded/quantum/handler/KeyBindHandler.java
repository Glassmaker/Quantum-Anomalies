package sourcecoded.quantum.handler;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;
import sourcecoded.quantum.network.MessageChangeFocus;
import sourcecoded.quantum.network.NetworkHandler;
import sourcecoded.quantum.registry.QAItems;

public class KeyBindHandler {

    public static KeyBinding changeFocusKeybind;

    public static void initKeybinds() {
        changeFocusKeybind = new KeyBinding("qa.keybind.focus.change", Keyboard.KEY_F, "qa.keybind.category");
        ClientRegistry.registerKeyBinding(changeFocusKeybind);
        FMLCommonHandler.instance().bus().register(new KeyBindHandler());
    }

    @SubscribeEvent
    public void onKeyPressed(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (changeFocusKeybind.isPressed())
            NetworkHandler.wrapper.sendToServer(new MessageChangeFocus());

    }

}
