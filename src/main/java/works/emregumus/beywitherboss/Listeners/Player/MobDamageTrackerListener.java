package works.emregumus.beywitherboss.Listeners.Player;

import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.MythicBukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import works.emregumus.beywitherboss.BeyWitherBoss;

import java.util.Map;
import java.util.UUID;

public class MobDamageTrackerListener implements Listener {

    public static Map<UUID, Double> mobDamageMap;

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity entity = event.getEntity();
        MythicMob witherBossvariant1 = MythicBukkit.inst().getMobManager().getMythicMob(
                BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Variants.variant1")
        ).orElse(null);
        MythicMob witherBossvariant2 = MythicBukkit.inst().getMobManager().getMythicMob(
                BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Variants.variant2")
        ).orElse(null);
        if (damager instanceof Player && entity instanceof LivingEntity){
            Player player = (Player) damager;
            UUID playerUUID = player.getUniqueId();
            LivingEntity target = (LivingEntity) entity;

            if (MythicBukkit.inst().getAPIHelper().isMythicMob(target) && MythicBukkit.inst().getAPIHelper().getMythicMobInstance(target).getType().equals(witherBossvariant1)) {
                double damage = event.getFinalDamage();

                double totalDamage = mobDamageMap.getOrDefault(playerUUID, 0.0);
                totalDamage += damage;
                mobDamageMap.put(playerUUID, totalDamage);
            }
            if (MythicBukkit.inst().getAPIHelper().isMythicMob(target) && MythicBukkit.inst().getAPIHelper().getMythicMobInstance(target).getType().equals(witherBossvariant2)) {
                double damage = event.getFinalDamage();

                double totalDamage = mobDamageMap.getOrDefault(playerUUID, 0.0);
                totalDamage += damage;
                mobDamageMap.put(playerUUID, totalDamage);
            }
        }
    }
}
