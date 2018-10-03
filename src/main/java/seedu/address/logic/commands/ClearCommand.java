package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.CommandHistory;
import seedu.address.model.AppContent;
import seedu.address.model.Model;
import seedu.address.model.UniqueType;

/**
 * Clears the address book.
 */
public class ClearCommand<T extends UniqueType> extends Command<T> {

    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Address book has been cleared!";

    private final Model model;

    public ClearCommand(Model model) {
        this.model = model;
    }


    @Override
    public CommandResult execute(CommandHistory history) {
        requireNonNull(model);
        model.resetData(new AppContent());
        model.commitAppContent();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
