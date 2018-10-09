package seedu.souschef.logic;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.souschef.commons.core.ComponentManager;
import seedu.souschef.commons.core.LogsCenter;
import seedu.souschef.logic.commands.Command;
import seedu.souschef.logic.commands.CommandResult;
import seedu.souschef.logic.commands.exceptions.CommandException;
import seedu.souschef.logic.parser.AppContentParser;
import seedu.souschef.logic.parser.exceptions.ParseException;
import seedu.souschef.model.Model;
import seedu.souschef.model.UniqueType;
import seedu.souschef.model.ingredient.Ingredient;
import seedu.souschef.model.recipe.Recipe;

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
        return models[0].getFilteredList();
    }

    public ObservableList<Ingredient> getFilteredIngredientList() {
        return models[1].getFilteredList();
    }

    @Override
    public ListElementPointer getHistorySnapshot() {
        return new ListElementPointer(history.getHistory());
    }
}
