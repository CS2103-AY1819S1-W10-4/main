package seedu.souschef.logic.parser;

import seedu.souschef.logic.commands.Command;
import seedu.souschef.logic.parser.exceptions.ParseException;
import seedu.souschef.model.Model;
import seedu.souschef.model.ingredient.Ingredient;

/**
 * Represents a Parser that is able to parse user input into a {@code Command} of type {@code T}.
 */
public interface Parser<T extends Command> {

    /**
     * Parses {@code userInput} into a command and returns it.
     *
     * @throws ParseException if {@code userInput} does not conform the expected format
     */
    Command<Ingredient> parseIngredient(Model<Ingredient> model, String userInput) throws ParseException;
}
