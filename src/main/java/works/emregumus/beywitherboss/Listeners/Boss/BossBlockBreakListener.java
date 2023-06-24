package works.emregumus.beywitherboss.Listeners.Boss;

import dev.lone.itemsadder.api.CustomBlock;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import works.emregumus.beywitherboss.Api.Utils.AdventureUtils;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

import java.util.List;

public class BossBlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getBlock().getType().equals(Material.valueOf(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Options.Ore-List.Emerald"))) ||
            event.getBlock().getType().equals(Material.valueOf(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Options.Ore-List.Diamond"))) ||
            event.getBlock().getType().equals(Material.valueOf(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Options.Ore-List.Gold"))) ||
            event.getBlock().getType().equals(Material.valueOf(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Options.Ore-List.Iron"))) ||
            event.getBlock().getType().equals(Material.valueOf(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Options.Ore-List.Coal"))) ||
            event.getBlock().getBlockData().equals(CustomBlock.getBaseBlockData(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Options.Ore-List.Topaz").toLowerCase())) ||
            event.getBlock().getBlockData().equals(CustomBlock.getBaseBlockData(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Options.Ore-List.Ruby").toLowerCase())) ||
            event.getBlock().getBlockData().equals(CustomBlock.getBaseBlockData(BeyWitherBoss.getInstance().getBossConfig().getString("Boss.Options.Ore-List.BEYRONYUM").toLowerCase()))
        ) {
            if (WitherBossManager.getInstance().witherBossSpawned == false){
                event.setCancelled(true);
            } else {
                AdventureUtils.consoleMessage("Wither boss block kırma serbest");
            }
        }
    }
}
