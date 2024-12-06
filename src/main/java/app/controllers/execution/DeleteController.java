package app.controllers.execution;

import app.models.SportManagementSystem;
import app.types.Error;

public class DeleteController {
    private final SportManagementSystem sportManagementSystem;

    public DeleteController(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error deletePlayer(String[] arguments){
        final int PLAYER_IDENTIFIER = 0;
        return this.sportManagementSystem.deletePlayer(arguments[PLAYER_IDENTIFIER]);
    }

    public Error deleteTeam(String[] arguments){
        final int PLAYER_IDENTIFIER = 0;
        return this.sportManagementSystem.deletePlayer(arguments[PLAYER_IDENTIFIER]);
    }

    public Error deleteTournament(String[] arguments){
        final int TOURNAMENT_IDENTIFIER = 0;
        return this.sportManagementSystem.deleteTournament(arguments[TOURNAMENT_IDENTIFIER]);
    }
}
