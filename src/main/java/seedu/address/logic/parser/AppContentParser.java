package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Pattern;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.Command;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.UniqueType;

/**
 * Parses user input.
 */
public class AppContentParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param models
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command<UniqueType> parseCommand(Model[] models, String userInput, CommandHistory history) throws ParseException {
        String context = history.getContext();
        if (userInput.charAt(0) == '-') {
            return null;
        }
        else if (context == null || context.equals("recipe")) {
            // place holder
            return null;
        }
        else if (context.equals("ingredient")) {
            return new IngredientParser().parseCommand(models[1], userInput);
        }
        else {
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
