package app.types.commands.common;

import app.controllers.ExecutionController;
import app.types.Error;
import app.types.commands.Command;

public class RecoverSession implements Command {
    private final ExecutionController controller;

    public RecoverSession(ExecutionController executionController){
        this.controller = executionController;
    }
    public Error execute(String[] arguments) {
        return this.controller.recoverSession();
    }
}
