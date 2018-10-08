package seedu.souschef.logic.parser;

import static seedu.souschef.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.souschef.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.souschef.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.souschef.testutil.TypicalIndexes.INDEX_FIRST_RECIPE;

import org.junit.Test;

<<<<<<< HEAD:src/test/java/seedu/address/logic/parser/DeleteCommandParserTest.java
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.model.UniqueType;
=======
import seedu.souschef.logic.commands.DeleteCommand;
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/parser/DeleteCommandParserTest.java

/**
 * As we are only doing white-box testing, our test cases do not cover path variations
 * outside of the DeleteCommand code. For example, inputs "1" and "1 abc" take the
 * same path through the DeleteCommand, and therefore we test only one of them.
 * The path variation for those two cases occur inside the ParserUtil, and
 * therefore should be covered by the ParserUtilTest.
 */
public class DeleteCommandParserTest {

    private DeleteCommandParser parser = new DeleteCommandParser();

    @Test
    public void parse_validArgs_returnsDeleteCommand() {
        assertParseSuccess(parser, "1", new DeleteCommand<UniqueType>(, INDEX_FIRST_RECIPE));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE));
    }
}
