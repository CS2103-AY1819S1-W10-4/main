package seedu.souschef.logic.commands;

/**
 * Contains integration tests (interaction with the Model) for {@code SelectCommand}.
 */
public class SelectCommandTest {
    /*@Rule
    public final EventsCollectorRule eventsCollectorRule = new EventsCollectorRule();

    private Model<Recipe> model = new ModelSetCoordinator(getTypicalAddressBook(), new UserPrefs()).getRecipeModel();
    private Model<Recipe> expectedModel = new ModelSetCoordinator(getTypicalAddressBook(),
            new UserPrefs()).getRecipeModel();
    private CommandHistory commandHistory = new CommandHistory();

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Index lastPersonIndex = Index.fromOneBased(model.getFilteredList().size());

        assertExecutionSuccess(INDEX_FIRST_RECIPE);
        assertExecutionSuccess(INDEX_THIRD_RECIPE);
        assertExecutionSuccess(lastPersonIndex);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_failure() {
        Index outOfBoundsIndex = Index.fromOneBased(model.getFilteredList().size() + 1);

        assertExecutionFailure(outOfBoundsIndex, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showPersonAtIndex(model, INDEX_FIRST_RECIPE);
        showPersonAtIndex(expectedModel, INDEX_FIRST_RECIPE);

        assertExecutionSuccess(INDEX_FIRST_RECIPE);
    }

    @Test
    public void execute_invalidIndexFilteredList_failure() {
        showPersonAtIndex(model, INDEX_FIRST_RECIPE);
        showPersonAtIndex(expectedModel, INDEX_FIRST_RECIPE);

        Index outOfBoundsIndex = INDEX_SECOND_RECIPE;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundsIndex.getZeroBased() < model.getAppContent().getObservableRecipeList().size());

        assertExecutionFailure(outOfBoundsIndex, Messages.MESSAGE_INVALID_RECIPE_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        SelectCommand selectFirstCommand = new SelectCommand(model, INDEX_FIRST_RECIPE);
        SelectCommand selectSecondCommand = new SelectCommand(model, INDEX_SECOND_RECIPE);

        // same object -> returns true
        assertTrue(selectFirstCommand.equals(selectFirstCommand));

        // same values -> returns true
        SelectCommand selectFirstCommandCopy = new SelectCommand(model, INDEX_FIRST_RECIPE);
        assertTrue(selectFirstCommand.equals(selectFirstCommandCopy));

        // different types -> returns false
        assertFalse(selectFirstCommand.equals(1));

        // null -> returns false
        assertFalse(selectFirstCommand.equals(null));

        // different recipe -> returns false
        assertFalse(selectFirstCommand.equals(selectSecondCommand));
    }

    *//**
     * Executes a {@code SelectCommand} with the given {@code index}, and checks that {@code JumpToListRequestEvent}
     * is raised with the correct index.
     *//*
    private void assertExecutionSuccess(Index index) {
        SelectCommand selectCommand = new SelectCommand(model, index);
        String expectedMessage = String.format(SelectCommand.MESSAGE_SELECT_RECIPE_SUCCESS, index.getOneBased());

        assertCommandSuccess(selectCommand, model, commandHistory, expectedMessage, expectedModel);

        JumpToListRequestEvent lastEvent = (JumpToListRequestEvent) eventsCollectorRule.eventsCollector.getMostRecent();
        assertEquals(index, Index.fromZeroBased(lastEvent.targetIndex));
    }

    *//**
     * Executes a {@code SelectCommand} with the given {@code index}, and checks that a {@code CommandException}
     * is thrown with the {@code expectedMessage}.
     *//*
    private void assertExecutionFailure(Index index, String expectedMessage) {
        SelectCommand selectCommand = new SelectCommand(model, index);
        assertCommandFailure(selectCommand, model, commandHistory, expectedMessage);
        assertTrue(eventsCollectorRule.eventsCollector.isEmpty());
    }*/
}
