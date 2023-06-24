package works.emregumus.beywitherboss.Command.subcmd;

import works.emregumus.beywitherboss.Command.AbstractSubCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.BossCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.DebugCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.TestCommand;

public class AdminCommand extends AbstractSubCommand {

    public static final AdminCommand INSTANCE = new AdminCommand();

    public AdminCommand() {
        super("admin");
        regSubCommand(BossCommand.INSTANCE);
        regSubCommand(DebugCommand.INSTANCE);
        regSubCommand(TestCommand.INSTANCE);
    }

}
