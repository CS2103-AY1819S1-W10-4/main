package seedu.souschef.logic.parser;

import static seedu.souschef.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.souschef.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.souschef.logic.parser.CommandParserTestUtil.assertParseSuccess;

import java.util.Arrays;

import org.junit.Test;

import seedu.souschef.logic.commands.FindCommand;
import seedu.souschef.model.AppContent;
import seedu.souschef.model.Model;
import seedu.souschef.model.ModelManager;
import seedu.souschef.model.ReadOnlyAppContent;
import seedu.souschef.model.UniqueList;
import seedu.souschef.model.VersionedAppContent;
import seedu.souschef.model.recipe.NameContainsKeywordsPredicate;
import seedu.souschef.model.recipe.Recipe;

public class FindCommandParserTest {

    /*private FindCommandParser parser = new FindCommandParser();
    private ReadOnlyAppContent initialState = new AppContent();
    private Model<Recipe> model = new ModelManager<Recipe>(new VersionedAppContent(initialState),
            new UniqueList<Recipe>());

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // no leading and trailing whitespaces
        FindCommand expectedFindCommand =
                new FindCommand(model, new NameContainsKeywordsPredicate(Arrays.asList("Alice", "Bob")));
        assertParseSuccess(parser, "Alice Bob", expectedFindCommand);

        // multiple whitespaces between keywords
        assertParseSuccess(parser, " \n Alice \n \t Bob  \t", expectedFindCommand);
    }*/

}
