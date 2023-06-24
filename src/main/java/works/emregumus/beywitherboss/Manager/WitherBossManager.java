package works.emregumus.beywitherboss.Manager;

import io.lumine.mythic.api.mobs.MythicMob;
import io.lumine.mythic.bukkit.BukkitAdapter;
import io.lumine.mythic.bukkit.MythicBukkit;
import io.lumine.mythic.core.mobs.ActiveMob;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import works.emregumus.beywitherboss.Api.Utils.AdventureUtils;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Listeners.Player.MobDamageTrackerListener;

import java.util.HashMap;

public class WitherBossManager {

    private final BeyWitherBoss plugin;
    public static WitherBossManager instance;
    public HashMap<EntityType, Integer> witherRequiredMobs;
    public boolean witherBossSpawned;
    public int killedmob = 0;

    public WitherBossManager(BeyWitherBoss plugin) {
        this.plugin = plugin;
        instance = this;
        witherRequiredMobs = new HashMap<>();
        MobDamageTrackerListener.mobDamageMap = new HashMap<>();
        if (BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Requirement.mob1.Mob-Type.Vanilla") != null) {
            loadRequiredMobs();
        } else {
            //customLoadRequiredMobs();
        }
    }

    private void loadRequiredMobs() {
        BeyWitherBoss.getInstance().getBossConfig().getConfigurationSection("Boss.Requirement").getKeys(false).forEach(requirement -> {
            String requiredMob = BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Requirement." + requirement + ".Mob-Type.Vanilla");
            int requiredMobAmount = BeyWitherBoss.getInstance().getBossConfig().getInt("Boss.Requirement." + requirement + ".Amount");

            AdventureUtils.consoleMessage("&a[!] &7" + requiredMob + "&a(&7" + requiredMobAmount + "&a)" + " &ahas been added to WITHER required mobs list!");
            boolean isEnabled = BeyWitherBoss.getInstance().getBossConfig().getConfigurationSection("Boss.Options.Data.Save-Killed-Mob-Data").getBoolean("enable", false);
            if (isEnabled) {
                witherRequiredMobs.put(EntityType.valueOf(requiredMob), requiredMobAmount - BeyWitherBoss.getInstance().getData().getInt("Required-Mob.Killed") - 1);
                killedmob = BeyWitherBoss.getInstance().getData().getInt("Required-Mob.Killed");
            } else {
                witherRequiredMobs.put(EntityType.valueOf(requiredMob), requiredMobAmount - 1);
            }
        });
    }


    public void spawnWitherBoss() {
        MythicMob witherBoss = MythicBukkit.inst().getMobManager().getMythicMob(
                BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Name")
        ).orElse(null);
        Location spawnLocation = new Location(
                BeyWitherBoss.getInstance().getServer().getWorld(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Location.World")),
                BeyWitherBoss.getInstance().getBossConfig().getDouble("Boss.Location.X"),
                BeyWitherBoss.getInstance().getBossConfig().getDouble("Boss.Location.Y"),
                BeyWitherBoss.getInstance().getBossConfig().getDouble("Boss.Location.Z")
        );
        float spawnYaw = (float) BeyWitherBoss.getInstance().getBossConfig().getDouble("Boss.Location.Yaw");
        float spawnPitch = (float) BeyWitherBoss.getInstance().getBossConfig().getDouble("Boss.Location.Pitch");
        if (witherBoss == null) {
            AdventureUtils.consoleMessage("&c[!] &7Wither boss is null!");
            return;
        }
        ActiveMob witherBossMob = witherBoss.spawn(BukkitAdapter.adapt(spawnLocation),1);
        witherBossMob.getLocation().setYaw(spawnYaw);
        witherBossMob.getLocation().setPitch(spawnPitch);
        Entity witherBossEntity = witherBossMob.getEntity().getBukkitEntity();
        witherBossSpawned = true;
    }


    public static WitherBossManager getInstance() {
        return instance;
    }

    public boolean witherBossSpawned() {
        return witherBossSpawned;
    }
}
