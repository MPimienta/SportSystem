package app.controllers.execution;

import app.models.system.FileHandler;
import app.models.system.SportManagementSystem;
import app.types.Error;
import app.types.UserType;

public class PublicController {
    private final SportManagementSystem sportManagementSystem;

    public PublicController(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
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

    public Error login(String[] arguments){

        Error error;
        if(this.sportManagementSystem.getCurrentUserType() != UserType.COMMON){
            error = Error.USER_LOGGED_IN;
        } else {
            error = this.sportManagementSystem.updateUser(arguments);
        }

        return error;
    }

    public Error logout(){
        Error error = Error.NULL;
        if(this.sportManagementSystem.getCurrentUserType() == UserType.COMMON){
            error = Error.ALREADY_LOGGED_OUT;
        } else {
            this.sportManagementSystem.logout();
        }

        return error;
    }

    public Error saveSession(){
        return new FileHandler().saveSession(sportManagementSystem);
    }

    public Error recoverSession(){
        return new FileHandler().recoverSession(sportManagementSystem);
    }
}
