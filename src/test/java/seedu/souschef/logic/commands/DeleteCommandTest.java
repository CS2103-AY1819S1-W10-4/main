package seedu.souschef.logic.commands;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static seedu.souschef.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.souschef.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.souschef.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.souschef.testutil.TypicalIndexes.INDEX_FIRST_RECIPE;
import static seedu.souschef.testutil.TypicalIndexes.INDEX_SECOND_RECIPE;
import static seedu.souschef.testutil.TypicalRecipes.getTypicalAddressBook;

import org.junit.Test;

import seedu.souschef.commons.core.Messages;
import seedu.souschef.commons.core.index.Index;
import seedu.souschef.logic.CommandHistory;
import seedu.souschef.model.Model;
import seedu.souschef.model.ModelManager;
import seedu.souschef.model.UserPrefs;
import seedu.souschef.model.recipe.Recipe;

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code DeleteCommand}.
 */
public class DeleteCommandTest {

    private Model<Recipe> model = new ModelManager<>(getTypicalAddressBook(), new UserPrefs());
    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Recipe recipeToDelete = model.getFilteredRecipeList().get(INDEX_FIRST_RECIPE.getZeroBased());
        DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST_RECIPE);

        String expectedMessage = String.format(DeleteCommand.MESSAGE_DELETE_RECIPE_SUCCESS, recipeToDelete);

        ModelManager expectedModel = new ModelManager(model.getAppContent(), new UserPrefs());
        expectedModel.delete(recipeToDelete);
        expectedModel.commitAppContent();

        assertCommandSuccess(deleteCommand, model, commandHistory, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredRecipeList().size() + 1);
        DeleteCommand deleteCommand = new DeleteCommand(outOfBoundIndex);

        assertCommandFailure(deleteCommand, model, commandHistory, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showPersonAtIndex(model, INDEX_FIRST_RECIPE);

        Recipe recipeToDelete = model.getFilteredRecipeList().get(INDEX_FIRST_RECIPE.getZeroBased());
        DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST_RECIPE);

        String expectedMessage = String.format(DeleteCommand.MESSAGE_DELETE_RECIPE_SUCCESS, recipeToDelete);

        Model expectedModel = new ModelManager(model.getAppContent(), new UserPrefs());
        expectedModel.delete(recipeToDelete);
        expectedModel.commitAppContent();
        showNoPerson(expectedModel);

        assertCommandSuccess(deleteCommand, model, commandHistory, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showPersonAtIndex(model, INDEX_FIRST_RECIPE);

        Index outOfBoundIndex = INDEX_SECOND_RECIPE;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAppContent().getRecipeList().size());

        DeleteCommand deleteCommand = new DeleteCommand(outOfBoundIndex);

        assertCommandFailure(deleteCommand, model, commandHistory, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
    }

    @Test
    public void executeUndoRedo_validIndexUnfilteredList_success() throws Exception {
        Recipe recipeToDelete = model.getFilteredRecipeList().get(INDEX_FIRST_RECIPE.getZeroBased());
        DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST_RECIPE);
        Model expectedModel = new ModelManager(model.getAppContent(), new UserPrefs());
        expectedModel.delete(recipeToDelete);
        expectedModel.commitAppContent();

        // delete -> first recipe deleted
        deleteCommand.execute(model, commandHistory);

        // undo -> reverts addressbook back to previous state and filtered recipe list to show all persons
        expectedModel.undoAppContent();
        assertCommandSuccess(new UndoCommand(), model, commandHistory, UndoCommand.MESSAGE_SUCCESS, expectedModel);

        // redo -> same first recipe deleted again
        expectedModel.redoAppContent();
        assertCommandSuccess(new RedoCommand(), model, commandHistory, RedoCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void executeUndoRedo_invalidIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredRecipeList().size() + 1);
        DeleteCommand deleteCommand = new DeleteCommand(outOfBoundIndex);

        // execution failed -> address book state not added into model
        assertCommandFailure(deleteCommand, model, commandHistory, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);

        // single address book state in model -> undoCommand and redoCommand fail
        assertCommandFailure(new UndoCommand(), model, commandHistory, UndoCommand.MESSAGE_FAILURE);
        assertCommandFailure(new RedoCommand(), model, commandHistory, RedoCommand.MESSAGE_FAILURE);
    }

    /**
     * 1. Deletes a {@code Recipe} from a filtered list.
     * 2. Undo the deletion.
     * 3. The unfiltered list should be shown now. Verify that the index of the previously deleted recipe in the
     * unfiltered list is different from the index at the filtered list.
     * 4. Redo the deletion. This ensures {@code RedoCommand} deletes the recipe object regardless of indexing.
     */
    @Test
    public void executeUndoRedo_validIndexFilteredList_samePersonDeleted() throws Exception {
        DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST_RECIPE);
        Model expectedModel = new ModelManager(model.getAppContent(), new UserPrefs());

        showPersonAtIndex(model, INDEX_SECOND_RECIPE);
        Recipe recipeToDelete = model.getFilteredRecipeList().get(INDEX_FIRST_RECIPE.getZeroBased());
        expectedModel.delete(recipeToDelete);
        expectedModel.commitAppContent();

        // delete -> deletes second recipe in unfiltered recipe list / first recipe in filtered recipe list
        deleteCommand.execute(model, commandHistory);

        // undo -> reverts addressbook back to previous state and filtered recipe list to show all persons
        expectedModel.undoAppContent();
        assertCommandSuccess(new UndoCommand(), model, commandHistory, UndoCommand.MESSAGE_SUCCESS, expectedModel);

        assertNotEquals(recipeToDelete, model.getFilteredRecipeList().get(INDEX_FIRST_RECIPE.getZeroBased()));
        // redo -> deletes same second recipe in unfiltered recipe list
        expectedModel.redoAppContent();
        assertCommandSuccess(new RedoCommand(), model, commandHistory, RedoCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void equals() {
        DeleteCommand deleteFirstCommand = new DeleteCommand(INDEX_FIRST_RECIPE);
        DeleteCommand deleteSecondCommand = new DeleteCommand(INDEX_SECOND_RECIPE);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        DeleteCommand deleteFirstCommandCopy = new DeleteCommand(INDEX_FIRST_RECIPE);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different recipe -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }

    /**
     * Updates {@code model}'s filtered list to show no one.
     */
    private void showNoPerson(Model model) {
        model.updateFilteredRecipeList(p -> false);

        assertTrue(model.getFilteredRecipeList().isEmpty());
    }
}