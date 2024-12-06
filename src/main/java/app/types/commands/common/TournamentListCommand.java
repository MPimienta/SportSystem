package app.types.commands.common;

import app.controllers.ExecutionController;
import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;

public class TournamentListCommand implements Command {
    private final ExecutionController controller;

    public TournamentListCommand(ExecutionController executionController){
        this.controller = executionController;

    }
    public Error execute(String[] arguments) {
        controller.tournamentList();
        return Error.NULL;
    }
}