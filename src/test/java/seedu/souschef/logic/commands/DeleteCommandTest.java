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

<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/DeleteCommandTest.java
import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UniqueType;
import seedu.address.model.UserPrefs;
import seedu.address.model.recipe.Recipe;
=======
import seedu.souschef.commons.core.Messages;
import seedu.souschef.commons.core.index.Index;
import seedu.souschef.logic.CommandHistory;
import seedu.souschef.model.Model;
import seedu.souschef.model.ModelSetCoordinator;
import seedu.souschef.model.UserPrefs;
import seedu.souschef.model.recipe.Recipe;
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/commands/DeleteCommandTest.java

/**
 * Contains integration tests (interaction with the Model, UndoCommand and RedoCommand) and unit tests for
 * {@code DeleteCommand}.
 */
public class DeleteCommandTest {

    private Model<Recipe> model = new ModelSetCoordinator(getTypicalAddressBook(), new UserPrefs()).getRecipeModel();
    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void execute_validIndexUnfilteredList_success() {
<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/DeleteCommandTest.java
        Recipe recipeToDelete = model.getFilteredRecipeList().get(INDEX_FIRST_RECIPE.getZeroBased());
        DeleteCommand<UniqueType> deleteCommand = new DeleteCommand<UniqueType>(, INDEX_FIRST_RECIPE);
=======
        Recipe recipeToDelete = model.getFilteredList().get(INDEX_FIRST_RECIPE.getZeroBased());
        DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST_RECIPE);
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/commands/DeleteCommandTest.java

        String expectedMessage = String.format(DeleteCommand.MESSAGE_DELETE_RECIPE_SUCCESS, recipeToDelete);

        Model<Recipe> expectedModel = new ModelSetCoordinator(model.getAppContent(), new UserPrefs()).getRecipeModel();
        expectedModel.delete(recipeToDelete);
        expectedModel.commitAppContent();

        assertCommandSuccess(deleteCommand, model, commandHistory, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/DeleteCommandTest.java
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredRecipeList().size() + 1);
        DeleteCommand<UniqueType> deleteCommand = new DeleteCommand<UniqueType>(, outOfBoundIndex);
=======
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredList().size() + 1);
        DeleteCommand deleteCommand = new DeleteCommand(outOfBoundIndex);
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/commands/DeleteCommandTest.java

        assertCommandFailure(deleteCommand, model, commandHistory, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showPersonAtIndex(model, INDEX_FIRST_RECIPE);

<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/DeleteCommandTest.java
        Recipe recipeToDelete = model.getFilteredRecipeList().get(INDEX_FIRST_RECIPE.getZeroBased());
        DeleteCommand<UniqueType> deleteCommand = new DeleteCommand<UniqueType>(, INDEX_FIRST_RECIPE);
=======
        Recipe recipeToDelete = model.getFilteredList().get(INDEX_FIRST_RECIPE.getZeroBased());
        DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST_RECIPE);
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/commands/DeleteCommandTest.java

        String expectedMessage = String.format(DeleteCommand.MESSAGE_DELETE_RECIPE_SUCCESS, recipeToDelete);

        Model<Recipe> expectedModel = new ModelSetCoordinator(model.getAppContent(), new UserPrefs()).getRecipeModel();
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
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAppContent().getObservableRecipeList().size());

        DeleteCommand<UniqueType> deleteCommand = new DeleteCommand<UniqueType>(, outOfBoundIndex);

        assertCommandFailure(deleteCommand, model, commandHistory, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
    }

    @Test
    public void executeUndoRedo_validIndexUnfilteredList_success() throws Exception {
<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/DeleteCommandTest.java
        Recipe recipeToDelete = model.getFilteredRecipeList().get(INDEX_FIRST_RECIPE.getZeroBased());
        DeleteCommand<UniqueType> deleteCommand = new DeleteCommand<UniqueType>(, INDEX_FIRST_RECIPE);
        Model expectedModel = new ModelManager(model.getAppContent(), new UserPrefs());
        expectedModel.deleteRecipe(recipeToDelete);
=======
        Recipe recipeToDelete = model.getFilteredList().get(INDEX_FIRST_RECIPE.getZeroBased());
        DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST_RECIPE);
        Model<Recipe> expectedModel = new ModelSetCoordinator(model.getAppContent(), new UserPrefs()).getRecipeModel();
        expectedModel.delete(recipeToDelete);
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/commands/DeleteCommandTest.java
        expectedModel.commitAppContent();

        // delete -> first recipe deleted
        deleteCommand.execute(commandHistory);

        // undo -> reverts addressbook back to previous state and filtered recipe list to show all persons
        expectedModel.undoAppContent();
        assertCommandSuccess(new UndoCommand(), model, commandHistory, UndoCommand.MESSAGE_SUCCESS, expectedModel);

        // redo -> same first recipe deleted again
        expectedModel.redoAppContent();
        assertCommandSuccess(new RedoCommand(), model, commandHistory, RedoCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void executeUndoRedo_invalidIndexUnfilteredList_failure() {
<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/DeleteCommandTest.java
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredRecipeList().size() + 1);
        DeleteCommand<UniqueType> deleteCommand = new DeleteCommand<UniqueType>(, outOfBoundIndex);
=======
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredList().size() + 1);
        DeleteCommand deleteCommand = new DeleteCommand(outOfBoundIndex);
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/commands/DeleteCommandTest.java

        // execution failed -> address book state not added into recipeModel
        assertCommandFailure(deleteCommand, model, commandHistory, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);

        // single address book state in recipeModel -> undoCommand and redoCommand fail
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
<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/DeleteCommandTest.java
        DeleteCommand<UniqueType> deleteCommand = new DeleteCommand<UniqueType>(, INDEX_FIRST_RECIPE);
        Model expectedModel = new ModelManager(model.getAppContent(), new UserPrefs());
=======
        DeleteCommand deleteCommand = new DeleteCommand(INDEX_FIRST_RECIPE);
        Model<Recipe> expectedModel = new ModelSetCoordinator(model.getAppContent(), new UserPrefs()).getRecipeModel();
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/commands/DeleteCommandTest.java

        showPersonAtIndex(model, INDEX_SECOND_RECIPE);
        Recipe recipeToDelete = model.getFilteredList().get(INDEX_FIRST_RECIPE.getZeroBased());
        expectedModel.delete(recipeToDelete);
        expectedModel.commitAppContent();

        // delete -> deletes second recipe in unfiltered recipe list / first recipe in filtered recipe list
        deleteCommand.execute(commandHistory);

        // undo -> reverts addressbook back to previous state and filtered recipe list to show all persons
        expectedModel.undoAppContent();
        assertCommandSuccess(new UndoCommand(), model, commandHistory, UndoCommand.MESSAGE_SUCCESS, expectedModel);

        assertNotEquals(recipeToDelete, model.getFilteredList().get(INDEX_FIRST_RECIPE.getZeroBased()));
        // redo -> deletes same second recipe in unfiltered recipe list
        expectedModel.redoAppContent();
        assertCommandSuccess(new RedoCommand(), model, commandHistory, RedoCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void equals() {
        DeleteCommand<UniqueType> deleteFirstCommand = new DeleteCommand<UniqueType>(, INDEX_FIRST_RECIPE);
        DeleteCommand<UniqueType> deleteSecondCommand = new DeleteCommand<UniqueType>(, INDEX_SECOND_RECIPE);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        DeleteCommand<UniqueType> deleteFirstCommandCopy = new DeleteCommand<UniqueType>(, INDEX_FIRST_RECIPE);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different recipe -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }

    /**
     * Updates {@code recipeModel}'s filtered list to show no one.
     */
    private void showNoPerson(Model model) {
        model.updateFilteredList(p -> false);

        assertTrue(model.getFilteredList().isEmpty());
    }
}
