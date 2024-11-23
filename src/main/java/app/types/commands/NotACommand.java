package app.types.commands;

import app.controllers.ExecuteController;
import app.types.Error;

public class NotACommand implements Command {

    public Error execute(String[] arguments, ExecuteController executeController) {
        return Error.NULL;
    }
}
