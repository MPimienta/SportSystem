package app.types.commands.common;

import app.models.CLI;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.UserType;

public class Logout implements Command {

    private final CLI cli;

    public Logout(CLI cli){
        this.cli = cli;
    }

    public Error execute(String[] arguments) {
        return this.logout(arguments);
    }

    public Error logout(String[] arguments){
        Error error = Error.NULL;
        if(this.cli.getCurrentUserType() == UserType.COMMON){
            error = Error.ALREADY_LOGGED_OUT;
        } else {
            this.cli.logout();
        }

        return error;
    }
}
