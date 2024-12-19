package app.types;

public enum Error {

    INVALID_COMMAND,
    NOT_ENOUGH_ARGUMENTS,
    ELEMENT_ALREADY_EXISTS,
    NOT_ADMIN,
    ALREADY_LOGGED_OUT,
    USER_LOGGED_IN,
    USER_DOES_NOT_EXIST,
    ELEMENT_DOES_NOT_EXIST,
    WRONG_DATE_FORMAT,
    UNEVEN_AMOUNT_OF_PLAYERS,
    PLAYER_IN_ONGOING_TOURNAMENT,
    ONGOING_TOURNAMENT,
    PLAYER_NOT_IN_TEAM,
    UNKNOWN_FORMAT,
    INCORRECT_PASSWORD,
    UNKNOWN_CATEGORY,
    NOT_PLAYER,
    OPENING_FILE_ERROR,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }

}
