package app.types.commands.admin;

import app.controllers.ExecutionController;
import app.types.commands.Command;
import app.types.Error;

public class PlayerCreate implements Command {
    private static final int NECESSARY_ARGUMENTS = 4;

    private final ExecutionController controller;

    public PlayerCreate(ExecutionController executionController){
        this.controller = executionController;

    }

    public Error execute(String[] arguments){
        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            error = controller.createPlayer(arguments);
        }
        return error;
    }
}
