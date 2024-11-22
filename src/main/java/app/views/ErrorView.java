package app.views;

import app.types.Error;

public abstract class ErrorView {
    public static final String[] MESSAGES = {
            "The command is not valid",
    };

    public abstract void writeln(Error error);
}