package works.emregumus.beywitherboss.Command.subcmd.admin.boss.Change;

import works.emregumus.beywitherboss.Command.AbstractSubCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.boss.Change.Requirement.ChangeMobAmountCommand;
import works.emregumus.beywitherboss.Command.subcmd.admin.boss.Change.Requirement.ChangeMobTypeCommand;

public class ChangeRequirementCommand extends AbstractSubCommand {

    public static final ChangeRequirementCommand INSTANCE = new ChangeRequirementCommand();

    public ChangeRequirementCommand() {
        super("requirement");
        regSubCommand(ChangeMobAmountCommand.INSTANCE);
        regSubCommand(ChangeMobTypeCommand.INSTANCE);
    }
}
