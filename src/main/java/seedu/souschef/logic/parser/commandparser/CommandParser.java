package seedu.souschef.logic.parser.commandparser;

import seedu.souschef.logic.commands.Command;
import seedu.souschef.logic.parser.exceptions.ParseException;
import seedu.souschef.model.Model;

/**
 * Represents a Parser that is able to parse user input into a {@code Command} of type {@code T}.
 */
public interface CommandParser<T extends Command> {

    /**
     * Parses {@code userInput} into a command and returns it.
     * @throws ParseException if {@code userInput} does not conform the expected format
     */
    T parseRecipe(Model model, String args) throws ParseException;

    T parseIngredient(Model model, String args) throws ParseException;

    T parseHealthPlan(Model model, String args) throws ParseException;
}
