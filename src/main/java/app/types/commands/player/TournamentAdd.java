package app.types.commands.player;

import app.controllers.ExecutionController;
import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;

public class TournamentAdd implements Command {
    private final static int NECESSARY_ARGUMENTS = 1;

    private final SportManagementSystem sportManagementSystem;

    public TournamentAdd(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error execute(String[] arguments){
        Error error;

        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            ExecutionController controller = new ExecutionController(this.sportManagementSystem);
            if(arguments.length == 1){
                error = controller.tournamentAddPlayer(arguments);
            } else {
                error = controller.tournamentAddTeam(arguments);
            }
        }

        return error;
    }
}
