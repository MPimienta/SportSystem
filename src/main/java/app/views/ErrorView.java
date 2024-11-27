package app.views;

import app.types.Error;

public abstract class ErrorView {
    public static final String[] MESSAGES = {
            "\tThe command is not valid",
            "\tNot enough arguments",
            "\tPlayer already exists",
            "\tYou do not possess admin privileges",
            "\tYou are already logged out",
            "\tThere is a user currently logged in",
            "\tUser already exists",
            "\tUser does not exist",
            "\tPlayer does not exist",
            "\tWrong date format",
    };

    public abstract void writeln(Error error);
}
