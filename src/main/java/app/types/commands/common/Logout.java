package app.types.commands.common;

import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.UserType;

public class Logout implements Command {

    private final SportManagementSystem sportManagementSystem;

    public Logout(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error execute(String[] arguments) {
        Error error = Error.NULL;
        if(this.sportManagementSystem.getCurrentUserType() == UserType.COMMON){
            error = Error.ALREADY_LOGGED_OUT;
        } else {
            this.sportManagementSystem.logout();
        }

        return error;
    }

}
