package app.types.commands.admin;

import app.models.CLI;
import app.types.Error;
import app.types.commands.Command;

public class TeamRemove implements Command {

    private final CLI cli;

    public TeamRemove(CLI cli){
        this.cli = cli;
    }

    public Error execute(String[] arguments) {
        return Error.NULL;
    }
}
