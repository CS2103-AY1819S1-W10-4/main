package seedu.souschef.logic.commands;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static seedu.souschef.commons.core.Messages.MESSAGE_RECIPES_LISTED_OVERVIEW;
import static seedu.souschef.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.souschef.testutil.TypicalRecipes.CARL;
import static seedu.souschef.testutil.TypicalRecipes.ELLE;
import static seedu.souschef.testutil.TypicalRecipes.FIONA;
import static seedu.souschef.testutil.TypicalRecipes.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/FindCommandTest.java
import seedu.address.logic.CommandHistory;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UniqueType;
import seedu.address.model.UserPrefs;
import seedu.address.model.recipe.NameContainsKeywordsPredicate;
=======
import seedu.souschef.logic.CommandHistory;
import seedu.souschef.model.Model;
import seedu.souschef.model.ModelSetCoordinator;
import seedu.souschef.model.UserPrefs;
import seedu.souschef.model.recipe.NameContainsKeywordsPredicate;
import seedu.souschef.model.recipe.Recipe;
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/commands/FindCommandTest.java

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FindCommandTest {
    private Model<Recipe> model = new ModelSetCoordinator(getTypicalAddressBook(), new UserPrefs()).getRecipeModel();
    private Model<Recipe> expectedModel =
            new ModelSetCoordinator(getTypicalAddressBook(), new UserPrefs()).getRecipeModel();
    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void equals() {
        NameContainsKeywordsPredicate firstPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList("first"));
        NameContainsKeywordsPredicate secondPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList("second"));

        FindCommand<UniqueType> findFirstCommand = new FindCommand<UniqueType>(, firstPredicate);
        FindCommand<UniqueType> findSecondCommand = new FindCommand<UniqueType>(, secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindCommand<UniqueType> findFirstCommandCopy = new FindCommand<UniqueType>(, firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different recipe -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noPersonFound() {
        String expectedMessage = String.format(MESSAGE_RECIPES_LISTED_OVERVIEW, 0);
        NameContainsKeywordsPredicate predicate = preparePredicate(" ");
<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/FindCommandTest.java
        FindCommand<UniqueType> command = new FindCommand<UniqueType>(, predicate);
        expectedModel.updateFilteredRecipeList(predicate);
=======
        FindCommand command = new FindCommand(predicate);
        expectedModel.updateFilteredList(predicate);
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/commands/FindCommandTest.java
        assertCommandSuccess(command, model, commandHistory, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredList());
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
        String expectedMessage = String.format(MESSAGE_RECIPES_LISTED_OVERVIEW, 3);
        NameContainsKeywordsPredicate predicate = preparePredicate("Kurz Elle Kunz");
<<<<<<< HEAD:src/test/java/seedu/address/logic/commands/FindCommandTest.java
        FindCommand<UniqueType> command = new FindCommand<UniqueType>(, predicate);
        expectedModel.updateFilteredRecipeList(predicate);
=======
        FindCommand command = new FindCommand(predicate);
        expectedModel.updateFilteredList(predicate);
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/test/java/seedu/souschef/logic/commands/FindCommandTest.java
        assertCommandSuccess(command, model, commandHistory, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(CARL, ELLE, FIONA), model.getFilteredList());
    }

    /**
     * Parses {@code userInput} into a {@code NameContainsKeywordsPredicate}.
     */
    private NameContainsKeywordsPredicate preparePredicate(String userInput) {
        return new NameContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
