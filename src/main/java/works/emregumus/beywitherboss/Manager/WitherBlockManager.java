package works.emregumus.beywitherboss.Manager;

import dev.lone.itemsadder.api.CustomBlock;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import works.emregumus.beywitherboss.Api.Utils.AdventureUtils;
import works.emregumus.beywitherboss.BeyWitherBoss;

public class WitherBlockManager {
    private final BeyWitherBoss plugin;
    private static WitherBlockManager instance;

    public WitherBlockManager(BeyWitherBoss plugin) {
        this.plugin = plugin;
        instance = this;
        loadEmeraldOres();
        loadDiamondOres();
        loadGoldOres();
        loadIronOres();
        loadCoalOres();
        loadTopazOres();
        loadRubyOres();
        loadBeyronyumOres();
    }

    private void loadEmeraldOres() {
        BeyWitherBoss.getInstance().getOreConfig().getConfigurationSection("Ores.Normal.EMERALD").getKeys(false).forEach(ore -> {
            String worldName = BeyWitherBoss.getInstance().getOreConfig().getString("Ores.Normal.EMERALD." + ore + ".World");
            World world = Bukkit.getWorld(worldName);

            if (world != null) {
                int x = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.EMERALD." + ore + ".X");
                int y = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.EMERALD." + ore + ".Y");
                int z = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.EMERALD." + ore + ".Z");

                Block block = world.getBlockAt(x, y, z);
                if (WitherBossManager.getInstance().witherBossSpawned()) {
                    // witherBossSpawned true ise BEDROCK bloğunu EMERALD_ORE olarak dönüştür
                    if (block.getType() == Material.BEDROCK) {
                        block.setType(Material.EMERALD_ORE);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been converted to EMERALD_ORE!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is not BEDROCK!");
                    }
                } else {
                    // witherBossSpawned false ise BEDROCK bloğunu koru
                    if (block.getType() != Material.BEDROCK) {
                        block.setType(Material.BEDROCK);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been kept as BEDROCK!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is already BEDROCK!");
                    }
                }
            } else {
                AdventureUtils.consoleMessage("&c[!] &cWorld '" + worldName + "' does not exist!");
            }
        });
    }
    private void loadDiamondOres() {
        BeyWitherBoss.getInstance().getOreConfig().getConfigurationSection("Ores.Normal.DIAMOND").getKeys(false).forEach(ore -> {
            String worldName = BeyWitherBoss.getInstance().getOreConfig().getString("Ores.Normal.DIAMOND." + ore + ".World");
            World world = Bukkit.getWorld(worldName);

            if (world != null) {
                int x = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.DIAMOND." + ore + ".X");
                int y = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.DIAMOND." + ore + ".Y");
                int z = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.DIAMOND." + ore + ".Z");

                Block block = world.getBlockAt(x, y, z);
                if (WitherBossManager.getInstance().witherBossSpawned()) {
                    // witherBossSpawned true ise BEDROCK bloğunu EMERALD_ORE olarak dönüştür
                    if (block.getType() == Material.BEDROCK) {
                        block.setType(Material.EMERALD_ORE);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been converted to DIAMOND_ORE!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is not BEDROCK!");
                    }
                } else {
                    // witherBossSpawned false ise BEDROCK bloğunu koru
                    if (block.getType() != Material.BEDROCK) {
                        block.setType(Material.BEDROCK);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been kept as BEDROCK!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is already BEDROCK!");
                    }
                }
            } else {
                AdventureUtils.consoleMessage("&c[!] &cWorld '" + worldName + "' does not exist!");
            }
        });
    }
    private void loadGoldOres() {
        BeyWitherBoss.getInstance().getOreConfig().getConfigurationSection("Ores.Normal.GOLD").getKeys(false).forEach(ore -> {
            String worldName = BeyWitherBoss.getInstance().getOreConfig().getString("Ores.Normal.GOLD." + ore + ".World");
            World world = Bukkit.getWorld(worldName);

            if (world != null) {
                int x = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.GOLD." + ore + ".X");
                int y = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.GOLD." + ore + ".Y");
                int z = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.GOLD." + ore + ".Z");

                Block block = world.getBlockAt(x, y, z);
                if (WitherBossManager.getInstance().witherBossSpawned()) {
                    // witherBossSpawned true ise BEDROCK bloğunu GOLD_ORE olarak dönüştür
                    if (block.getType() == Material.BEDROCK) {
                        block.setType(Material.GOLD_ORE);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been converted to GOLD_ORE!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is not BEDROCK!");
                    }
                } else {
                    // witherBossSpawned false ise BEDROCK bloğunu koru
                    if (block.getType() != Material.BEDROCK) {
                        block.setType(Material.BEDROCK);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been kept as BEDROCK!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is already BEDROCK!");
                    }
                }
            } else {
                AdventureUtils.consoleMessage("&c[!] &cWorld '" + worldName + "' does not exist!");
            }
        });
    }
    private void loadIronOres() {
        BeyWitherBoss.getInstance().getOreConfig().getConfigurationSection("Ores.Normal.IRON").getKeys(false).forEach(ore -> {
            String worldName = BeyWitherBoss.getInstance().getOreConfig().getString("Ores.Normal.IRON." + ore + ".World");
            World world = Bukkit.getWorld(worldName);

            if (world != null) {
                int x = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.IRON." + ore + ".X");
                int y = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.IRON." + ore + ".Y");
                int z = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.IRON." + ore + ".Z");

                Block block = world.getBlockAt(x, y, z);
                if (WitherBossManager.getInstance().witherBossSpawned()) {
                    // witherBossSpawned true ise BEDROCK bloğunu IRON_ORE olarak dönüştür
                    if (block.getType() == Material.BEDROCK) {
                        block.setType(Material.IRON_ORE);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been converted to IRON_ORE!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is not BEDROCK!");
                    }
                } else {
                    // witherBossSpawned false ise BEDROCK bloğunu koru
                    if (block.getType() != Material.BEDROCK) {
                        block.setType(Material.BEDROCK);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been kept as BEDROCK!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is already BEDROCK!");
                    }
                }
            } else {
                AdventureUtils.consoleMessage("&c[!] &cWorld '" + worldName + "' does not exist!");
            }
        });
    }
    private void loadCoalOres() {
        BeyWitherBoss.getInstance().getOreConfig().getConfigurationSection("Ores.Normal.COAL").getKeys(false).forEach(ore -> {
            String worldName = BeyWitherBoss.getInstance().getOreConfig().getString("Ores.Normal.COAL." + ore + ".World");
            World world = Bukkit.getWorld(worldName);

            if (world != null) {
                int x = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.COAL." + ore + ".X");
                int y = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.COAL." + ore + ".Y");
                int z = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.Normal.COAL." + ore + ".Z");

                Block block = world.getBlockAt(x, y, z);
                if (WitherBossManager.getInstance().witherBossSpawned()) {
                    // witherBossSpawned true ise BEDROCK bloğunu COAL_ORE olarak dönüştür
                    if (block.getType() == Material.BEDROCK) {
                        block.setType(Material.COAL_ORE);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been converted to COAL_ORE!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is not BEDROCK!");
                    }
                } else {
                    // witherBossSpawned false ise BEDROCK bloğunu koru
                    if (block.getType() != Material.BEDROCK) {
                        block.setType(Material.BEDROCK);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been kept as BEDROCK!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is already BEDROCK!");
                    }
                }
            } else {
                AdventureUtils.consoleMessage("&c[!] &cWorld '" + worldName + "' does not exist!");
            }
        });
    }
    private void loadTopazOres() {
        BeyWitherBoss.getInstance().getOreConfig().getConfigurationSection("Ores.ItemsAdder.TOPAZ").getKeys(false).forEach(ore -> {
            String worldName = BeyWitherBoss.getInstance().getOreConfig().getString("Ores.ItemsAdder.TOPAZ." + ore + ".World");
            World world = Bukkit.getWorld(worldName);

            if (world != null) {
                int x = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.ItemsAdder.TOPAZ." + ore + ".X");
                int y = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.ItemsAdder.TOPAZ." + ore + ".Y");
                int z = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.ItemsAdder.TOPAZ." + ore + ".Z");

                Block block = world.getBlockAt(x, y, z);
                CustomBlock customBlock = CustomBlock.place("tools:topaz_ore", block.getLocation());
                if (WitherBossManager.getInstance().witherBossSpawned()) {
                    // witherBossSpawned true ise BEDROCK bloğunu TOPAZ_ORE olarak dönüştür
                    if (block.getType() == Material.BEDROCK) {
                        customBlock.place(block.getLocation());
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been converted to TOPAZ_ORE!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is not BEDROCK!");
                    }
                } else {
                    // witherBossSpawned false ise BEDROCK bloğunu koru
                    if (block.getType() != Material.BEDROCK || customBlock.isBlock()) {
                        customBlock.getBlock().setType(Material.BEDROCK);
                        block.setType(Material.BEDROCK);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been kept as BEDROCK!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is already BEDROCK!");
                    }
                }
            } else {
                AdventureUtils.consoleMessage("&c[!] &cWorld '" + worldName + "' does not exist!");
            }
        });
    }
    private void loadRubyOres() {
        BeyWitherBoss.getInstance().getOreConfig().getConfigurationSection("Ores.ItemsAdder.RUBY").getKeys(false).forEach(ore -> {
            String worldName = BeyWitherBoss.getInstance().getOreConfig().getString("Ores.ItemsAdder.RUBY." + ore + ".World");
            World world = Bukkit.getWorld(worldName);

            if (world != null) {
                int x = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.ItemsAdder.RUBY." + ore + ".X");
                int y = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.ItemsAdder.RUBY." + ore + ".Y");
                int z = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.ItemsAdder.RUBY." + ore + ".Z");

                Block block = world.getBlockAt(x, y, z);
                CustomBlock customBlock = CustomBlock.place("tools:ruby_ore", block.getLocation());
                if (WitherBossManager.getInstance().witherBossSpawned()) {
                    // witherBossSpawned true ise BEDROCK bloğunu RUBY_ORE olarak dönüştür
                    if (block.getType() == Material.BEDROCK) {
                        customBlock.place(block.getLocation());
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been converted to RUBY_ORE!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is not BEDROCK!");
                    }
                } else {
                    // witherBossSpawned false ise BEDROCK bloğunu koru
                    if (block.getType() != Material.BEDROCK || customBlock.isBlock()) {
                        customBlock.getBlock().setType(Material.BEDROCK);
                        block.setType(Material.BEDROCK);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been kept as BEDROCK!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is already BEDROCK!");
                    }
                }
            } else {
                AdventureUtils.consoleMessage("&c[!] &cWorld '" + worldName + "' does not exist!");
            }
        });
    }
    private void loadBeyronyumOres() {
        BeyWitherBoss.getInstance().getOreConfig().getConfigurationSection("Ores.ItemsAdder.BEYRONYUM").getKeys(false).forEach(ore -> {
            String worldName = BeyWitherBoss.getInstance().getOreConfig().getString("Ores.ItemsAdder.BEYRONYUM." + ore + ".World");
            World world = Bukkit.getWorld(worldName);

            if (world != null) {
                int x = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.ItemsAdder.BEYRONYUM." + ore + ".X");
                int y = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.ItemsAdder.BEYRONYUM." + ore + ".Y");
                int z = BeyWitherBoss.getInstance().getOreConfig().getInt("Ores.ItemsAdder.BEYRONYUM." + ore + ".Z");

                Block block = world.getBlockAt(x, y, z);
                CustomBlock customBlock = CustomBlock.place("tools:beyronium_ore", block.getLocation());
                if (WitherBossManager.getInstance().witherBossSpawned()) {
                    // witherBossSpawned true ise BEDROCK bloğunu BEYRONYUM_ORE olarak dönüştür
                    if (block.getType() == Material.BEDROCK) {
                        customBlock.place(block.getLocation());
                        //block.setBlockData(CustomBlock.getBaseBlockData("tools:beyronium_ore"));
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been converted to BEYRONYUM_ORE!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is not BEDROCK!");
                    }
                } else {
                    // witherBossSpawned false ise BEDROCK bloğunu koru
                    if (block.getType() != Material.BEDROCK || customBlock.isBlock() || block.getType() == Material.NOTE_BLOCK) {
                        customBlock.getBlock().setType(Material.BEDROCK);
                        block.setType(Material.BEDROCK);
                        AdventureUtils.consoleMessage("&a[!] &7(" + x + "&a, &7" + y + "&a, &7" + z + "&a)" + " block has been kept as BEDROCK!");
                    } else {
                        AdventureUtils.consoleMessage("&c[!] &7(" + x + "&c, &7" + y + "&c, &7" + z + "&c)" + " block is already BEDROCK!");
                    }
                }
            } else {
                AdventureUtils.consoleMessage("&c[!] &cWorld '" + worldName + "' does not exist!");
            }
        });
    }

    public static WitherBlockManager getInstance() {
        return instance;
    }

}
