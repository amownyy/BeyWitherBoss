package works.emregumus.beywitherboss.Hooks.Placeholder.executors;

import org.bukkit.entity.Player;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Hooks.Placeholder.PlaceholderExecutor;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

public class BossRequiredMobKillPercentPlaceholder extends PlaceholderExecutor {

    public BossRequiredMobKillPercentPlaceholder() {
        super("getBossRequiredMobKillPercent");
    }

    public String execute(Player player, String params) {
        int requiredMobAmount = BeyWitherBoss.getInstance().getBossConfig().getInt("Boss.Requirement.mob1.Amount");
        double kalanyuzde = 100.0*WitherBossManager.getInstance().killedmob/requiredMobAmount;
        return "%" + kalanyuzde;
    }

}
