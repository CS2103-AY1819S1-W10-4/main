package seedu.souschef.model.healthplan;

import static java.util.Objects.requireNonNull;
import static seedu.souschef.commons.util.AppUtil.checkArgument;

/**
 * Class to handle the target weights set by the user
 */
public class TargetWeight {

    public static final String MESSAGE_WEIGHT_CONSTRAINTS =
            "Weights should only contain numbers";
    public static final String WEIGHT_VALIDATION_REGEX = "\\d{2,}";
    public final String value;


    public TargetWeight(String weight) {
        requireNonNull(weight);
        checkArgument(isValidWeight(weight), MESSAGE_WEIGHT_CONSTRAINTS);
        value = weight;
    }

    public static boolean isValidWeight(String test) {
        return test.matches(WEIGHT_VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof TargetWeight // instanceof handles nulls
                && value.equals(((TargetWeight) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }



}
