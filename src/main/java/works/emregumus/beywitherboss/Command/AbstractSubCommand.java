package works.emregumus.beywitherboss.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import works.emregumus.beywitherboss.Api.Utils.AdventureUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class AbstractSubCommand {
    private final String command;
    private Map<String, AbstractSubCommand> subCommandMap;

    public AbstractSubCommand(String command) {
        this.command = command;
    }

    public boolean onCommand(CommandSender sender, List<String> args) {
        if (subCommandMap == null || args.size() < 1) {
            return true;
        }
        AbstractSubCommand subCommand = subCommandMap.get(args.get(0));
        if (subCommand == null) {
            AdventureUtils.sendMessage(sender, "&cUnknown subcommand!");
        } else {
            subCommand.onCommand(sender, args.subList(1, args.size()));
        }
        return true;
    }

    public List<String> onTabComplete(CommandSender sender, List<String> args) {
        if (subCommandMap == null)
            return Collections.singletonList("");
        if (args.size() <= 1) {
            List<String> returnList = new ArrayList<>(subCommandMap.keySet());
            returnList.removeIf(str -> !str.startsWith(args.get(0)));
            return returnList;
        }
        AbstractSubCommand subCmd = subCommandMap.get(args.get(0));
        if (subCmd != null)
            return subCommandMap.get(args.get(0)).onTabComplete(sender, args.subList(1, args.size()));
        return Collections.singletonList("");
    }

    public String getSubCommand() {
        return command;
    }

    public Map<String, AbstractSubCommand> getSubCommands() {
        return Collections.unmodifiableMap(subCommandMap);
    }

    public void regSubCommand(AbstractSubCommand command) {
        if (subCommandMap == null) {
            subCommandMap = new ConcurrentHashMap<>();
        }
        subCommandMap.put(command.getSubCommand(), command);
    }

    protected boolean noConsoleExecute(CommandSender commandSender) {
        if (!(commandSender instanceof Player)) {
            AdventureUtils.consoleMessage("&cYou can't execute this command from console!");
            return true;
        }
        return false;
    }

    protected boolean playerNotOnline(CommandSender commandSender, String player) {
        if (Bukkit.getPlayer(player) == null) {
            AdventureUtils.sendMessage(commandSender, "&cPlayer is not online");
            return true;
        }
        return false;
    }

    protected boolean lackArgs(CommandSender commandSender, int required, int current) {
        if (required > current) {
            AdventureUtils.sendMessage(commandSender, "&cYou need to provide more arguments!");
            return true;
        }
        return false;
    }

    protected List<String> online_players() {
        List<String> online = new ArrayList<>();
        Bukkit.getOnlinePlayers().forEach((player -> online.add(player.getName())));
        return online;
    }

    protected List<String> filterStartingWith(List<String> list, String prefix) {
        return list.stream().filter(s -> s.startsWith(prefix)).collect(Collectors.toList());
    }
}
