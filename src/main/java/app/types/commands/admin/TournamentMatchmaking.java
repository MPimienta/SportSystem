package app.types.commands.admin;

import app.controllers.ExecutionController;
import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;

public class TournamentMatchmaking implements Command {
    private static final int DIFFERENTIATOR = 1;

    private final SportManagementSystem sportManagementSystem;

    public TournamentMatchmaking(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error execute(String[] arguments){
        Error error;
        final int NECESSARY_ARGUMENTS;

        if(arguments[DIFFERENTIATOR].equals("-m")){
            NECESSARY_ARGUMENTS = 4;
        } else {
            NECESSARY_ARGUMENTS = 2;
        }

        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            ExecutionController controller = new ExecutionController(this.sportManagementSystem);
            error = controller.tournamentMatchmaking(arguments);
        }

        return error;
    }
}
