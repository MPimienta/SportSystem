package app.types.commands.common;

import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.UserType;

public class Login implements Command {
    private static final int NECESSARY_ARGUMENTS = 2;

    private final SportManagementSystem sportManagementSystem;

    public Login(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
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

    private Error login(String[] arguments){

        Error error = Error.NULL;
        if(this.sportManagementSystem.getCurrentUserType() != UserType.COMMON){
            error = Error.USER_LOGGED_IN;
        } else {
            error = this.sportManagementSystem.updateUser(arguments);
        }

        return error;
    }
}
