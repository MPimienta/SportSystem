package app.types;

public enum Error {

    INVALID_COMMAND,
    NOT_ENOUGH_ARGUMENTS,
    PLAYER_ALREADY_EXISTS,
    NOT_ADMIN,
    ALREADY_LOGGED_OUT,
    USER_LOGGED_IN,
    USER_ALREADY_EXISTS,
    USER_DOES_NOT_EXIST,
    PLAYER_DOES_NOT_EXIST,
    WRONG_DATE_FORMAT,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }

}
