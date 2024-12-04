package app.types.commands.player;

import app.controllers.ExecutionController;
import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;
import app.types.commands.admin.PlayerCreate;

public class PlayerTournamentList implements Command {
    private final SportManagementSystem sportManagementSystem;

    public PlayerTournamentList(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }
    public Error execute(String[] arguments) {
        ExecutionController executionController = new ExecutionController(sportManagementSystem);
        executionController.playerTournamentList();
        return Error.NULL;
    }
}
