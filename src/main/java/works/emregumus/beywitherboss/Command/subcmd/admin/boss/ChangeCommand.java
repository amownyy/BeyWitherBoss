package works.emregumus.beywitherboss.Command.subcmd.admin.boss;

import works.emregumus.beywitherboss.Command.AbstractSubCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.boss.Change.ChangeNameCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.boss.Change.ChangeRequirementCommand;

public class ChangeCommand extends AbstractSubCommand {
    public static final ChangeCommand INSTANCE = new ChangeCommand();

    public ChangeCommand() {
        super("change");
        regSubCommand(ChangeNameCommand.INSTANCE);
        regSubCommand(ChangeRequirementCommand.INSTANCE);
    }

}
