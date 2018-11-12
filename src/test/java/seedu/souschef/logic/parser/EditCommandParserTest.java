package seedu.souschef.logic.parser;

public class EditCommandParserTest {

    /*private static final String TAG_EMPTY = " " + PREFIX_TAG;

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE);

    private EditCommandParser parser = new EditCommandParser();*/

    /*@Test
    public void parse_missingParts_failure() {
        // no index specified
        assertParseFailure(parser, VALID_NAME_AMERICA, MESSAGE_INVALID_FORMAT);

        // no field specified
        assertParseFailure(parser, "1", EditCommand.MESSAGE_NOT_EDITED);

        // no index and no field specified
        assertParseFailure(parser, "", MESSAGE_INVALID_FORMAT);
    }*/

    /*@Test
    public void parse_invalidPreamble_failure() {
        // negative index
        assertParseFailure(parser, "-5" + NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // zero index
        assertParseFailure(parser, "0" + NAME_DESC_AMY, MESSAGE_INVALID_FORMAT);

        // invalid arguments being parsed as preamble
        assertParseFailure(parser, "1 some random string", MESSAGE_INVALID_FORMAT);

        // invalid prefix being parsed as preamble
        assertParseFailure(parser, "1 i/ string", MESSAGE_INVALID_FORMAT);
    }*/

    /*@Test
    public void parse_invalidValue_failure() {
        assertParseFailure(parser, "1" + INVALID_NAME_DESC, Name.MESSAGE_NAME_CONSTRAINTS); // invalid name
        assertParseFailure(parser, "1" + INVALID_DIFFICULTY_DESC, Phone.MESSAGE_PHONE_CONSTRAINTS); // invalid phone
        assertParseFailure(parser, "1" + INVALID_COOKTIME_DESC, Email.MESSAGE_EMAIL_CONSTRAINTS); // invalid email
        assertParseFailure(parser, "1" + INVALID_ADDRESS_DESC, Address.MESSAGE_ADDRESS_CONSTRAINTS); // invalid address
        assertParseFailure(parser, "1" + INVALID_TAG_DESC, Tag.MESSAGE_TAG_CONSTRAINTS); // invalid tag

        // invalid phone followed by valid email
        assertParseFailure(parser, "1" + INVALID_DIFFICULTY_DESC + COOKTIME_DESC_AMY, Phone.MESSAGE_PHONE_CONSTRAINTS);

        // valid phone followed by invalid phone. The test case for invalid phone followed by valid phone
        // is tested at {@code parse_invalidValueFollowedByValidValue_success()}
        assertParseFailure(parser, "1" + DIFFICULTY_DESC_BOB + INVALID_DIFFICULTY_DESC,
        Phone.MESSAGE_PHONE_CONSTRAINTS);

        // while parsing {@code PREFIX_TAG} alone will reset the tags of the {@code Recipe} being edited,
        // parsing it together with a valid tag results in error
        assertParseFailure(parser, "1" + TAG_DESC_FRIEND + TAG_DESC_HUSBAND + TAG_EMPTY, Tag.MESSAGE_TAG_CONSTRAINTS);
        assertParseFailure(parser, "1" + TAG_DESC_FRIEND + TAG_EMPTY + TAG_DESC_HUSBAND, Tag.MESSAGE_TAG_CONSTRAINTS);
        assertParseFailure(parser, "1" + TAG_EMPTY + TAG_DESC_FRIEND + TAG_DESC_HUSBAND, Tag.MESSAGE_TAG_CONSTRAINTS);

        // multiple invalid values, but only the first invalid value is captured
        assertParseFailure(parser, "1" + INVALID_NAME_DESC + INVALID_COOKTIME_DESC
        + VALID_ADDRESS_AMY + VALID_DIFFICULTY_5,
                Name.MESSAGE_NAME_CONSTRAINTS);
    }*/

    /*@Test
    public void parse_allFieldsSpecified_success() {
        Index targetIndex = INDEX_SECOND_RECIPE;
        String userInput = targetIndex.getOneBased() + DIFFICULTY_DESC_BOB + TAG_DESC_HUSBAND
                + COOKTIME_DESC_AMY + ADDRESS_DESC_AMY + NAME_DESC_AMY + TAG_DESC_FRIEND;

        EditRecipeDescriptor descriptor = new EditRecipeDescriptorBuilder().withName(VALID_NAME_AMERICA)
                .withDifficulty(VALID_DIFFICULTY_1).withCooktime(VALID_COOKTIME_MIN).withAddress(VALID_ADDRESS_AMY)
                .withTags(VALID_TAG_STAPLE, VALID_TAG_SPICY).build();
        EditCommand<Recipe> expectedCommand = new EditCommand<Recipe>(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }*/

    /*@Test
    public void parse_someFieldsSpecified_success() {
        Index targetIndex = INDEX_FIRST_RECIPE;
        String userInput = targetIndex.getOneBased() + DIFFICULTY_DESC_BOB + COOKTIME_DESC_AMY;

        EditRecipeDescriptor descriptor = new EditRecipeDescriptorBuilder().withDifficulty(VALID_DIFFICULTY_1)
                .withCooktime(VALID_COOKTIME_MIN).build();
        EditCommand<Recipe> expectedCommand = new EditCommand<Recipe>(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }*/

    /*@Test
    public void parse_oneFieldSpecified_success() {
        // name
        Index targetIndex = INDEX_THIRD_RECIPE;
        String userInput = targetIndex.getOneBased() + NAME_DESC_AMY;
        EditRecipeDescriptor descriptor = new EditRecipeDescriptorBuilder().withName(VALID_NAME_AMERICA).build();
        EditCommand<Recipe> expectedCommand = new EditCommand<Recipe>(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // phone
        userInput = targetIndex.getOneBased() + DIFFICULTY_DESC_AMY;
        descriptor = new EditRecipeDescriptorBuilder().withDifficulty(VALID_DIFFICULTY_5).build();
        expectedCommand = new EditCommand<Recipe>(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // email
        userInput = targetIndex.getOneBased() + COOKTIME_DESC_AMY;
        descriptor = new EditRecipeDescriptorBuilder().withCooktime(VALID_COOKTIME_MIN).build();
        expectedCommand = new EditCommand<Recipe>(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // address
        userInput = targetIndex.getOneBased() + ADDRESS_DESC_AMY;
        descriptor = new EditRecipeDescriptorBuilder().withAddress(VALID_ADDRESS_AMY).build();
        expectedCommand = new EditCommand<Recipe>(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // tags
        userInput = targetIndex.getOneBased() + TAG_DESC_FRIEND;
        descriptor = new EditRecipeDescriptorBuilder().withTags(VALID_TAG_SPICY).build();
        expectedCommand = new EditCommand<Recipe>(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }*/

    /*@Test
    public void parse_multipleRepeatedFields_acceptsLast() {
        Index targetIndex = INDEX_FIRST_RECIPE;
        String userInput = targetIndex.getOneBased() + DIFFICULTY_DESC_AMY + ADDRESS_DESC_AMY + COOKTIME_DESC_AMY
                + TAG_DESC_FRIEND + DIFFICULTY_DESC_AMY + ADDRESS_DESC_AMY + COOKTIME_DESC_AMY + TAG_DESC_FRIEND
                + DIFFICULTY_DESC_BOB + ADDRESS_DESC_BOB + COOKTIME_DESC_BOB + TAG_DESC_HUSBAND;
        EditCommand.EditRecipeDescriptor descriptor = new EditRecipeDescriptorBuilder()
        .withDifficulty(VALID_DIFFICULTY_1)
                .withCooktime(VALID_COOKTIME_HR).withAddress(VALID_ADDRESS_BOB)
                .withTags(VALID_TAG_SPICY, VALID_TAG_STAPLE)
                .build();
        EditCommand<Recipe> expectedCommand = new EditCommand<Recipe>(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }*/

    /*@Test
    public void parse_invalidValueFollowedByValidValue_success() {
        // no other valid values specified
        Index targetIndex = INDEX_FIRST_RECIPE;
        String userInput = targetIndex.getOneBased() + INVALID_DIFFICULTY_DESC + DIFFICULTY_DESC_BOB;
        EditCommand.EditRecipeDescriptor descriptor = new EditRecipeDescriptorBuilder()
                .withDifficulty(VALID_DIFFICULTY_1).build();
        EditCommand<Recipe> expectedCommand = new EditCommand<Recipe>(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);

        // other valid values specified
        userInput = targetIndex.getOneBased() + COOKTIME_DESC_BOB + INVALID_DIFFICULTY_DESC + ADDRESS_DESC_BOB
                + DIFFICULTY_DESC_BOB;
        descriptor = new EditRecipeDescriptorBuilder().withDifficulty(VALID_DIFFICULTY_1)
        .withCooktime(VALID_COOKTIME_HR)
                .withAddress(VALID_ADDRESS_BOB).build();
        expectedCommand = new EditCommand<Recipe>(targetIndex, descriptor);
        assertParseSuccess(parser, userInput, expectedCommand);
    }*/

    /*@Test
    public void parse_resetTags_success() {
        Index targetIndex = INDEX_THIRD_RECIPE;
        String userInput = targetIndex.getOneBased() + TAG_EMPTY;

        EditRecipeDescriptor descriptor = new EditRecipeDescriptorBuilder().withTags().build();
        EditCommand<Recipe> expectedCommand = new EditCommand<Recipe>(targetIndex, descriptor);

        assertParseSuccess(parser, userInput, expectedCommand);
    }*/
}
