package app.controllers;

import app.models.SportManagementSystem;
import app.models.lists.elements.Player;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Team;
import app.models.lists.elements.Tournament;
import app.types.Error;

public class ExecutionController extends Controller{
    private final CreateController createController;
    private final DeleteController deleteController;
    private final AddController addController;
    private final RemoveController removeController;

    public ExecutionController(SportManagementSystem sportManagementSystem) {
        super(sportManagementSystem);
        this.createController = new CreateController(sportManagementSystem);
        this.deleteController = new DeleteController(sportManagementSystem);
        this.addController = new AddController(sportManagementSystem);
        this.removeController = new RemoveController(sportManagementSystem);
    }

    public Error createPlayer(String[] arguments){
        return this.createController.createPlayer(arguments);
    }

    public Error deletePlayer(String[] arguments){
        return this.deleteController.deletePlayer(arguments);
    }

    public Error createTeam(String[] arguments){
        return this.createController.createTeam(arguments);
    }

    private SinglePlayer getPlayerByIdentifier(String name){
        return this.sportManagementSystem.getPlayerByIdentifier(name);
    }

    public Error deleteTeam(String[] arguments){
        return this.deleteController.deleteTeam(arguments);
    }

    public Error createTournament(String[] arguments){
        return this.createController.createTournament(arguments);
    }

    public Error deleteTournament(String[] arguments){
        return this.deleteController.deleteTournament(arguments);
    }

    public Error teamAdd(String[] arguments){
        return this.addController.teamAdd(arguments);
    }

    private Team getTeamByIdentifier(String name){
        return this.sportManagementSystem.getTeamByIdentifier(name);
    }

    public Error teamRemove(String[] arguments){
        return this.removeController.teamRemove(arguments);
    }

    public Error tournamentMatchmaking(String[] arguments){
        final int TOURNAMENT_NAME = 0;
        final int MATCHMAKING = 1;

        Error error = Error.NULL;
        Tournament tournament = this.getTournamentByIdentifier(arguments[TOURNAMENT_NAME]);

        if(tournament != null){
            if(arguments[MATCHMAKING].equals("-a")){
                error = this.sportManagementSystem.randomMatchmake(tournament);
            } else if(arguments[MATCHMAKING].equals("-m")){
                error = this.manualTournamentMatchmaking(tournament, arguments);
            }
        } else {
            error = Error.ELEMENT_DOES_NOT_EXIST;
        }

        return error;
    }

    private Error manualTournamentMatchmaking(Tournament tournament, String[] arguments){
        final int PLAYER_1 = 2;
        final int PlAYER_2 = 3;

        Error error;
        String[] playerIdentifiers = new String[]{arguments[PLAYER_1], arguments[PlAYER_2]};
        Player[] players = this.getPlayers(playerIdentifiers);
        if(players[0] == null || players[1] == null){
            error = Error.ELEMENT_DOES_NOT_EXIST;
        } else {
            error = this.sportManagementSystem.manualMatchmake(tournament, players);
        }

        return error;
    }

    private Player[] getPlayers(String[] identifiers){
        Player[] players = new Player[identifiers.length];
        for (int i = 0; i < identifiers.length; i++) {
            players[i] = this.sportManagementSystem.getPlayerByIdentifier(identifiers[i]);
        }
        return players;
    }

    private Tournament getTournamentByIdentifier(String name){
        return this.sportManagementSystem.getTournamentByIdentifier(name);
    }

    public Error tournamentAddPlayer(String[] arguments){
        return this.addController.tournamentAddPlayer(arguments);
    }

    public Error tournamentAddTeam(String[] arguments){
        return this.addController.tournamentAddTeam(arguments);
    }

    public Error tournamentRemovePlayer(String[] arguments){
        return this.removeController.tournamentRemovePlayer(arguments);
    }

    public Error tournamentRemoveTeam(String[] arguments){
        return this.removeController.tournamentRemoveTeam(arguments);
    }

}
