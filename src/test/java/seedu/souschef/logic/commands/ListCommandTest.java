package seedu.souschef.logic.commands;

import org.junit.Before;
import org.junit.Test;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {

    /* private Model<Recipe> model;
    private Model<Recipe> expectedModel;
    private CommandHistory commandHistory = new CommandHistory();*/

    @Before
    public void setUp() {
       /* model = new ModelSetCoordinator(getTypicalAddressBook(), new UserPrefs()).getRecipeModel();
        expectedModel = new ModelSetCoordinator(model.getAppContent(), new UserPrefs()).getRecipeModel();*/
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        /*assertCommandSuccess(new ListCommand(model), model, commandHistory, ListCommand.MESSAGE_SUCCESS,
                expectedModel);*/
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        /*showPersonAtIndex(model, INDEX_FIRST_RECIPE);
        assertCommandSuccess(new ListCommand(model), model, commandHistory, ListCommand.MESSAGE_SUCCESS, expectedModel);
        */
    }
}
