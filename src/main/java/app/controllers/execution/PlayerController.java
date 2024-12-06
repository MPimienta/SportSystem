package app.controllers.execution;

import app.models.SportManagementSystem;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Team;
import app.models.lists.elements.Tournament;
import app.types.Error;
import app.views.console.PlayersView;

public class PlayerController {
    private final SportManagementSystem sportManagementSystem;

    public PlayerController(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error tournamentAddPlayer(String[] arguments){
        final int TOURNAMENT = 0;

        Error error;
        SinglePlayer currentPlayer = (SinglePlayer) this.sportManagementSystem.getCurrentUser();
        Tournament tournament = this.sportManagementSystem.getTournamentByIdentifier(arguments[TOURNAMENT]);

        if (tournament == null) {
            error = Error.ELEMENT_DOES_NOT_EXIST;
        } else {
            error = this.sportManagementSystem.tournamentAddPlayer(currentPlayer, tournament);
        }
        return error;
    }

    public Error tournamentAddTeam(String[] arguments) {
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
                error = this.sportManagementSystem.tournamentAddPlayer(team, tournament);
            }
        }
        return error;
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

    public Error showStatistics(String[] arguments){
        Error error = Error.NULL;

        if(arguments[0].equals("-csv")){
            this.showStatisticsCsv();
        } else if(arguments[0].equals("-json")){
            this.showStatisticsJson();
        } else {
            error = Error.UNKNOWN_FORMAT;
        }

        return error;
    }

    private void showStatisticsCsv(){
        PlayersView playersView = new PlayersView();
        playersView.showStatisticsCsv((SinglePlayer) this.sportManagementSystem.getCurrentUser());
    }

    private void showStatisticsJson(){
        PlayersView playersView = new PlayersView();
        playersView.showStatisticsJson((SinglePlayer) this.sportManagementSystem.getCurrentUser());
    }
}
