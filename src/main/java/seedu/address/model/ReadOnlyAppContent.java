package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.UniqueIngredient;
import seedu.address.model.recipe.Recipe;

/**
 * Unmodifiable view of an application content
 */
public interface ReadOnlyAppContent {

    /**
     * Returns an unmodifiable view of the respective list.
     * This list will not contain any duplicate recipes.
     */
    ObservableList<Recipe> getRecipeList();
    ObservableList<UniqueIngredient> getDictionary();
    ObservableList<Ingredient> getInventory();

}
