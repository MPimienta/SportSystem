package app.types.commands.common;

import app.controllers.ExecutionController;
import app.types.Error;
import app.types.commands.Command;

public class Logout implements Command {

    private final ExecutionController controller;

    public Logout(ExecutionController executionController){
        this.controller = executionController;

    }

    public Error execute(String[] arguments) {
        return this.controller.logout();
    }

}
