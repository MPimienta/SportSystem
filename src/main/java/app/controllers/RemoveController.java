package app.controllers;

import app.models.SportManagementSystem;
import app.models.lists.elements.Team;
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

    }

    public Error tournamentRemoveTeam(String[] arguments){

    }


}
