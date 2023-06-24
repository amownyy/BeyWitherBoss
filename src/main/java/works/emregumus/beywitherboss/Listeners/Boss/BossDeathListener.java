package works.emregumus.beywitherboss.Listeners.Boss;

import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.bukkit.events.MythicMobDeathEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

public class BossDeathListener implements Listener {

    @EventHandler
    public void onBossDeath(MythicMobDeathEvent event) {
        MythicMob witherBossvariant2 = MythicBukkit.inst().getMobManager().getMythicMob(
                BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Variants.variant2")
        ).orElse(null);
        if (MythicBukkit.inst().getAPIHelper().getMythicMobInstance(event.getEntity()).getType().equals(witherBossvariant2)){
            WitherBossManager.getInstance().witherBossSpawned = false;
        }
    }
}
