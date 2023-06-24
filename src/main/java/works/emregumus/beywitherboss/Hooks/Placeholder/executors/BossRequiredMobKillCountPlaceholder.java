package works.emregumus.beywitherboss.Hooks.Placeholder.executors;

import org.bukkit.entity.Player;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Hooks.Placeholder.PlaceholderExecutor;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

public class BossRequiredMobKillCountPlaceholder extends PlaceholderExecutor {

    public BossRequiredMobKillCountPlaceholder() {
        super("getBossRequiredMobKillCount");
    }

    public String execute(Player player, String params) {
        int requiredMobAmount = BeyWitherBoss.getInstance().getBossConfig().getInt("Boss.Requirement.mob1.Amount");
        return WitherBossManager.getInstance().killedmob + "/" + requiredMobAmount;
    }

}
