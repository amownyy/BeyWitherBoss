package works.emregumus.beywitherboss.Command.subcmd.admin;

import org.bukkit.command.CommandSender;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Command.AbstractSubCommand;

import java.util.List;

public class DebugCommand extends AbstractSubCommand {

    public static final DebugCommand INSTANCE = new DebugCommand();

    public DebugCommand() {
        super("debug");
    }

    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        if (lackArgs(sender, 1, args.size())) return true;
        boolean enable = Boolean.parseBoolean(args.get(0));
        BeyWitherBoss.getInstance().getBossConfig().set("Boss.Options.Debug.enable", enable);
        BeyWitherBoss.getInstance().getBossConfig().save();
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, List<String> args) {
        if (args.size() == 1) {
            return super.filterStartingWith(List.of("true", "false"), args.get(0));
        }
        return null;
    }

}
