package works.emregumus.beywitherboss.Api.Config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import works.emregumus.beywitherboss.Api.Utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

public class FileCreator extends YamlConfiguration {
    private final String fileName;

    private final Plugin plugin;

    private final File file;

    private final Map<String, FileCreator> files = new ConcurrentHashMap<>();

    public FileCreator(Plugin plugin, String filename, String fileExtension, File folder) {
        this.plugin = plugin;
        this.fileName = filename + (filename.endsWith(fileExtension) ? "" : fileExtension);
        this.file = new File(folder, this.fileName);
        createFile();
    }

    public FileCreator(Plugin plugin, String fileName) {
        this(plugin, fileName, ".yml");
    }

    public FileCreator(Plugin plugin, String fileName, String fileExtension) {
        this(plugin, fileName, fileExtension, plugin.getDataFolder());
    }

    private void createFile() {
        try {
            if (!this.fileName.endsWith(".yml") &&
                    !this.file.exists()) {
                if (this.plugin.getResource(this.fileName) != null)
                    this.plugin.saveResource(this.fileName, false);
                return;
            }
            if (!this.file.exists()) {
                if (this.plugin.getResource(this.fileName) != null) {
                    this.plugin.saveResource(this.fileName, false);
                } else {
                    save(this.file);
                }
                load(this.file);
                return;
            }
            load(this.file);
            save(this.file);
        } catch (InvalidConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDefault() {
        this.plugin.saveResource(this.fileName, false);
    }

    public void save() {
        try {
            save(this.file);
        } catch (IOException e) {
            this.plugin.getLogger().log(Level.SEVERE, "Save of the file '" + this.fileName + "' failed.", e);
        }
    }

    public void reload() {
        try {
            load(this.file);
        } catch (IOException|InvalidConfigurationException e) {
            this.plugin.getLogger().log(Level.SEVERE, "Reload of the file '" + this.fileName + "' failed.", e);
        }
    }

    public String getStringWF(String path) {
        return getString(path, "");
    }

    public String getString(String path) {
        return Utils.hex(super.getString(path));
    }

    public List<String> getStringList(String path) {
        List<String> list = super.getStringList(path);
        list.replaceAll(Utils::hex);
        return list;
    }

    public List<String> getStringListWF(String path) {
        return super.getStringList(path);
    }

    public boolean exists() {
        return this.file.exists();
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getName() {
        String name = this.fileName.replace(".yml", "");
        return name.substring(name.lastIndexOf("/") + 1);
    }
}