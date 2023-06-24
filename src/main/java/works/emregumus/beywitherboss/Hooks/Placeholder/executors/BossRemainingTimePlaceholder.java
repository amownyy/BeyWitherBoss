package works.emregumus.beywitherboss.Hooks.Placeholder.executors;

import org.bukkit.entity.Player;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Hooks.Placeholder.PlaceholderExecutor;

import java.util.concurrent.TimeUnit;

public class BossRemainingTimePlaceholder extends PlaceholderExecutor {

    public BossRemainingTimePlaceholder() {
        super("getBossRemainingTime");
    }

    public String execute(Player player, String paramString) {
        String[] data = paramString.split(":");
        String list = data[0];
        int[] timeComponents = convertSecondsToTimeComponents(BeyWitherBoss.getInstance().getData().getInt("Kalan-Sure"));
        if (list.equalsIgnoreCase("gun")) {
            return String.valueOf(timeComponents[0]);
        }
        if (list.equalsIgnoreCase("saat")) {
            return String.valueOf(timeComponents[1]);
        }
        if (list.equalsIgnoreCase("dakika")) {
            return String.valueOf(timeComponents[2]);
        }
        if (list.equalsIgnoreCase("saniye")) {
            return String.valueOf(timeComponents[3]);
        }
        return null;
    }

    private int[] convertSecondsToTimeComponents(long totalSeconds) {
        int days = (int) TimeUnit.SECONDS.toDays(totalSeconds);
        long remainingSeconds = totalSeconds - TimeUnit.DAYS.toSeconds(days);
        int hours = (int) TimeUnit.SECONDS.toHours(remainingSeconds);
        remainingSeconds -= TimeUnit.HOURS.toSeconds(hours);
        int minutes = (int) TimeUnit.SECONDS.toMinutes(remainingSeconds);
        remainingSeconds -= TimeUnit.MINUTES.toSeconds(minutes);
        int seconds = (int) remainingSeconds;
        return new int[]{days, hours, minutes, seconds};
    }

}
