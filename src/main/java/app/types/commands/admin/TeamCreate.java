package app.types.commands.admin;

import app.models.CLIApp;
import app.types.Error;
import app.types.commands.Command;

public class TeamCreate implements Command {

    private final CLIApp cliApp;

    public TeamCreate(CLIApp cliApp){
        this.cliApp = cliApp;
    }

    public Error execute(String[] arguments) {
        return Error.NULL;
    }
}
