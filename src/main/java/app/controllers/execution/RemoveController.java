package app.controllers.execution;

import app.models.SportManagementSystem;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Team;
import app.models.lists.elements.Tournament;
import app.types.Error;

public class RemoveController {
    private final SportManagementSystem sportManagementSystem;

    public RemoveController(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error teamRemove(String[] arguments){
        final int TEAM_NAME = 0;
        final int PLAYER_NAME = 1;

        Team team = this.sportManagementSystem.getTeamByIdentifier(arguments[TEAM_NAME]);

        if(team != null){
            return this.sportManagementSystem.teamRemove(team, arguments[PLAYER_NAME]);
        } else {
            return Error.ELEMENT_DOES_NOT_EXIST;
        }
    }

    public Error tournamentRemovePlayer(String[] arguments){
        final int TOURNAMENT = 0;

        Error error;
        SinglePlayer currentPlayer = (SinglePlayer) this.sportManagementSystem.getCurrentUser();
        Tournament tournament = this.sportManagementSystem.getTournamentByIdentifier(arguments[TOURNAMENT]);

        if (tournament == null) {
            error = Error.ELEMENT_DOES_NOT_EXIST;
        } else {
            error = this.sportManagementSystem.tournamentRemovePlayer(currentPlayer, tournament);
        }
        return error;
    }

    public Error tournamentRemoveTeam(String[] arguments){
        final int TOURNAMENT = 0;
        final int TEAM = 1;

        Error error;
        SinglePlayer currentPlayer = (SinglePlayer) this.sportManagementSystem.getCurrentUser();
        Tournament tournament = this.sportManagementSystem.getTournamentByIdentifier(arguments[TOURNAMENT]);
        Team team = this.sportManagementSystem.getTeamByIdentifier(arguments[TEAM]);

        if (team == null || tournament == null) {
            error = Error.ELEMENT_DOES_NOT_EXIST;
        } else {
            if(team.hasPlayer(currentPlayer.getIdentifier())){
                error = Error.PLAYER_NOT_IN_TEAM;
            } else {
                error = this.sportManagementSystem.tournamentRemovePlayer(team, tournament);
            }
        }
        return error;
    }


}
