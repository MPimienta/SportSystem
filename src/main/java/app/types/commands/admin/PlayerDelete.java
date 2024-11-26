package app.types.commands.admin;

import app.models.CLIApp;
import app.types.commands.Command;
import app.types.Error;

public class PlayerDelete implements Command {

    private final CLIApp cliApp;

    public PlayerDelete(CLIApp cliApp){
        this.cliApp = cliApp;
    }

    public Error execute(String[] arguments) {
        return Error.NULL;
    }
}
