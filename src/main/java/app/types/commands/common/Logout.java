package app.types.commands.common;

import app.controllers.ExecuteController;
import app.types.Error;
import app.types.commands.Command;

public class Logout implements Command {

    public Error execute(String[] arguments, ExecuteController executeController) {
        return executeController.logout(arguments);
    }
}
