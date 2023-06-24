package works.emregumus.beywitherboss.Command.subcmd.admin.boss.Set;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Command.AbstractSubCommand;

import java.util.List;

public class SetSpawnLocationCommand extends AbstractSubCommand {

    public static final SetSpawnLocationCommand INSTANCE = new SetSpawnLocationCommand();

    public SetSpawnLocationCommand() {
        super("spawnlocation");
    }
    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        //if (lackArgs(sender, 3, args.size())) return true;
        Player player = (Player) sender;
        Location location = player.getLocation();
        BeyWitherBoss.getInstance().getBossConfig().set("Boss.Location.X", location.getX());
        BeyWitherBoss.getInstance().getBossConfig().set("Boss.Location.Y", location.getY());
        BeyWitherBoss.getInstance().getBossConfig().set("Boss.Location.Z", location.getZ());
        BeyWitherBoss.getInstance().getBossConfig().set("Boss.Location.Yaw", location.getYaw());
        BeyWitherBoss.getInstance().getBossConfig().set("Boss.Location.Pitch", location.getPitch());
        BeyWitherBoss.getInstance().getBossConfig().set("Boss.Location.World", location.getWorld().getName());
        BeyWitherBoss.getInstance().getBossConfig().save();
        return true;
    }
}
