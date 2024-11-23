package app.types;

public enum Error {

    INVALID_COMMAND,
    NOT_ENOUGH_ARGUMENTS,
    PLAYER_ALREADY_EXISTS,
    WRONG_COORDINATES,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }

}
