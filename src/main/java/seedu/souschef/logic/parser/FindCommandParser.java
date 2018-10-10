package seedu.souschef.logic.parser;

import seedu.souschef.logic.commands.Command;
import seedu.souschef.logic.commands.FindCommand;
import seedu.souschef.logic.parser.exceptions.ParseException;
import seedu.souschef.model.Model;
import seedu.souschef.model.ingredient.Ingredient;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class FindCommandParser implements Parser<FindCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the FindCommand
     * and returns an FindCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command<Ingredient> parseIngredient(Model<Ingredient> model, String args) throws ParseException {
        return null;
    }

}
