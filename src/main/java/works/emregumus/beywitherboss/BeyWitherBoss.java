package works.emregumus.beywitherboss;

import me.clip.placeholderapi.PlaceholderAPIPlugin;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import works.emregumus.beywitherboss.Api.Config.FileCreator;
import works.emregumus.beywitherboss.Command.BeyWitherBossCommand;
import works.emregumus.beywitherboss.Hooks.Placeholder.WitherBossPlaceholder;
import works.emregumus.beywitherboss.Listeners.Boss.BossBlockBreakListener;
import works.emregumus.beywitherboss.Listeners.Boss.BossDeathListener;
import works.emregumus.beywitherboss.Listeners.Player.MobDamageTrackerListener;
import works.emregumus.beywitherboss.Listeners.Player.PlayerJoinListener;
import works.emregumus.beywitherboss.Listeners.Server.ItemsAdderLoadEvent;
import works.emregumus.beywitherboss.Manager.WitherBossManager;

public final class BeyWitherBoss extends JavaPlugin{

    public static BeyWitherBoss instance;
    private static BukkitAudiences adventure;
    private WitherBossPlaceholder placeholder;
    private FileCreator messages;
    private FileCreator data;
    private FileCreator bossconfig;
    private FileCreator oreconfig;


    @Override
    public void onEnable() {
        instance = this;
        adventure = BukkitAudiences.create(this);

        messages = new FileCreator(this, "messages.yml");
        data = new FileCreator(this, "data.yml");
        bossconfig = new FileCreator(this, "bossconfig.yml");
        oreconfig = new FileCreator(this, "oreconfig.yml");

        this.placeholder = new WitherBossPlaceholder(this);
        this.placeholder.register();

        new WitherBossManager(this);

        this.registerListeners();
        this.registerCommands();

    }

    @Override
    public void onDisable() {
        this.placeholder.unregister();
        PlaceholderAPIPlugin.getInstance().reloadConfig();
    }

    private void registerListeners() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new BossBlockBreakListener(), this);
        pluginManager.registerEvents(new BossDeathListener(), this);
        pluginManager.registerEvents(new MobDamageTrackerListener(), this);
        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new ItemsAdderLoadEvent(), this);
    }

    private void registerCommands() {
        BeyWitherBossCommand beyWitherBossCommand = new BeyWitherBossCommand();
        PluginCommand pluginCommand = Bukkit.getPluginCommand("beywitherboss");
        if (pluginCommand != null) {
            pluginCommand.setExecutor(beyWitherBossCommand);
            pluginCommand.setTabCompleter(beyWitherBossCommand);
        } else {
            getLogger().warning("BeyWitherBoss command not found!");
        }
    }

    public static BeyWitherBoss getInstance() {
        return instance;
    }

    public static BukkitAudiences getAdventure() {
        return adventure;
    }

    public FileCreator getMessages() {
        return messages;
    }
    public FileCreator getData() {
        return data;
    }
    public FileCreator getBossConfig() {
        return bossconfig;
    }
    public FileCreator getOreConfig() {
        return oreconfig;
    }

}
