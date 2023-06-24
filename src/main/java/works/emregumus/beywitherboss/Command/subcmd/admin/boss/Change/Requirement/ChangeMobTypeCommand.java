package works.emregumus.beywitherboss.Command.subcmd.admin.boss.Change.Requirement;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Command.AbstractSubCommand;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

import java.util.ArrayList;
import java.util.List;

public class ChangeMobTypeCommand extends AbstractSubCommand {

    public static final ChangeMobTypeCommand INSTANCE = new ChangeMobTypeCommand();

    public ChangeMobTypeCommand() {
        super("mobtype");
    }

    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        if (lackArgs(sender, 1, args.size())) return true;
        BeyWitherBoss.getInstance().getBossConfig().set("Boss.Requirement.mob1.Mob-Type", args.get(0));
        BeyWitherBoss.getInstance().getBossConfig().save();
        WitherBossManager.getInstance().witherRequiredMobs.clear();
        WitherBossManager.getInstance().witherRequiredMobs.put(EntityType.valueOf(args.get(0)), BeyWitherBoss.getInstance().getBossConfig().getInt("Boss.Requirement.mob1.Amount") - 1);
        sender.sendMessage("§aMob türü §e" + args.get(0) + " §aolarak değiştirildi.");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, List<String> args) {
        List<String> completions = new ArrayList<>();
        if (args.size() == 1) {
            String partialTypeName = args.get(0).toUpperCase();
            for (EntityType entityType : EntityType.values()) {
                if (entityType.isSpawnable() && entityType.name().startsWith(partialTypeName)) {
                    completions.add(entityType.name());
                }
            }
        }
        return completions;
    }

}
