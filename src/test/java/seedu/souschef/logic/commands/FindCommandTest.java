package seedu.souschef.logic.commands;

import org.junit.Test;

import seedu.souschef.model.recipe.NameContainsKeywordsPredicate;

/**
 * Contains integration tests (interaction with the Model) for {@code FindCommand}.
 */
public class FindCommandTest {
    /*private Model<Recipe> model = new ModelSetCoordinator(getTypicalAddressBook(), new UserPrefs()).getRecipeModel();
    private Model<Recipe> expectedModel =
            new ModelSetCoordinator(getTypicalAddressBook(), new UserPrefs()).getRecipeModel();
    private CommandHistory commandHistory = new CommandHistory();*/

    @Test
    public void equals() {
        /*NameContainsKeywordsPredicate firstPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList("first"));
        NameContainsKeywordsPredicate secondPredicate =
                new NameContainsKeywordsPredicate(Collections.singletonList("second"));

        FindCommand findFirstCommand = new FindCommand(model, firstPredicate);
        FindCommand findSecondCommand = new FindCommand(model, secondPredicate);

        // same object -> returns true
        assertTrue(findFirstCommand.equals(findFirstCommand));

        // same values -> returns true
        FindCommand findFirstCommandCopy = new FindCommand(model, firstPredicate);
        assertTrue(findFirstCommand.equals(findFirstCommandCopy));

        // different types -> returns false
        assertFalse(findFirstCommand.equals(1));

        // null -> returns false
        assertFalse(findFirstCommand.equals(null));

        // different recipe -> returns false
        assertFalse(findFirstCommand.equals(findSecondCommand));*/
    }

    @Test
    public void execute_zeroKeywords_noPersonFound() {
        /*String expectedMessage = String.format(MESSAGE_RECIPES_LISTED_OVERVIEW, 0);
        NameContainsKeywordsPredicate predicate = preparePredicate(" ");
        FindCommand command = new FindCommand(model, predicate);
        expectedModel.updateFilteredList(predicate);
        assertCommandSuccess(command, model, commandHistory, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredList());*/
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
        /*String expectedMessage = String.format(MESSAGE_RECIPES_LISTED_OVERVIEW, 3);
        NameContainsKeywordsPredicate predicate = preparePredicate("Kurz Elle Kunz");
        FindCommand command = new FindCommand(model, predicate);
        expectedModel.updateFilteredList(predicate);
        assertCommandSuccess(command, model, commandHistory, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(CARL, ELLE, FIONA), model.getFilteredList());*/
    }

    /**
     * Parses {@code userInput} into a {@code NameContainsKeywordsPredicate}.
     */
    private NameContainsKeywordsPredicate preparePredicate(String userInput) {
        /*return new NameContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));*/
        return null;
    }
}
