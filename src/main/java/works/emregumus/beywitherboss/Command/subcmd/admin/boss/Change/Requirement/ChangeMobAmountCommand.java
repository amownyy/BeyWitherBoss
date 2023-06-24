package works.emregumus.beywitherboss.Command.subcmd.admin.boss.Change.Requirement;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Command.AbstractSubCommand;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

import java.util.List;

public class ChangeMobAmountCommand extends AbstractSubCommand {

    public static final ChangeMobAmountCommand INSTANCE = new ChangeMobAmountCommand();

    public ChangeMobAmountCommand() {
        super("mobamount");
    }

    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        if (lackArgs(sender, 1, args.size())) return true;
        try {
            int amount = Integer.parseInt(args.get(0));
            BeyWitherBoss.getInstance().getBossConfig().set("Boss.Requirement.mob1.Amount", amount);
            BeyWitherBoss.getInstance().getBossConfig().save();
            WitherBossManager.getInstance().witherRequiredMobs.clear();
            WitherBossManager.getInstance().witherRequiredMobs.put(EntityType.valueOf(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Requirement.mob1.Mob-Type")), (amount - 1));
            sender.sendMessage("§aMob sayısı §e" + amount + " §aolarak değiştirildi.");
        } catch (NumberFormatException e) {
            sender.sendMessage("§cLütfen bir sayı giriniz.");
            return true;
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, List<String> args) {
        if (args.size() == 1) {
            return super.filterStartingWith(List.of("adet"), args.get(0));
        }
        return null;
    }

}
