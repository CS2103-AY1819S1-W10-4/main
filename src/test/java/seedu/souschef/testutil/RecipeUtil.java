package seedu.souschef.testutil;

import static seedu.souschef.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.souschef.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.souschef.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.souschef.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.souschef.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.souschef.logic.commands.AddCommand;
import seedu.souschef.model.recipe.Recipe;

/**
 * A utility class for Recipe.
 */
public class RecipeUtil {

    /**
     * Returns an add command string for adding the {@code recipe}.
     */
    public static String getAddCommand(Recipe recipe) {
        return AddCommand.COMMAND_WORD + " " + getRecipeDetails(recipe);
    }

    /**
     * Returns the part of command string for the given {@code recipe}'s details.
     */
    public static String getRecipeDetails(Recipe recipe) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME + recipe.getName().fullName + " ");
        sb.append(PREFIX_PHONE + recipe.getPhone().value + " ");
        sb.append(PREFIX_EMAIL + recipe.getEmail().value + " ");
        sb.append(PREFIX_ADDRESS + recipe.getAddress().value + " ");
        recipe.getTags().stream().forEach(s -> sb.append(PREFIX_TAG + s.tagName + " ")
        );
        return sb.toString();
    }
}
