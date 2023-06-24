package works.emregumus.beywitherboss.Command.subcmd.admin;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import works.emregumus.beywitherboss.Command.AbstractSubCommand;
import works.emregumus.beywitherboss.Listeners.Player.MobDamageTrackerListener;

import java.util.*;
import java.util.stream.Collectors;

public class TestCommand extends AbstractSubCommand {
    public static final TestCommand INSTANCE = new TestCommand();
    public TestCommand() {
        super("test");
    }

    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        Map<UUID, Double> sortedMap = MobDamageTrackerListener.mobDamageMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));

// UUID'leri kullanarak oyuncu nesnelerini bulma
        List<Player> topPlayers = sortedMap.keySet().stream()
                .map(Bukkit::getPlayer)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

// En çok hasarı vuran oyuncuları konsola yazdırma
        System.out.println("En çok hasarı vuran oyuncular:");
        for (int i = 0; i < topPlayers.size(); i++) {
            Player player = topPlayers.get(i);
            double damage = sortedMap.get(player.getUniqueId());
            int rank = i + 1;
            System.out.println("Sıra: " + rank);
            System.out.println("Oyuncu: " + player.getName());
            System.out.println("Hasar: " + damage);
            System.out.println();
        }
        return true;
    }
}
