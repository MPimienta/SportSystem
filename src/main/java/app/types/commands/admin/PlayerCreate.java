package app.types.commands.admin;

import app.controllers.ExecuteController;
import app.types.commands.Command;
import app.types.Error;

public class PlayerCreate implements Command {
    private static final int NECESSARY_ARGUMENTS = 4;

    public Error execute(String[] arguments, ExecuteController executeController){
        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            error = executeController.playerCreate(arguments);
        }

        return error;
    }


}
