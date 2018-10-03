package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.Inventory;
import seedu.address.model.ingredient.UniqueIngredient;
import seedu.address.model.ingredient.UniqueIngredientList;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.UniqueRecipeList;

/**
 * Wraps all data at the application content level
 * Duplicates are not allowed (by .isSameRecipe comparison)
 */
public class AppContent implements ReadOnlyAppContent {

    private final UniqueRecipeList recipes;
    private final UniqueIngredientList dictionary;
    private final Inventory inventory;

    /*
     * The 'unusual' code block below is an non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        recipes = new UniqueRecipeList();
        dictionary = new UniqueIngredientList();
        inventory = new Inventory();
    }

    public AppContent() {}

    /**
     * Creates an AppContent using the recipes in the {@code toBeCopied}
     */
    public AppContent(ReadOnlyAppContent toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the recipe list with {@code recipes}.
     * {@code recipes} must not contain duplicate recipes.
     */
    public void setRecipes(List<Recipe> recipes) {
        this.recipes.setRecipes(recipes);
    }
    public void setDictionary(List<UniqueIngredient> dictionary) {
        this.dictionary.setUniqueIngredients(dictionary);
    }
    public void setInventory(List<Ingredient> inventory) {
        this.inventory.setIngredients(inventory);
    }

    /**
     * Resets the existing data of this {@code AppContent} with {@code newData}.
     */
    public void resetData(ReadOnlyAppContent newData) {
        requireNonNull(newData);
        setRecipes(newData.getRecipeList());
        setDictionary(newData.getDictionary());
        setInventory(newData.getInventory());
    }

    //// recipe-level operations

    /**
     * Returns true if a recipe with the same identity as {@code recipe} exists in the application content.
     */
    public boolean hasRecipe(Recipe recipe) {
        requireNonNull(recipe);
        return recipes.contains(recipe);
    }

    /**
     * Adds a recipe to the application content.
     * The recipe must not already exist in the application content.
     */
    public void addRecipe(Recipe p) {
        recipes.add(p);
    }

    /**
     * Replaces the given recipe {@code target} in the list with {@code editedRecipe}.
     * {@code target} must exist in the application content.
     * The recipe identity of {@code editedRecipe} must not be the same as another existing recipe in the application
     * content.
     */
    public void updateRecipe(Recipe target, Recipe editedRecipe) {
        requireNonNull(editedRecipe);

        recipes.setRecipe(target, editedRecipe);
    }

    /**
     * Removes {@code key} from this {@code AppContent}.
     * {@code key} must exist in the application content.
     */
    public void removeRecipe(Recipe key) {
        recipes.remove(key);
    }

    //// ingredient-level operations

    /**
     * Returns true if a ingredient with the same identity as {@code ingredient} exists in the address book.
     */
    public boolean hasUniqueIngredient(UniqueIngredient ingredient) {
        requireNonNull(ingredient);
        return dictionary.contains(ingredient);
    }

    /**
     * Adds a ingredient to the address book.
     * The ingredient must not already exist in the address book.
     */
    public void addUniqueIngredient(UniqueIngredient p) {
        dictionary.add(p);
    }

    /**
     * Replaces the given ingredient {@code target} in the list with {@code editedUniqueIngredient}.
     * {@code target} must exist in the address book.
     * The ingredient identity of {@code editedUniqueIngredient} must not be the same as another existing ingredient
     * in the address book.
     */
    public void updateUniqueIngredient(UniqueIngredient target, UniqueIngredient editedUniqueIngredient) {
        requireNonNull(editedUniqueIngredient);

        dictionary.setUniqueIngredient(target, editedUniqueIngredient);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeUniqueIngredient(UniqueIngredient key) {
        dictionary.remove(key);
    }

    /**
     * Returns true if a ingredient with the same identity as {@code ingredient} exists in the address book.
     */
    public boolean hasIngredient(Ingredient ingredient) {
        requireNonNull(ingredient);
        return inventory.contains(ingredient);
    }

    /**
     * Adds a ingredient to the address book.
     * The ingredient must not already exist in the address book.
     */
    public void addIngredient(Ingredient p) {
        inventory.add(p);
    }

    /**
     * Replaces the given ingredient {@code target} in the list with {@code editedIngredient}.
     * {@code target} must exist in the address book.
     * The ingredient identity of {@code editedIngredient} must not be the same as another existing ingredient
     * in the address book.
     */
    public void updateIngredient(Ingredient target, Ingredient editedIngredient) {
        requireNonNull(editedIngredient);

        inventory.setIngredient(target, editedIngredient);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */
    public void removeIngredient(Ingredient key) {
        inventory.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return recipes.asUnmodifiableObservableList().size() + " recipes";
        // TODO: refine later
    }

    @Override
    public ObservableList<Recipe> getRecipeList() {
        return recipes.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<UniqueIngredient> getDictionary() {
        return dictionary.asUnmodifiableObservableList();
    }

    @Override
    public ObservableList<Ingredient> getInventory() {
        return inventory.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AppContent // instanceof handles nulls
                && recipes.equals(((AppContent) other).recipes))
                && dictionary.equals(((AppContent) other).dictionary)
                && inventory.equals(((AppContent) other).inventory);
    }

    @Override
    public int hashCode() {
        return recipes.hashCode();
    }
}
