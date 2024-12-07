package app.controllers;

import app.controllers.execution.*;
import app.models.system.SportManagementSystem;
import app.types.Error;
import app.models.elements.users.UserType;

public class ExecutionController extends Controller {
    private final PlayerController playerController;
    private final AdminController adminController;
    private final PublicController publicController;

    public ExecutionController(SportManagementSystem sportManagementSystem) {
        super(sportManagementSystem);

        this.playerController = new PlayerController(sportManagementSystem);
        this.adminController = new AdminController(sportManagementSystem);
        this.publicController = new PublicController(sportManagementSystem);

    }

    public Error createPlayer(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.adminController.createPlayer(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }

    }

    public Error deletePlayer(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.adminController.deletePlayer(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error createTeam(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.adminController.createTeam(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error deleteTeam(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.adminController.deleteTeam(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error createTournament(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.adminController.createTournament(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error deleteTournament(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.adminController.deleteTournament(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error teamAdd(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.adminController.teamAdd(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }


    public Error teamRemove(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.adminController.teamRemove(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error tournamentMatchmaking(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.ADMIN){
            return this.adminController.tournamentMatchmaking(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error tournamentAddPlayer(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.PLAYER){
            return this.playerController.tournamentAddPlayer(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error tournamentAddTeam(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.PLAYER){
            return this.playerController.tournamentAddTeam(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error tournamentRemovePlayer(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.PLAYER){
            return this.playerController.tournamentRemovePlayer(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error tournamentRemoveTeam(String[] arguments){
        if(this.sportManagementSystem.getCurrentUserType() == UserType.PLAYER){
            return this.playerController.tournamentRemoveTeam(arguments);
        } else {
            return Error.INVALID_COMMAND;
        }
    }

    public Error showStatistics(String[] arguments){
        Error error = Error.NULL;

        if(this.sportManagementSystem.getCurrentUserType() == UserType.PLAYER){
            this.playerController.showStatistics(arguments);
        } else {
            error = Error.INVALID_COMMAND;
        }

        return error;
    }

    public void tournamentList(){
        this.publicController.tournamentList();
    }

    public Error login(String[] arguments){
        return this.publicController.login(arguments);
    }

    public Error logout(){
        return this.publicController.logout();
    }
}
