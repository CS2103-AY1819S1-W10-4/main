package seedu.souschef.logic.commands;
//TODO: Commented Junit

import static seedu.souschef.logic.commands.CommandTestUtil.assertCommandSuccess;

import org.junit.Test;

import seedu.souschef.logic.CommandHistory;
import seedu.souschef.model.Model;
import seedu.souschef.model.ModelSetCoordinator;
import seedu.souschef.model.recipe.Recipe;

public class ClearCommandTest {

    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void execute_emptyAddressBook_success() {
        Model<Recipe> model = new ModelSetCoordinator().getRecipeModel();
        Model<Recipe> expectedModel = new ModelSetCoordinator().getRecipeModel();
        expectedModel.commitAppContent();

        assertCommandSuccess(new ClearCommand(model), model, commandHistory, ClearCommand.MESSAGE_SUCCESS,
                expectedModel);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        /*Model<Recipe> model = new ModelSetCoordinator(getTypicalAddressBook(), new UserPrefs()).getRecipeModel();
        Model<Recipe> expectedModel = new ModelSetCoordinator(getTypicalAddressBook(),
                new UserPrefs()).getRecipeModel();
        expectedModel.resetData(new AppContent());
        expectedModel.commitAppContent();

        assertCommandSuccess(new ClearCommand(model), model, commandHistory, ClearCommand.MESSAGE_SUCCESS,
        expectedModel);*/
    }

}