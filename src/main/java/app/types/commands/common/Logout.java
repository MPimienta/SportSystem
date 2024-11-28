package app.types.commands.common;

import app.models.CLIApp;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.UserType;

public class Logout implements Command {

    private final CLIApp cliApp;

    public Logout(CLIApp cliApp){
        this.cliApp = cliApp;
    }

    public Error execute(String[] arguments) {
        Error error = Error.NULL;
        if(this.cliApp.getCurrentUserType() == UserType.COMMON){
            error = Error.ALREADY_LOGGED_OUT;
        } else {
            this.cliApp.logout();
        }

        return error;
    }

}
