package seedu.address.logic;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.ComponentManager;
import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.AppContentParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.UniqueType;
import seedu.address.model.recipe.Recipe;

/**
 * The main LogicManager of the app.
 */
public class LogicManager extends ComponentManager implements Logic {
    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model[] models;
    private final CommandHistory history;
    private final AppContentParser appContentParser;

    public LogicManager(Model[] models) {
        this.models = models;
        history = new CommandHistory();
        appContentParser = new AppContentParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");
        try {
            Command<UniqueType> command = appContentParser.parseCommand(models, commandText, history);
            return command.execute(history);
        } finally {
            history.add(commandText);
        }
    }

    @Override
    public ObservableList<Recipe> getFilteredRecipeList() {
        return models[0].getFilteredRecipeList();
    } //

    @Override
    public ListElementPointer getHistorySnapshot() {
        return new ListElementPointer(history.getHistory());
    }
}
