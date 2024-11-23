package app.types.commands.common;

import app.controllers.ExecuteController;
import app.types.Error;
import app.types.commands.Command;

public class Login implements Command {
    private static final int NECESSARY_ARGUMENTS = 2;

    public Error execute(String[] arguments, ExecuteController executeController) {

        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            error = executeController.login(arguments);
        }

        return error;
    }
}
