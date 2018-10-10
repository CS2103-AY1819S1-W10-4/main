package seedu.souschef.model;

import javafx.collections.ObservableList;
import seedu.souschef.model.ingredient.Ingredient;
import seedu.souschef.model.recipe.Recipe;

/**
 * Unmodifiable view of an application content
 */
public interface ReadOnlyAppContent {

    /**
     * Returns an unmodifiable view of the respective list.
     * This list will not contain any duplicate contents.
     */
    ObservableList<Recipe> getObservableRecipeList();

    ObservableList<Ingredient> getObservableIngredientList();

}
