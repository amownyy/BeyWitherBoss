package works.emregumus.beywitherboss.Command;

import works.emregumus.beywitherboss.Command.subcmd.AdminCommand;
import works.emregumus.beywitherboss.Command.subcmd.ReloadCommand;

public class BeyWitherBossCommand extends AbstractMainCommand{

    public BeyWitherBossCommand() {
        regSubCommand(ReloadCommand.INSTANCE);
        regSubCommand(AdminCommand.INSTANCE);
    }
}
