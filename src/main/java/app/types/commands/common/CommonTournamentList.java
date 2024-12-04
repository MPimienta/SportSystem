package app.types.commands.common;

import app.controllers.ExecutionController;
import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;

public class CommonTournamentList implements Command {
    private final SportManagementSystem sportManagementSystem;

    public CommonTournamentList(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }
    public Error execute(String[] arguments) {
        ExecutionController executionController = new ExecutionController(sportManagementSystem);
        executionController.commonTournamentList();
        return Error.NULL;
    }
}