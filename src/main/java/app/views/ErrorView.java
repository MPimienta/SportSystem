package app.views;

import app.types.Error;

public abstract class ErrorView {
    public static final String[] MESSAGES = {
            "\tThe command is not valid",
            "\tNot enough arguments",
            "\tPlayer already exists",
    };

    public abstract void writeln(Error error);
}
