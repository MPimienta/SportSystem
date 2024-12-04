package app.types.commands.admin;

import app.controllers.ExecutionController;
import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;

public class AdminTournamentList implements Command {
    private final SportManagementSystem sportManagementSystem;

    public AdminTournamentList(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }
    public Error execute(String[] arguments) {
        ExecutionController executionController = new ExecutionController(sportManagementSystem);
        executionController.adminTournamentList();
        return Error.NULL;
    }
}