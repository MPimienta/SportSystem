package app.types.commands.admin;

import app.controllers.ExecuteController;
import app.types.Error;
import app.types.commands.Command;

public class TeamDelete implements Command {

    public Error execute(String[] arguments, ExecuteController executeController) {
        return Error.NULL;
    }
}
