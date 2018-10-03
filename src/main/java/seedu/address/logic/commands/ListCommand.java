package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_RECIPES;

import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.UniqueType;

/**
 * Lists all recipes in the address book to the user.
 */
public class ListCommand<T extends UniqueType> extends Command<T> {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all recipes";

    private final Model model;

    public ListCommand(Model model) {
        this.model = model;
    }

    @Override
    public CommandResult execute(CommandHistory history) {
        requireNonNull(model);
        model.updateFilteredRecipeList(PREDICATE_SHOW_ALL_RECIPES);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
