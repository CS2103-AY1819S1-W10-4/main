package seedu.souschef.logic.parser;
//TODO : add
public class AddCommandParserTest {
    /*private Model<Recipe> model;
    private AddCommandParser parser = new AddCommandParser();*/

    /*@Test
    public void parse_allFieldsPresent_success() {
        Recipe expectedRecipe = new RecipeBuilder(BEE).withTags(VALID_TAG_SPICY).build();

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE + NAME_DESC_BOB + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB
                + ADDRESS_DESC_BOB + TAG_DESC_FRIEND, new AddCommand(model, expectedRecipe));

        // multiple names - last name accepted
        assertParseSuccess(parser, NAME_DESC_AMY + NAME_DESC_BOB + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB
                + ADDRESS_DESC_BOB + TAG_DESC_FRIEND, new AddCommand(model, expectedRecipe));

        // multiple phones - last phone accepted
        assertParseSuccess(parser, NAME_DESC_BOB + DIFFICULTY_DESC_AMY + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB
                + ADDRESS_DESC_BOB + TAG_DESC_FRIEND, new AddCommand(model, expectedRecipe));

        // multiple emails - last email accepted
        assertParseSuccess(parser, NAME_DESC_BOB + DIFFICULTY_DESC_BOB + COOKTIME_DESC_AMY + COOKTIME_DESC_BOB
                + ADDRESS_DESC_BOB + TAG_DESC_FRIEND, new AddCommand(model, expectedRecipe));

        // multiple addresses - last address accepted
        assertParseSuccess(parser, NAME_DESC_BOB + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB + ADDRESS_DESC_AMY
                + ADDRESS_DESC_BOB + TAG_DESC_FRIEND, new AddCommand(model, expectedRecipe));

        // multiple tags - all accepted
        Recipe expectedRecipeMultipleTags = new RecipeBuilder(BEE).withTags(VALID_TAG_SPICY, VALID_TAG_STAPLE)
                .build();
        assertParseSuccess(parser, NAME_DESC_BOB + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB + ADDRESS_DESC_BOB
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, new AddCommand(model, expectedRecipeMultipleTags));
    }*/

    /*@Test
    public void parse_optionalFieldsMissing_success() {
        // zero tags
        Recipe expectedRecipe = new RecipeBuilder(AMERICA).withTags().build();
        assertParseSuccess(parser, NAME_DESC_AMY + DIFFICULTY_DESC_AMY + COOKTIME_DESC_AMY + ADDRESS_DESC_AMY,
                new AddCommand(model, expectedRecipe));
    }*/

    /*@Test
    public void parse_compulsoryFieldMissing_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE);

        // missing name prefix
        assertParseFailure(parser, VALID_NAME_BEE + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB + ADDRESS_DESC_BOB,
                expectedMessage);

        // missing phone prefix
        assertParseFailure(parser, NAME_DESC_BOB + VALID_DIFFICULTY_1 + COOKTIME_DESC_BOB + ADDRESS_DESC_BOB,
                expectedMessage);

        // missing email prefix
        assertParseFailure(parser, NAME_DESC_BOB + DIFFICULTY_DESC_BOB + VALID_COOKTIME_HR + ADDRESS_DESC_BOB,
                expectedMessage);

        // missing address prefix
        assertParseFailure(parser, NAME_DESC_BOB + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB + VALID_ADDRESS_BOB,
                expectedMessage);

        // all prefixes missing
        assertParseFailure(parser, VALID_NAME_BEE + VALID_DIFFICULTY_1 + VALID_COOKTIME_HR + VALID_ADDRESS_BOB,
                expectedMessage);
    }*/

    /*@Test
    public void parse_invalidValue_failure() {
        // invalid name
        assertParseFailure(parser, INVALID_NAME_DESC + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB + ADDRESS_DESC_BOB
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Name.MESSAGE_NAME_CONSTRAINTS);

        // invalid phone
        assertParseFailure(parser, NAME_DESC_BOB + INVALID_DIFFICULTY_DESC + COOKTIME_DESC_BOB + ADDRESS_DESC_BOB
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Phone.MESSAGE_PHONE_CONSTRAINTS);

        // invalid email
        assertParseFailure(parser, NAME_DESC_BOB + DIFFICULTY_DESC_BOB + INVALID_COOKTIME_DESC + ADDRESS_DESC_BOB
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Email.MESSAGE_EMAIL_CONSTRAINTS);

        // invalid address
        assertParseFailure(parser, NAME_DESC_BOB + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB + INVALID_ADDRESS_DESC
                + TAG_DESC_HUSBAND + TAG_DESC_FRIEND, Address.MESSAGE_ADDRESS_CONSTRAINTS);

        // invalid tag
        assertParseFailure(parser, NAME_DESC_BOB + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB + ADDRESS_DESC_BOB
                + INVALID_TAG_DESC + VALID_TAG_SPICY, Tag.MESSAGE_TAG_CONSTRAINTS);

        // two invalid values, only first invalid value reported
        assertParseFailure(parser, INVALID_NAME_DESC + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB + INVALID_ADDRESS_DESC,
                Name.MESSAGE_NAME_CONSTRAINTS);

        // non-empty preamble
        assertParseFailure(parser, PREAMBLE_NON_EMPTY + NAME_DESC_BOB + DIFFICULTY_DESC_BOB + COOKTIME_DESC_BOB
                + ADDRESS_DESC_BOB + TAG_DESC_HUSBAND + TAG_DESC_FRIEND,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddCommand.MESSAGE_USAGE));
    }*/
}
