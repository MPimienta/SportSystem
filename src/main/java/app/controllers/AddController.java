package app.controllers;

import app.models.SportManagementSystem;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Team;
import app.types.Error;

public class AddController {
    private final SportManagementSystem sportManagementSystem;

    public AddController(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error teamAdd(String[] arguments){
        final int TEAM_NAME = 0;
        final int PLAYER_NAME = 1;

        SinglePlayer player = this.sportManagementSystem.getPlayerByIdentifier(arguments[PLAYER_NAME]);
        Team team = this.sportManagementSystem.getTeamByIdentifier(arguments[TEAM_NAME]);

        if(player != null && team != null){
            return this.sportManagementSystem.teamAdd(team, player);
        } else {
            return Error.ELEMENT_DOES_NOT_EXIST;
        }
    }

    public Error tournamentAddPlayer(String[] arguments){

    }

    public Error tournamentAddTeam(String[] arguments){

    }
}
