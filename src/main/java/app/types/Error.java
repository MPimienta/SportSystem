package app.types;

public enum Error {

    INVALID_COMMAND,
    NOT_OWNER,
    SAME_COORDINATES,
    WRONG_COORDINATES,
    NULL;

    public boolean isNull() {
        return this == Error.NULL;
    }

}
