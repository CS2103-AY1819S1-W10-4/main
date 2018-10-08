package seedu.souschef.logic.commands;

seedu.souschef.logic.CommandHistory;
import seedu.souschef.logic.commands.exceptions.CommandException;
import seedu.souschef.model.Model;
import seedu.souschef.model.recipe.Recipe;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command<T extends UniqueType> {

    /**
     * Executes the command and returns the result message.
     *
     * @param history {@code CommandHistory} which the command should operate on.
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
<<<<<<< HEAD:src/main/java/seedu/address/logic/commands/Command.java
    public abstract CommandResult execute(CommandHistory history) throws CommandException;
=======
    public abstract CommandResult execute(Model<Recipe> model, CommandHistory history) throws CommandException;
>>>>>>> 327b25fefda23974fc349e1177a88a82bd6bd45a:src/main/java/seedu/souschef/logic/commands/Command.java

}
