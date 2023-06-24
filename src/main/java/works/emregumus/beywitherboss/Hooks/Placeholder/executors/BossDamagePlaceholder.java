package works.emregumus.beywitherboss.Hooks.Placeholder.executors;

import org.bukkit.entity.Player;
import works.emregumus.beywitherboss.Hooks.Placeholder.PlaceholderExecutor;
import works.emregumus.beywitherboss.Listeners.Player.MobDamageTrackerListener;

public class BossDamagePlaceholder extends PlaceholderExecutor {

    public BossDamagePlaceholder() {
        super("getBossDamage");
    }

    public String execute(Player Player, String param) {
        double damage = MobDamageTrackerListener.mobDamageMap.getOrDefault(Player.getUniqueId(), 0.0);
        return "" + damage;
    }
}
