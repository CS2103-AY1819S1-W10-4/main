package seedu.souschef.logic.commands;

public class UndoCommandTest {

    /*private final Model<Recipe> model = new ModelSetCoordinator(getTypicalAddressBook(),
            new UserPrefs()).getRecipeModel();
    private final Model<Recipe> expectedModel = new ModelSetCoordinator(getTypicalAddressBook(),
            new UserPrefs()).getRecipeModel();
    private final CommandHistory commandHistory = new CommandHistory();

    @Before
    public void setUp() {
        // set up of models' undo/redo history
        deleteFirstPerson(model);
        deleteFirstPerson(model);

        deleteFirstPerson(expectedModel);
        deleteFirstPerson(expectedModel);
    }

    @Test
    public void execute() {
        // multiple undoable states in recipeModel
        expectedModel.undoAppContent();
        assertCommandSuccess(new UndoCommand(model), model, commandHistory, UndoCommand.MESSAGE_SUCCESS, expectedModel);

        // single undoable state in recipeModel
        expectedModel.undoAppContent();
        assertCommandSuccess(new UndoCommand(model), model, commandHistory, UndoCommand.MESSAGE_SUCCESS, expectedModel);

        // no undoable states in recipeModel
        assertCommandFailure(new UndoCommand(model), model, commandHistory, UndoCommand.MESSAGE_FAILURE);
    }*/
}
