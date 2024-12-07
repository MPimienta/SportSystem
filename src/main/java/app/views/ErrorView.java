package app.views;

import app.types.Error;

public abstract class ErrorView {
    public static final String[] MESSAGES = {
            "\tThe command is not valid",
            "\tNot enough arguments",
            "\tElement already exists",
            "\tYou do not possess admin privileges",
            "\tYou are already logged out",
            "\tThere is a user currently logged in",
            "\tUser already exists",
            "\tUser does not exist",
            "\tPlayer does not exist",
            "\tWrong date format",
            "\tUneven amount of players",
            "\tPlayer is currently in an ongoing tournament",
            "\tThis tournament is already ongoing",
            "\tCurrent player is not in specified team",
            "\tUnknown specified format",
            "\tIncorrect password"
    };

    public abstract void writeln(Error error);
}
