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
    private final MatchmakingController matchmakingController;
    private final ShowController showController;

    public ExecutionController(SportManagementSystem sportManagementSystem) {
        super(sportManagementSystem);
        this.createController = new CreateController(sportManagementSystem);
        this.deleteController = new DeleteController(sportManagementSystem);
        this.addController = new AddController(sportManagementSystem);
        this.removeController = new RemoveController(sportManagementSystem);
        this.showController = new ShowController(sportManagementSystem);
        this.matchmakingController = new MatchmakingController(sportManagementSystem);
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
        return this.matchmakingController.tournamentMatchmaking(arguments);
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

    public Error showStatistics(String[] arguments){
        Error error = Error.NULL;
        if(arguments[0].equals("-csv")){
            this.showController.showStatisticsCsv();
        } else if(arguments[0].equals("-json")){
            this.showController.showStatisticsJson();
        } else {
            error = Error.UNKNOWN_FORMAT;
        }

        return error;
    }

    public void adminTournamentList(){

    }

    public void playerTournamentList(){

    }

    public void commonTournamentList(){
        this.sportManagementSystem.showTournamentList();
    }

}
