package works.emregumus.beywitherboss.Hooks.Placeholder.executors;

import org.bukkit.entity.Player;
import works.emregumus.beywitherboss.Hooks.Placeholder.PlaceholderExecutor;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

public class BossSpawnStatusPlaceholder extends PlaceholderExecutor {
    public BossSpawnStatusPlaceholder() {
        super("getBossStatus");
    }

    public String execute(Player player, String params) {
        if (WitherBossManager.getInstance().witherBossSpawned()) {
            return "true";
        } else {
            return "false";
        }
    }
}
