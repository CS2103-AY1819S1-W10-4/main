package seedu.address.logic.commands;

import seedu.address.logic.CommandHistory;
import seedu.address.model.UniqueType;

/**
 * Randomly displays a recipe for the user.
 */

public class SurpriseCommand extends Command<UniqueType> {

    public static final String COMMAND_WORD = "surprise";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": SousChef will surprise you with a random recipe.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_SURPRISE_MESSAGE = "SURPRISE!";

    @Override
    public CommandResult execute(CommandHistory history) {
        return new CommandResult(SHOWING_SURPRISE_MESSAGE);
    }
}
