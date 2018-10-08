package seedu.souschef.model;

import static org.junit.Assert.assertEquals;
import static seedu.souschef.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.souschef.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.souschef.testutil.TypicalRecipes.ALICE;
import static seedu.souschef.testutil.TypicalRecipes.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.souschef.model.exceptions.DuplicateException;
import seedu.souschef.model.recipe.Recipe;
import seedu.souschef.testutil.RecipeBuilder;

public class AddressBookTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private final AppContent addressBook = new AppContent();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), addressBook.getObservableRecipeList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        thrown.expect(NullPointerException.class);
        addressBook.resetData(null);
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        AppContent newData = getTypicalAddressBook();
        addressBook.resetData(newData);
        assertEquals(newData, addressBook);
    }

    @Test
    public void resetData_withDuplicateRecipes_throwsDuplicateRecipeException() {
        // Two recipes with the same identity fields
        Recipe editedAlice = new RecipeBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
                .build();
        List<Recipe> newRecipes = Arrays.asList(ALICE, editedAlice);
        AppContentStub newData = new AppContentStub(newRecipes);

        thrown.expect(DuplicateException.class);
        addressBook.resetData(newData);
    }

    //    @Test
    //    public void hasRecipe_nullRecipe_throwsNullPointerException() {
    //        thrown.expect(NullPointerException.class);
    //        addressBook.hasRecipe(null);
    //    }

    //    @Test
    //    public void hasRecipe_recipeNotInAddressBook_returnsFalse() {
    //        assertFalse(addressBook.hasRecipe(ALICE));
    //    }

    //    @Test
    //    public void hasrecipe_recipeInAddressBook_returnsTrue() {
    //        addressBook.addRecipe(ALICE);
    //        assertTrue(addressBook.hasRecipe(ALICE));
    //    }

    //    @Test
    //    public void hasRecipe_recipeWithSameIdentityFieldsInAddressBook_returnsTrue() {
    //        addressBook.addRecipe(ALICE);
    //        Recipe editedAlice = new RecipeBuilder(ALICE).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND)
    //                .build();
    //        assertTrue(addressBook.hasRecipe(editedAlice));
    //    }

    @Test
    public void getRecipeList_modifyList_throwsUnsupportedOperationException() {
        thrown.expect(UnsupportedOperationException.class);
        addressBook.getObservableRecipeList().remove(0);
    }

    /**
     * A stub ReadOnlyAppContent whose recipes list can violate interface constraints.
     */
    private static class AppContentStub implements ReadOnlyAppContent {
        private final ObservableList<Recipe> recipes = FXCollections.observableArrayList();

        AppContentStub(Collection<Recipe> recipes) {
            this.recipes.setAll(recipes);
        }

        @Override
        public ObservableList<Recipe> getObservableRecipeList() {
            return recipes;
        }
    }

}
