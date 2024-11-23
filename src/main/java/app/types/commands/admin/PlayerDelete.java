package app.types.commands.admin;

import app.controllers.ExecuteController;
import app.types.commands.Command;
import app.types.Error;

public class PlayerDelete implements Command {

    public Error execute(String[] arguments, ExecuteController executeController) {
        return Error.NULL;
    }
}
