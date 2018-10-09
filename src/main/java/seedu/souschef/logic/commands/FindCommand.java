package seedu.souschef.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.souschef.commons.core.Messages;
import seedu.souschef.logic.CommandHistory;
import seedu.souschef.model.Model;
import seedu.souschef.model.UniqueType;
import seedu.souschef.model.recipe.NameContainsKeywordsPredicate;

/**
 * Finds and lists all recipes in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindCommand<T extends UniqueType> extends Command {

    public static final String COMMAND_WORD = "find";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all recipes whose names contain any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " alice bob charlie";

    private final Model model;
    private final NameContainsKeywordsPredicate predicate;

    public FindCommand(Model model, NameContainsKeywordsPredicate predicate) {
        this.model = model;
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(CommandHistory history) {
        requireNonNull(model);
        model.updateFilteredList(predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_RECIPES_LISTED_OVERVIEW, model.getFilteredList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindCommand // instanceof handles nulls
                && predicate.equals(((FindCommand<UniqueType>) other).predicate)); // state check
    }
}
