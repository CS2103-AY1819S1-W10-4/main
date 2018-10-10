package seedu.souschef.logic.commands;
//TODO : commented JUnit

import org.junit.Before;
import org.junit.Test;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    /*private Model<Recipe> model;
    private CommandHistory commandHistory = new CommandHistory();*/

    @Before
    public void setUp() {
        /*model = new ModelSetCoordinator(getTypicalAddressBook(), new UserPrefs()).getRecipeModel();*/
    }

    @Test
    public void execute_newPerson_success() {
        /*Recipe validRecipe = new RecipeBuilder().build();

        Model<Recipe> expectedModel = new ModelSetCoordinator(model.getAppContent(), new UserPrefs()).getRecipeModel();
        expectedModel.add(validRecipe);
        expectedModel.commitAppContent();

        assertCommandSuccess(new AddCommand(model, validRecipe), model, commandHistory,
                String.format(AddCommand.MESSAGE_SUCCESS, validRecipe), expectedModel);*/
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        /*Recipe recipeInList = model.getAppContent().getObservableRecipeList().get(0);
        assertCommandFailure(new AddCommand(model, recipeInList), model, commandHistory,
                AddCommand.MESSAGE_DUPLICATE_RECIPE);*/
    }

}
