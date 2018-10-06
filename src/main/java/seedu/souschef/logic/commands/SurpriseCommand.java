package seedu.souschef.logic.commands;

import seedu.souschef.logic.CommandHistory;
import seedu.souschef.model.Model;

/**
 * Randomly displays a recipe for the user.
 */

public class SurpriseCommand extends Command {

    public static final String COMMAND_WORD = "surprise";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": SousChef will surprise you with a random recipe.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_SURPRISE_MESSAGE = "SURPRISE!";

    @Override
    public CommandResult execute(Model model, CommandHistory history) {
        return new CommandResult(SHOWING_SURPRISE_MESSAGE);
    }
}
