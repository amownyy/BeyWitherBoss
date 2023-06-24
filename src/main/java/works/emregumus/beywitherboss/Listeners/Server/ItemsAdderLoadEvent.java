package works.emregumus.beywitherboss.Listeners.Server;

import dev.lone.itemsadder.api.Events.ItemsAdderLoadDataEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import works.emregumus.beywitherboss.BeyWitherBoss;
import works.emregumus.beywitherboss.Manager.WitherBlockManager;

public class ItemsAdderLoadEvent implements Listener {

    @EventHandler
    public void onItemsAdderFullyLoaded(ItemsAdderLoadDataEvent event) {
        new WitherBlockManager(BeyWitherBoss.getInstance());
    }

}
