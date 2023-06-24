package works.emregumus.beywitherboss.Hooks.Placeholder.executors;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import works.emregumus.beywitherboss.Hooks.Placeholder.PlaceholderExecutor;
import works.emregumus.beywitherboss.Listeners.Player.MobDamageTrackerListener;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class BossGetTopDamagesPlaceHolder extends PlaceholderExecutor {

    public BossGetTopDamagesPlaceHolder() {
        super("getBossTopDamages");
    }

    public String execute(Player player, String paramString) {
        String[] data = paramString.split(":");
        String list = data[0];
        String playername = data[1];
        Map<UUID, Double> sortedMap = MobDamageTrackerListener.mobDamageMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        if (list.equalsIgnoreCase("1")) {
            for (Map.Entry<UUID, Double> entry : sortedMap.entrySet()) {
                @Nullable Player player1 = Bukkit.getPlayer(entry.getKey());
                if (player1 != null) {
                    double damage = entry.getValue();
                    return String.valueOf(damage);
                }
            }
        }
        if (list.equalsIgnoreCase("2")) {
            for (Map.Entry<UUID, Double> entry : sortedMap.entrySet()) {
                @Nullable Player player1 = Bukkit.getPlayer(entry.getKey());
                if (player1 != null) {
                    double damage = entry.getValue();
                    return String.valueOf(damage);
                }
            }
        }
        if (list.equalsIgnoreCase("3")) {
            for (Map.Entry<UUID, Double> entry : sortedMap.entrySet()) {
                @Nullable Player player1 = Bukkit.getPlayer(entry.getKey());
                if (player1 != null) {
                    double damage = entry.getValue();
                    return String.valueOf(damage);
                }
            }
        }
        return null;
    }
}
