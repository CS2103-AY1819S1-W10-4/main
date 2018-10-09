package seedu.souschef.logic.parser;

import static org.junit.Assert.assertEquals;

import seedu.souschef.logic.commands.Command;
import seedu.souschef.logic.parser.exceptions.ParseException;
import seedu.souschef.model.AppContent;
import seedu.souschef.model.Model;
import seedu.souschef.model.ModelManager;
import seedu.souschef.model.ReadOnlyAppContent;
import seedu.souschef.model.UniqueList;
import seedu.souschef.model.VersionedAppContent;
import seedu.souschef.model.ingredient.Ingredient;

/**
 * Contains helper methods for testing command parsers.
 */
public class CommandParserTestUtil {
    /**
     * Asserts that the parsing of {@code userInput} by {@code parser} is successful and the command created
     * equals to {@code expectedCommand}.
     */
    public static void assertParseSuccess(Parser parser, String userInput, Command expectedCommand) {
        ReadOnlyAppContent initialState = new AppContent();
        Model<Ingredient> model = new ModelManager<Ingredient>(new VersionedAppContent(initialState),
                new UniqueList<Ingredient>());
        try {
            Command command = parser.parseIngredient(model, userInput);
            assertEquals(expectedCommand, command);
        } catch (ParseException pe) {
            throw new IllegalArgumentException("Invalid userInput.", pe);
        }
    }

    /**
     * Asserts that the parsing of {@code userInput} by {@code parser} is unsuccessful and the error message
     * equals to {@code expectedMessage}.
     */
    public static void assertParseFailure(Parser parser, String userInput, String expectedMessage) {
        ReadOnlyAppContent initialState = new AppContent();
        Model<Ingredient> model = new ModelManager<Ingredient>(new VersionedAppContent(initialState),
                new UniqueList<Ingredient>());
        try {
            parser.parseIngredient(model, userInput);
            throw new AssertionError("The expected ParseException was not thrown.");
        } catch (ParseException pe) {
            assertEquals(expectedMessage, pe.getMessage());
        }
    }
}
