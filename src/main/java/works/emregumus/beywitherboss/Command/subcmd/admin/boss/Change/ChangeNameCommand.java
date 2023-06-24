package works.emregumus.beywitherboss.Command.subcmd.admin.boss.Change;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Command.AbstractSubCommand;

import java.util.List;

public class ChangeNameCommand extends AbstractSubCommand {

    public static final ChangeNameCommand INSTANCE = new ChangeNameCommand();

    public ChangeNameCommand() {
        super("name");
    }

    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        if (lackArgs(sender, 1, args.size())) return true;
        Player player = (Player) sender;
        BeyWitherBoss.getInstance().getBossConfig().set("Boss.Name", args.get(0));
        BeyWitherBoss.getInstance().getBossConfig().save();
        return true;
    }

}
