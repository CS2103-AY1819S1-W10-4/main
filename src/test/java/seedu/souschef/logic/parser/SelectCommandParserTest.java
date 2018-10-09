package seedu.souschef.logic.parser;

import static seedu.souschef.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.souschef.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.souschef.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.souschef.testutil.TypicalIndexes.INDEX_FIRST_RECIPE;

import org.junit.Test;

import seedu.souschef.logic.commands.SelectCommand;
import seedu.souschef.model.AppContent;
import seedu.souschef.model.Model;
import seedu.souschef.model.ModelManager;
import seedu.souschef.model.ReadOnlyAppContent;
import seedu.souschef.model.UniqueList;
import seedu.souschef.model.VersionedAppContent;
import seedu.souschef.model.recipe.Recipe;

/**
 * Test scope: similar to {@code DeleteCommandParserTest}.
 * @see DeleteCommandParserTest
 */
public class SelectCommandParserTest {

    /*private SelectCommandParser parser = new SelectCommandParser();
    private ReadOnlyAppContent initialState = new AppContent();
    private Model<Recipe> model = new ModelManager<Recipe>(new VersionedAppContent(initialState),
            new UniqueList<Recipe>());

    @Test
    public void parse_validArgs_returnsSelectCommand() {
        assertParseSuccess(parser, "1", new SelectCommand(model, INDEX_FIRST_RECIPE));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, SelectCommand.MESSAGE_USAGE));
    }*/
}
