package seedu.address.model;

import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.UniqueIngredient;
import seedu.address.model.recipe.Recipe;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Recipe> PREDICATE_SHOW_ALL_RECIPES = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<UniqueIngredient> PREDICATE_SHOW_ALL_UNIQUE_INGREDIENTS = unused -> true;

    /** {@code Predicate} that always evaluate to true */
    Predicate<Ingredient> PREDICATE_SHOW_ALL_INGREDIENTS = unused -> true;

    /** Clears existing backing model and replaces with the provided new data. */
    void resetData(ReadOnlyAppContent newData);

    /** Returns the AppContent */
    ReadOnlyAppContent getAppContent();

    /**
     * Returns true if a recipe with the same identity as {@code recipe} exists in the application content.
     */
    boolean hasRecipe(Recipe recipe);

    /**
     * Deletes the given recipe.
     * The recipe must exist in the application content.
     */
    void deleteRecipe(Recipe target);

    /**
     * Adds the given recipe.
     * {@code recipe} must not already exist in the application content.
     */
    void addRecipe(Recipe recipe);

    /**
     * Replaces the given recipe {@code target} with {@code editedRecipe}.
     * {@code target} must exist in the application content.
     * The recipe identity of {@code editedRecipe} must not be the same as another existing recipe in the application
     * content.
     */
    void updateRecipe(Recipe target, Recipe editedRecipe);

    boolean hasUniqueIngredient(UniqueIngredient uniqueIngredient);

    void deleteUniqueIngredient(UniqueIngredient target);

    void addUniqueIngredient(UniqueIngredient uniqueIngredient);

    void updateUniqueIngredient(UniqueIngredient target, UniqueIngredient editedUniqueIngredient);

    boolean hasIngredient(Ingredient ingredient);

    void deleteIngredient(Ingredient target);

    void addIngredient(Ingredient ingredient);

    void updateIngredient(Ingredient target, Ingredient editedIngredient);

    /** Returns an unmodifiable view of the filtered recipe list */
    ObservableList<Recipe> getFilteredRecipeList();

    /**
     * Updates the filter of the filtered recipe list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredRecipeList(Predicate<Recipe> predicate);

    /**
     * Returns an unmodifiable view of the list of {@code UniqueIngredient} backed by the internal list of
     * {@code versionedAppContent}
     */
    ObservableList<UniqueIngredient> getFilteredDictionary();

    void updateFilteredDictionary(Predicate<UniqueIngredient> predicate);

    /**
     * Returns an unmodifiable view of the list of {@code Ingredient} backed by the internal list of
     * {@code versionedAppContent}
     */
    ObservableList<Ingredient> getFilteredInventory();

    void updateFilteredInventory(Predicate<Ingredient> predicate);

    /**
     * Returns true if the model has previous address book states to restore.
     */
    boolean canUndoAppContent();

    /**
     * Returns true if the model has undone address book states to restore.
     */
    boolean canRedoAppContent();

    /**
     * Restores the model's address book to its previous state.
     */
    void undoAppContent();

    /**
     * Restores the model's address book to its previously undone state.
     */
    void redoAppContent();

    /**
     * Saves the current address book state for undo/redo.
     */
    void commitAppContent();
}
