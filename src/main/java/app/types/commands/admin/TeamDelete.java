package app.types.commands.admin;

import app.models.CLIApp;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.UserType;

public class TeamDelete implements Command {
    private static final int NECESSARY_ARGUMENTS = 1;

    private final CLIApp cliApp;

    public TeamDelete(CLIApp cliApp){
        this.cliApp = cliApp;
    }

    public Error execute(String[] arguments){
        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            error = this.cliApp.deleteTeam(arguments[0]);
        }

        return error;
    }
}
