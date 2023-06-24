package works.emregumus.beywitherboss.Listeners.Boss;

import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.bossbar.BossBarManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import works.emregumus.beywitherboss.Api.Utils.AdventureUtils;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Manager.WitherBlockManager;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

public class BossRequiredMobDeathListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        Entity deadEntity = event.getEntity();
        Entity killer = event.getEntity().getKiller();
        if (event.getEntity().getType().name().equals(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Requirement.mob1.Mob-Type.Vanilla"))){
            event.getDrops().clear();
            event.setDroppedExp(0);
        }
        if (killer == null) {
            boolean isEnabled = BeyWitherBoss.getInstance().getBossConfig().getConfigurationSection("Boss.Options.Debug").getBoolean("enable", false);
            if (isEnabled) {
                AdventureUtils.consoleMessage("&c[!] &7" + deadEntity.getType().name() + " &7has been killed by &c" + "Unknown " + "&7and status NOT CHANGED!");
            }
        } else {
            WitherBossManager.getInstance().witherRequiredMobs.forEach((entityType, integer) -> {
                if (deadEntity.getType() == entityType) {
                    WitherBossManager.getInstance().witherRequiredMobs.replace(entityType, integer - 1);
                    WitherBossManager.getInstance().killedmob++;
                    boolean isEnabled1 = BeyWitherBoss.getInstance().getBossConfig().getConfigurationSection("Boss.Options.Data.Save-Killed-Mob-Data").getBoolean("enable", false);
                    if (isEnabled1) {
                        BeyWitherBoss.getInstance().getData().set("Required-Mob.Killed", WitherBossManager.getInstance().killedmob);
                        BeyWitherBoss.getInstance().saveConfig();
                    }
                    boolean isEnabled = BeyWitherBoss.getInstance().getBossConfig().getConfigurationSection("Boss.Options.Debug").getBoolean("enable", false);
                    if (integer > 0) {
                        if (isEnabled) {
                            AdventureUtils.consoleMessage("&c[!] &7" + killer.getName() + " &7has killed &c" + deadEntity.getType().name() + " &7and there are &c" + integer + " &7more to go!");
                        }
                    }
                    if (integer == 0) {
                        if (isEnabled) {
                            AdventureUtils.consoleMessage("&c[!] &7" + deadEntity.getType().name() + " &7has been removed from required mobs list!");
                            AdventureUtils.consoleMessage("&c[!] &7Wither boss has been spawned!");
                        }
                        WitherBossManager.getInstance().witherRequiredMobs.clear();
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            BossBarManager bossBarManager = TabAPI.getInstance().getBossBarManager();
                            TabPlayer tabPlayer = TabAPI.getInstance().getPlayer(player.getUniqueId());
                            bossBarManager.getBossBar("killsayac").removePlayer(tabPlayer);
                        }
                        WitherBossManager.getInstance().spawnWitherBoss();
                        new WitherBlockManager(BeyWitherBoss.getInstance());
                    }
                }
            });
        }
    }
}
