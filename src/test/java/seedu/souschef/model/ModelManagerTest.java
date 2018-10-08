package seedu.souschef.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.souschef.model.Model.PREDICATE_SHOW_ALL;
import static seedu.souschef.testutil.TypicalRecipes.ALICE;
import static seedu.souschef.testutil.TypicalRecipes.BENSON;

import java.nio.file.Paths;
import java.util.Arrays;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import seedu.souschef.model.recipe.NameContainsKeywordsPredicate;
import seedu.souschef.model.recipe.Recipe;
import seedu.souschef.testutil.AppContentBuilder;

public class ModelManagerTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private ModelManager<Recipe> modelManager = (ModelManager<Recipe>) new ModelSetCoordinator().getRecipeModel();

    @Test
    public void hasRecipe_nullRecipe_throwsNullPointerException() {
        thrown.expect(NullPointerException.class);
        modelManager.has(null);
    }

    @Test
    public void hasRecipe_recipeNotInAddressBook_returnsFalse() {
        assertFalse(modelManager.has(ALICE));
    }

    @Test
    public void hasRecipe_recipeInAddressBook_returnsTrue() {
        modelManager.add(ALICE);
        assertTrue(modelManager.has(ALICE));
    }

    @Test
    public void getFilteredRecipeList_modifyList_throwsUnsupportedOperationException() {
        thrown.expect(UnsupportedOperationException.class);
        modelManager.getFilteredList().remove(0);
    }

    @Test
    public void equals() {
        AppContent addressBook = new AppContentBuilder().withRecipe(ALICE).withRecipe(BENSON).build();
        AppContent differentAddressBook = new AppContent();
        UserPrefs userPrefs = new UserPrefs();

        // same values -> returns true
        modelManager = (ModelManager<Recipe>) new ModelSetCoordinator(addressBook, userPrefs).getRecipeModel();
        ModelManager modelManagerCopy = (ModelManager<Recipe>) new ModelSetCoordinator(addressBook,
                userPrefs).getRecipeModel();
        assertTrue(modelManager.equals(modelManagerCopy));

        // same object -> returns true
        assertTrue(modelManager.equals(modelManager));

        // null -> returns false
        assertFalse(modelManager.equals(null));

        // different types -> returns false
        assertFalse(modelManager.equals(5));

        // different addressBook -> returns false
        assertFalse(modelManager.equals(new ModelSetCoordinator(differentAddressBook, userPrefs).getRecipeModel()));

        // different filteredList -> returns false
        String[] keywords = ALICE.getName().fullName.split("\\s+");
        modelManager.updateFilteredList(new NameContainsKeywordsPredicate(Arrays.asList(keywords)));
        assertFalse(modelManager.equals(new ModelSetCoordinator(addressBook, userPrefs).getRecipeModel()));

        // resets modelManager to initial state for upcoming tests
        modelManager.updateFilteredList(PREDICATE_SHOW_ALL);

        // different userPrefs -> returns true
        UserPrefs differentUserPrefs = new UserPrefs();
        differentUserPrefs.setAddressBookFilePath(Paths.get("differentFilePath"));
        assertTrue(modelManager.equals(new ModelSetCoordinator(addressBook, userPrefs).getRecipeModel()));
    }
}
