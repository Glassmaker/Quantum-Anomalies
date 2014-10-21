package sourcecoded.quantum;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import sourcecoded.quantum.api.discovery.DiscoveryManager;

import java.util.List;

public class QACommand extends CommandBase {
    @Override
    public String getCommandName() {
        return "quantum";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/quantum <discoveries> <item|category> <hidden|unlocked> <key> <state>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
        if (args.length != 5)
            throw new WrongUsageException(getCommandUsage(sender));

        if (args[0].equals("discoveries")) {
            if (args[1].equals("item")) {
                if (args[2].equals("hidden"))
                    DiscoveryManager.hideItem(args[3], (EntityPlayer) sender, parseBoolean(sender, args[4]));
                else if (args[2].equals("unlocked"))
                    DiscoveryManager.setItemUnlock(args[3], (EntityPlayer) sender, parseBoolean(sender, args[4]));
            } else if (args[1].equals("category")) {
                if (args[2].equals("hidden"))
                    DiscoveryManager.hideCategory(args[3], (EntityPlayer) sender, parseBoolean(sender, args[4]));
                else if (args[2].equals("unlocked"))
                    DiscoveryManager.setCategoryUnlock(args[3], (EntityPlayer) sender, parseBoolean(sender, args[4]));
            }
        }
    }

    public List addTabCompletionOptions(ICommandSender sender, String[] str) {
        return str.length == 1 ? getListOfStringsMatchingLastWord(str, "discoveries") : str.length == 2 ? getListOfStringsMatchingLastWord(str, "item", "category") : str.length == 3 ? getListOfStringsMatchingLastWord(str, "hidden", "unlocked") : str.length == 5 ? getListOfStringsMatchingLastWord(str, "true", "false") : null;
    }
}
