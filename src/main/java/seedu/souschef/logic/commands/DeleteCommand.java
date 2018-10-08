package seedu.souschef.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.souschef.commons.core.Messages;
import seedu.souschef.commons.core.index.Index;
import seedu.souschef.logic.CommandHistory;
import seedu.souschef.logic.commands.exceptions.CommandException;
import seedu.souschef.model.Model;
import seedu.souschef.model.recipe.Recipe;

/**
 * Deletes a recipe identified using it's displayed index from the address book.
 */
public class DeleteCommand<T extends UniqueType> extends Command<T> {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the recipe identified by the index number used in the displayed recipe list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_RECIPE_SUCCESS = "Deleted Recipe: %1$s";

    private final Model model;
    private final Index targetIndex;

    public DeleteCommand(Model model, Index targetIndex) {
        this.model = model;
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(CommandHistory history) throws CommandException {
        requireNonNull(model);
        List<T> lastShownList = model.getFilteredList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
        }

        T ToDelete = lastShownList.get(targetIndex.getZeroBased());
        model.delete(ToDelete);
        model.commitAppContent();
        return new CommandResult(String.format(MESSAGE_DELETE_RECIPE_SUCCESS, ToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteCommand<T>) other).targetIndex)); // state check
    }
}
