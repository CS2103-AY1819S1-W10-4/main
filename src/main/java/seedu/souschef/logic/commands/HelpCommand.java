package seedu.souschef.logic.commands;

import seedu.souschef.commons.core.EventsCenter;
import seedu.souschef.commons.events.ui.ShowHelpRequestEvent;
import seedu.souschef.logic.CommandHistory;
import seedu.souschef.model.Model;
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/main/java/seedu/souschef/logic/commands/HelpCommand.java

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command<UniqueType> {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    @Override
    public CommandResult execute(CommandHistory history) {
        EventsCenter.getInstance().post(new ShowHelpRequestEvent());
        return new CommandResult(SHOWING_HELP_MESSAGE);
    }
}
