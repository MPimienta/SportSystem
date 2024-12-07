package app.types.commands.admin;

import app.controllers.ExecutionController;
import app.types.Error;
import app.types.commands.Command;

public class TeamCreate implements Command {
    private static final int NECESSARY_ARGUMENTS = 3;

    private final ExecutionController controller;

    public TeamCreate(ExecutionController executionController){
        this.controller = executionController;

    }

    public Error execute(String[] arguments){
        Error error;

        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            error = controller.createTeam(arguments);
        }

        return error;
    }

}
