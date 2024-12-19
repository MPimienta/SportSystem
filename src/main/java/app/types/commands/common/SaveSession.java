package app.types.commands.common;

import app.controllers.ExecutionController;
import app.types.Error;
import app.types.commands.Command;

public class SaveSession implements Command {
    private final ExecutionController controller;

    public SaveSession(ExecutionController executionController){
        this.controller = executionController;
    }

    public Error execute(String[] arguments) {
        return this.controller.saveSession();
    }
}
