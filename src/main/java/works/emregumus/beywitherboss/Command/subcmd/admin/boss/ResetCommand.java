package works.emregumus.beywitherboss.Command.subcmd.admin.boss;

import io.lumine.mythic.api.mobs.MythicMob;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.bossbar.BossBarManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Command.AbstractSubCommand;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

import java.util.List;

public class ResetCommand extends AbstractSubCommand {

    public static final ResetCommand INSTANCE = new ResetCommand();

    public ResetCommand() {
        super("reset");
    }

    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        WitherBossManager.getInstance().witherBossSpawned = false;
        WitherBossManager.getInstance().killedmob = 0;
        WitherBossManager.getInstance().witherRequiredMobs.clear();
        WitherBossManager.getInstance().witherRequiredMobs.put(EntityType.valueOf(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Requirement.mob1.Mob-Type")), BeyWitherBoss.getInstance().getBossConfig().getInt("Boss.Requirement.mob1.Amount") - 1);
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mythicmobs mobs kill toro_wither");
        for (Player player : Bukkit.getOnlinePlayers()) {
            BossBarManager bossBarManager = TabAPI.getInstance().getBossBarManager();
            TabPlayer tabPlayer = TabAPI.getInstance().getPlayer(player.getUniqueId());
            bossBarManager.getBossBar("killsayac").addPlayer(tabPlayer);
        }
        return true;
    }

}
