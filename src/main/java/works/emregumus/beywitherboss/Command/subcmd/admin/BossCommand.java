package works.emregumus.beywitherboss.Command.subcmd.admin;

import works.emregumus.beywitherboss.Command.AbstractSubCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.boss.ChangeCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.boss.ResetCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.boss.SetCommand;

public class BossCommand extends AbstractSubCommand {

    public static final BossCommand INSTANCE = new BossCommand();

    public BossCommand() {
        super("boss");
        regSubCommand(ChangeCommand.INSTANCE);
        regSubCommand(SetCommand.INSTANCE);
        regSubCommand(ResetCommand.INSTANCE);
    }
}
