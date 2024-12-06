package app.controllers;

import app.models.SportManagementSystem;
import app.models.lists.elements.Player;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Team;
import app.models.lists.elements.Tournament;
import app.types.Error;
import app.types.users.UserType;

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
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.createController.createPlayer(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }

    }

    public Error deletePlayer(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.deleteController.deletePlayer(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error createTeam(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.createController.createTeam(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error deleteTeam(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.deleteController.deleteTeam(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error createTournament(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.createController.createTournament(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error deleteTournament(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.deleteController.deleteTournament(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error teamAdd(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.addController.teamAdd(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }


    public Error teamRemove(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.removeController.teamRemove(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error tournamentMatchmaking(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.matchmakingController.tournamentMatchmaking(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error tournamentAddPlayer(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.PLAYER){
            return this.addController.tournamentAddPlayer(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error tournamentAddTeam(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.PLAYER){
            return this.addController.tournamentAddTeam(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error tournamentRemovePlayer(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.PLAYER){
            return this.removeController.tournamentRemovePlayer(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error tournamentRemoveTeam(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.PLAYER){
            return this.removeController.tournamentRemoveTeam(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error showStatistics(String[] arguments){
        Error error = Error.NULL;

        if(this.sportManagementSystem.getCurrentUserType() == UserType.PLAYER){
            if(arguments[0].equals("-csv")){
                this.showController.showStatisticsCsv();
            } else if(arguments[0].equals("-json")){
                this.showController.showStatisticsJson();
            } else {
                error = Error.UNKNOWN_FORMAT;
            }
        } else {
            error = Error.INVALID_COMMAND;
        }

        return error;
    }

    public void tournamentList(){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.COMMON) {
            this.sportManagementSystem.showTournamentList();
        } else {
            if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
                this.sportManagementSystem.deletePastTournaments();
            }
            this.sportManagementSystem.showTournamentListRanked();
        }
    }
}
