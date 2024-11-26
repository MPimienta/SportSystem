package app.types.commands.admin;

import app.models.CLI;
import app.types.commands.Command;
import app.types.Error;

public class PlayerDelete implements Command {

    private final CLI cli;

    public PlayerDelete(CLI cli){
        this.cli = cli;
    }

    public Error execute(String[] arguments) {
        return Error.NULL;
    }
}
