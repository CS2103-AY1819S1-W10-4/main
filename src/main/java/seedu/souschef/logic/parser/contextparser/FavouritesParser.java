package seedu.souschef.logic.parser.contextparser;

import static seedu.souschef.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.souschef.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.souschef.logic.commands.Command;
import seedu.souschef.logic.commands.DeleteCommand;
import seedu.souschef.logic.commands.FindCommand;
import seedu.souschef.logic.commands.HelpCommand;
import seedu.souschef.logic.commands.ListCommand;
import seedu.souschef.logic.parser.commandparser.DeleteCommandParser;
import seedu.souschef.logic.parser.commandparser.FindCommandParser;
import seedu.souschef.logic.parser.exceptions.ParseException;
import seedu.souschef.model.Model;
import seedu.souschef.model.recipe.Recipe;


/**
 * Class to parse favourite logic
 */
public class FavouritesParser {
    public static final String COMMAND_WORD = "favourite";
    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");

    /**
     * Parses user input into command for execution.
     *
     * @param model
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command<Recipe> parseCommand(Model model, String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        switch (commandWord) {
        case DeleteCommand.COMMAND_WORD:
            return new DeleteCommandParser().parseIngredient(model, arguments);

        case FindCommand.COMMAND_WORD:
            return new FindCommandParser().parseIngredient(model, arguments);

        case ListCommand.COMMAND_WORD:
            return new ListCommand<Recipe>(model);

        default:
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

    /**
     * To check if the user input is a cross context command.
     */
    public static boolean isCrossContextCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }
        final String commandWord = matcher.group("commandWord");
        return commandWord.equals(COMMAND_WORD);
    }
}