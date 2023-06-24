package works.emregumus.beywitherboss.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import works.emregumus.beywitherboss.Api.Utils.AdventureUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractMainCommand implements TabExecutor {

    protected final Map<String, AbstractSubCommand> subCommandMap;

    public AbstractMainCommand() {
        this.subCommandMap = new ConcurrentHashMap<>();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> argList = Arrays.asList(args);
        if (argList.size() < 1) {
            AdventureUtils.sendMessage(sender, "&7/" + label + " <subcommand>");
            return true;
        }
        if (!sender.hasPermission("beywitherboss." + argList.get(0))) {
            AdventureUtils.sendMessage(sender, "&cYou don't have permission to use this command.");
            return true;
        }
        AbstractSubCommand subCommand = subCommandMap.get(argList.get(0));
        if (subCommand != null)
            return subCommand.onCommand(sender, argList.subList(1, argList.size()));
        else {
            AdventureUtils.sendMessage(sender, "&cSubcommand not found.");
            return true;
        }
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> argList = Arrays.asList(args);
        if (argList.size() <= 1) {
            List<String> returnList = new ArrayList<>(subCommandMap.keySet());
            returnList.removeIf(str -> !str.startsWith(args[0]) || !sender.hasPermission("beywitherboss." + str));
            return returnList;
        }
        AbstractSubCommand subCommand = subCommandMap.get(argList.get(0));
        if (subCommand != null)
            return subCommand.onTabComplete(sender, argList.subList(1, argList.size()));
        else
            return Collections.singletonList("");
    }

    public void regSubCommand(AbstractSubCommand executor) {
        subCommandMap.put(executor.getSubCommand(), executor);
    }

    public Map<String, AbstractSubCommand> getSubCommandMap() {
        return subCommandMap;
    }

}
