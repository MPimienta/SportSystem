package app.types.commands.admin;

import app.controllers.ExecutionController;
import app.models.SportManagementSystem;
import app.types.commands.Command;
import app.types.Error;

public class PlayerDelete implements Command {
    private static final int NECESSARY_ARGUMENTS = 1;

    private final SportManagementSystem sportManagementSystem;

    public PlayerDelete(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error execute(String[] arguments){
        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            ExecutionController controller = new ExecutionController(this.sportManagementSystem);
            error = controller.deletePlayer(arguments);
        }
        return error;
    }
}
