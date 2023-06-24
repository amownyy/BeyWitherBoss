package works.emregumus.beywitherboss.Command.subcmd.admin.boss.Set;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Command.AbstractSubCommand;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

import java.util.List;

public class SetKilledMobAmountCommand extends AbstractSubCommand {

    public static final SetKilledMobAmountCommand INSTANCE = new SetKilledMobAmountCommand();

    public SetKilledMobAmountCommand() {
        super("killedmobamount");
    }

    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        if (lackArgs(sender, 1, args.size())) return true;
        WitherBossManager.getInstance().witherRequiredMobs.clear();
        WitherBossManager.getInstance().witherRequiredMobs.put(EntityType.valueOf(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Requirement.mob1.Mob-Type")), BeyWitherBoss.getInstance().getBossConfig().getInt("Boss.Requirement.mob1.Amount") - Integer.parseInt(args.get(0)) - 1);
        WitherBossManager.getInstance().killedmob = Integer.parseInt(args.get(0));
        return true;
    }

}
