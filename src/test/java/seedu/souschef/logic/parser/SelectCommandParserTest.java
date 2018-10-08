package seedu.souschef.logic.parser;

import static seedu.souschef.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.souschef.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.souschef.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.souschef.testutil.TypicalIndexes.INDEX_FIRST_RECIPE;

import org.junit.Test;

<<<<<<< HEAD:src/test/java/seedu/address/logic/parser/SelectCommandParserTest.java
import seedu.address.logic.commands.SelectCommand;
import seedu.address.model.UniqueType;
=======
import seedu.souschef.logic.commands.SelectCommand;
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/parser/SelectCommandParserTest.java

/**
 * Test scope: similar to {@code DeleteCommandParserTest}.
 * @see DeleteCommandParserTest
 */
public class SelectCommandParserTest {

    private SelectCommandParser parser = new SelectCommandParser();

    @Test
    public void parse_validArgs_returnsSelectCommand() {
        assertParseSuccess(parser, "1", new SelectCommand<UniqueType>(, INDEX_FIRST_RECIPE));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT, SelectCommand.MESSAGE_USAGE));
    }
}
