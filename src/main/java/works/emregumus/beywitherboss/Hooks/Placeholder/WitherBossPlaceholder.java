package works.emregumus.beywitherboss.Hooks.Placeholder;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Hooks.Placeholder.executors.*;

import java.util.HashMap;
import java.util.Map;

public class WitherBossPlaceholder extends PlaceholderExpansion {

    private BeyWitherBoss plugin;
    private static Map<String, PlaceholderExecutor> executors = new HashMap<>();

    public WitherBossPlaceholder(BeyWitherBoss plugin) {
        this.plugin = plugin;
        addExecutors(new PlaceholderExecutor[] {
                (PlaceholderExecutor) new BossSpawnStatusPlaceholder(),
                (PlaceholderExecutor) new BossDamagePlaceholder(),
                (PlaceholderExecutor) new BossGetTopDamagesPlaceHolder(),
                (PlaceholderExecutor) new BossRequiredMobKillCountPlaceholder(),
                (PlaceholderExecutor) new BossRequiredMobKillPercentPlaceholder(),
                (PlaceholderExecutor) new BossRemainingTimePlaceholder()
        });
    }

    private void addExecutor(PlaceholderExecutor executor) {
        executors.put(executor.identify, executor);
    }

    private void addExecutors(PlaceholderExecutor... executorList) {
        for (PlaceholderExecutor placeholderExecutor : executorList)
            addExecutor(placeholderExecutor);
    }

    @Override
    public @NotNull String getIdentifier() {
        return "beywitherboss";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Amownyy";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.2";
    }
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (params.contains(":") || (params.startsWith("get") || params.startsWith("has"))) {
            String[] data = params.split(":");
            String identify = data[0];
            if (executors.containsKey(identify)) {
                PlaceholderExecutor placeholderHandler = executors.get(identify);
                String executorParams = params.replace(identify + ":", "");
                return placeholderHandler.execute(player, executorParams);
            }
        }
        return "UNDEFINED_PLACEHOLDER";
    }
}
