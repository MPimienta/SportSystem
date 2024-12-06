package app.types.commands.common;

import app.controllers.ExecutionController;
import app.types.Error;
import app.types.commands.Command;

public class Login implements Command {
    private static final int NECESSARY_ARGUMENTS = 2;

    private final ExecutionController controller;

    public Login(ExecutionController executionController){
        this.controller = executionController;

    }

    public Error execute(String[] arguments) {

        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            error = this.controller.login(arguments);
        }

        return error;
    }


}
