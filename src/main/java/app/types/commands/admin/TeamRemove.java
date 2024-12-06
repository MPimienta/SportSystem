package app.types.commands.admin;

import app.controllers.ExecutionController;
import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;

public class TeamRemove implements Command {
    private static final int NECESSARY_ARGUMENTS = 2;

    private final ExecutionController controller;

    public TeamRemove(ExecutionController executionController){
        this.controller = executionController;

    }

    public Error execute(String[] arguments){
        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            error = controller.teamRemove(arguments);
        }

        return error;
    }
}
