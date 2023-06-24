package works.emregumus.beywitherboss.Hooks.Placeholder;

import org.bukkit.entity.Player;

public abstract class PlaceholderExecutor {
    public static String NULL_KEY = "UNDEFINED_KEY";

    protected String identify;

    public PlaceholderExecutor(String identify) {
        this.identify = identify;
    }

    public abstract String execute(Player paramPlayer, String paramString);
}
