package seedu.souschef.logic.commands;

public class RedoCommandTest {

    /*private final Model<Recipe> model = new ModelSetCoordinator(getTypicalAddressBook(),
            new UserPrefs()).getRecipeModel();
    private final Model<Recipe> expectedModel =
            new ModelSetCoordinator(getTypicalAddressBook(), new UserPrefs()).getRecipeModel();
    private final CommandHistory commandHistory = new CommandHistory();

    @Before
    public void setUp() {
        // set up of both models' undo/redo history
        deleteFirstPerson(model);
        deleteFirstPerson(model);
        model.undoAppContent();
        model.undoAppContent();

        deleteFirstPerson(expectedModel);
        deleteFirstPerson(expectedModel);
        expectedModel.undoAppContent();
        expectedModel.undoAppContent();
    }

    @Test
    public void execute() {
        // multiple redoable states in recipeModel
        expectedModel.redoAppContent();
        assertCommandSuccess(new RedoCommand(model), model, commandHistory, RedoCommand.MESSAGE_SUCCESS, expectedModel);

        // single redoable state in recipeModel
        expectedModel.redoAppContent();
        assertCommandSuccess(new RedoCommand(model), model, commandHistory, RedoCommand.MESSAGE_SUCCESS, expectedModel);

        // no redoable state in recipeModel
        assertCommandFailure(new RedoCommand(model), model, commandHistory, RedoCommand.MESSAGE_FAILURE);
    }*/
}
