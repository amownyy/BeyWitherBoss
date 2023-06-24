package works.emregumus.beywitherboss.Command.subcmd.admin.boss;

import works.emregumus.beywitherboss.Command.AbstractSubCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.boss.Set.SetKilledMobAmountCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.boss.Set.SetSpawnLocationCommand;

public class SetCommand extends AbstractSubCommand {
    public static final SetCommand INSTANCE = new SetCommand();

    public SetCommand() {
        super("set");
        regSubCommand(SetSpawnLocationCommand.INSTANCE);
        regSubCommand(SetKilledMobAmountCommand.INSTANCE);
    }

}
