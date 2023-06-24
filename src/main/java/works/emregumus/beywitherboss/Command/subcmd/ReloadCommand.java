package works.emregumus.beywitherboss.Command.subcmd;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import works.emregumus.beywitherboss.Api.Utils.AdventureUtils;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Command.AbstractSubCommand;

import java.util.List;

public final class ReloadCommand extends AbstractSubCommand {

    public static final ReloadCommand INSTANCE = new ReloadCommand();

    public ReloadCommand() {
        super("reload");
    }

    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        Player player = (Player) sender;
        long time1 = System.currentTimeMillis();
        BeyWitherBoss.getInstance().getBossConfig().reload();
        BeyWitherBoss.getInstance().getOreConfig().reload();
        BeyWitherBoss.getInstance().getMessages().reload();
        AdventureUtils.consoleMessage("&aConfig reloaded in &e" + (System.currentTimeMillis() - time1) + "ms");
        return true;
    }
}
