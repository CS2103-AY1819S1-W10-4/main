package seedu.souschef.logic.parser;

import static seedu.souschef.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.souschef.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.souschef.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.souschef.testutil.TypicalIndexes.INDEX_FIRST_RECIPE;

import org.junit.Test;

import seedu.souschef.logic.commands.DeleteCommand;
import seedu.souschef.model.AppContent;
import seedu.souschef.model.Model;
import seedu.souschef.model.ModelManager;
import seedu.souschef.model.ReadOnlyAppContent;
import seedu.souschef.model.UniqueList;
import seedu.souschef.model.VersionedAppContent;
import seedu.souschef.model.recipe.Recipe;

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class DeleteCommandParserTest {

    /*private DeleteCommandParser parser = new DeleteCommandParser();
    private ReadOnlyAppContent initialState = new AppContent();
    private Model<Recipe> model = new ModelManager<Recipe>(new VersionedAppContent(initialState),
            new UniqueList<Recipe>());
    private Recipe target = null;

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, "1", new DeleteCommand(model, target));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
    }*/
}
