package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.ComponentManager;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.events.model.AppContentChangedEvent;
import seedu.address.model.ingredient.Ingredient;
import seedu.address.model.ingredient.UniqueIngredient;
import seedu.address.model.recipe.Recipe;

/**
 * Represents the in-memory model of the address book data.
 */
public class ModelManager extends ComponentManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final VersionedAppContent versionedAppContent;
    private final FilteredList<Recipe> filteredRecipes;
    private final FilteredList<UniqueIngredient> filteredDictionary;
    private final FilteredList<Ingredient> filteredInventory;

    /**
     * Initializes a ModelManager with the given addressBook and userPrefs.
     */
    public ModelManager(ReadOnlyAppContent addressBook, UserPrefs userPrefs) {
        super();
        requireAllNonNull(addressBook, userPrefs);

        logger.fine("Initializing with address book: " + addressBook + " and user prefs " + userPrefs);

        versionedAppContent = new VersionedAppContent(addressBook);
        filteredRecipes = new FilteredList<>(versionedAppContent.getRecipeList());
        filteredDictionary = new FilteredList<>(versionedAppContent.getDictionary());
        filteredInventory = new FilteredList<>(versionedAppContent.getInventory());
    }

    public ModelManager() {
        this(new AppContent(), new UserPrefs());
    }

    @Override
    public void resetData(ReadOnlyAppContent newData) {
        versionedAppContent.resetData(newData);
        indicateAppContentChanged();
    }

    @Override
    public ReadOnlyAppContent getAppContent() {
        return versionedAppContent;
    }

    /** Raises an event to indicate the model has changed */
    private void indicateAppContentChanged() {
        raise(new AppContentChangedEvent(versionedAppContent));
    }

    @Override
    public boolean hasRecipe(Recipe recipe) {
        requireNonNull(recipe);
        return versionedAppContent.hasRecipe(recipe);
    }

    @Override
    public void deleteRecipe(Recipe target) {
        versionedAppContent.removeRecipe(target);
        indicateAppContentChanged();
    }

    @Override
    public void addRecipe(Recipe recipe) {
        versionedAppContent.addRecipe(recipe);
        updateFilteredRecipeList(PREDICATE_SHOW_ALL_RECIPES);
        indicateAppContentChanged();
    }

    @Override
    public void updateRecipe(Recipe target, Recipe editedRecipe) {
        requireAllNonNull(target, editedRecipe);

        versionedAppContent.updateRecipe(target, editedRecipe);
        indicateAppContentChanged();
    }

    @Override
    public boolean hasUniqueIngredient(UniqueIngredient uniqueIngredient) {
        requireNonNull(uniqueIngredient);
        return versionedAppContent.hasUniqueIngredient(uniqueIngredient);
    }

    @Override
    public void deleteUniqueIngredient(UniqueIngredient target) {
        versionedAppContent.removeUniqueIngredient(target);
        indicateAppContentChanged();
    }

    @Override
    public void addUniqueIngredient(UniqueIngredient uniqueIngredient) {
        versionedAppContent.addUniqueIngredient(uniqueIngredient);
        updateFilteredDictionary(PREDICATE_SHOW_ALL_UNIQUE_INGREDIENTS);
        indicateAppContentChanged();
    }

    @Override
    public void updateUniqueIngredient(UniqueIngredient target, UniqueIngredient editedUniqueIngredient) {
        requireAllNonNull(target, editedUniqueIngredient);

        versionedAppContent.updateUniqueIngredient(target, editedUniqueIngredient);
        indicateAppContentChanged();
    }

    @Override
    public boolean hasIngredient(Ingredient ingredient) {
        requireNonNull(ingredient);
        return versionedAppContent.hasIngredient(ingredient);
    }

    @Override
    public void deleteIngredient(Ingredient target) {
        versionedAppContent.removeIngredient(target);
        indicateAppContentChanged();
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        versionedAppContent.addIngredient(ingredient);
        updateFilteredInventory(PREDICATE_SHOW_ALL_INGREDIENTS);
        indicateAppContentChanged();
    }

    @Override
    public void updateIngredient(Ingredient target, Ingredient editedIngredient) {
        requireAllNonNull(target, editedIngredient);

        versionedAppContent.updateIngredient(target, editedIngredient);
        indicateAppContentChanged();
    }

    //=========== Filtered Recipe List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Recipe} backed by the internal list of
     * {@code versionedAppContent}
     */
    @Override
    public ObservableList<Recipe> getFilteredRecipeList() {
        return FXCollections.unmodifiableObservableList(filteredRecipes);
    }

    @Override
    public void updateFilteredRecipeList(Predicate<Recipe> predicate) {
        requireNonNull(predicate);
        filteredRecipes.setPredicate(predicate);
    }

    //=========== Filtered UniqueIngredient List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code UniqueIngredient} backed by the internal list of
     * {@code versionedAppContent}
     */
    @Override
    public ObservableList<UniqueIngredient> getFilteredDictionary() {
        return FXCollections.unmodifiableObservableList(filteredDictionary);
    }

    @Override
    public void updateFilteredDictionary(Predicate<UniqueIngredient> predicate) {
        requireNonNull(predicate);
        filteredDictionary.setPredicate(predicate);
    }

    //=========== Filtered Ingredient List Accessors =============================================================

    /**
     * Returns an unmodifiable view of the list of {@code Ingredient} backed by the internal list of
     * {@code versionedAppContent}
     */
    @Override
    public ObservableList<Ingredient> getFilteredInventory() {
        return FXCollections.unmodifiableObservableList(filteredInventory);
    }

    @Override
    public void updateFilteredInventory(Predicate<Ingredient> predicate) {
        requireNonNull(predicate);
        filteredInventory.setPredicate(predicate);
    }

    //=========== Undo/Redo =================================================================================

    @Override
    public boolean canUndoAppContent() {
        return versionedAppContent.canUndo();
    }

    @Override
    public boolean canRedoAppContent() {
        return versionedAppContent.canRedo();
    }

    @Override
    public void undoAppContent() {
        versionedAppContent.undo();
        indicateAppContentChanged();
    }

    @Override
    public void redoAppContent() {
        versionedAppContent.redo();
        indicateAppContentChanged();
    }

    @Override
    public void commitAppContent() {
        versionedAppContent.commit();
    }

    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return versionedAppContent.equals(other.versionedAppContent)
                && filteredRecipes.equals(other.filteredRecipes)
                && filteredDictionary.equals(other.filteredDictionary)
                && filteredInventory.equals(other.filteredInventory);
    }
}
