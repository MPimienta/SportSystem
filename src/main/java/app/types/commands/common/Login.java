package app.types.commands.common;

import app.models.CLIApp;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.UserType;

public class Login implements Command {
    private static final int NECESSARY_ARGUMENTS = 2;

    private final CLIApp cliApp;

    public Login(CLIApp cliApp){
        this.cliApp = cliApp;
    }

    public Error execute(String[] arguments) {

        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            error = this.login(arguments);
        }

        return error;
    }

    public Error login(String[] arguments){

        Error error = Error.NULL;
        if(this.cliApp.getCurrentUserType() != UserType.COMMON){
            error = Error.USER_LOGGED_IN;
        } else {
            error = this.cliApp.updateUser(arguments);
        }

        return error;
    }
}
