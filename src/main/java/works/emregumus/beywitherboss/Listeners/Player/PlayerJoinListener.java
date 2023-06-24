package works.emregumus.beywitherboss.Listeners.Player;

import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.bossbar.BossBarManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        TabPlayer tabPlayer = TabAPI.getInstance().getPlayer(event.getPlayer().getUniqueId());
        BossBarManager bossBarManager = TabAPI.getInstance().getBossBarManager();
        if (WitherBossManager.getInstance().witherBossSpawned == false) {
            bossBarManager.getBossBar("kafabul").removePlayer(tabPlayer);
        }
    }
}
