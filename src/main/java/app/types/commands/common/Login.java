package app.types.commands.common;

import app.models.CLI;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.UserType;

public class Login implements Command {
    private static final int NECESSARY_ARGUMENTS = 2;

    private final CLI cli;

    public Login(CLI cli){
        this.cli = cli;
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
        if(this.cli.getCurrentUserType() != UserType.COMMON){
            error = Error.USER_LOGGED_IN;
        } else {
            error = this.cli.updateUser(arguments);
        }

        return error;
    }
}
