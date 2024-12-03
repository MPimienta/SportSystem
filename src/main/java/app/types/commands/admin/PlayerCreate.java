package app.types.commands.admin;

import app.controllers.ExecutionController;
import app.models.SportManagementSystem;
import app.types.commands.Command;
import app.types.Error;

public class PlayerCreate implements Command {
    private static final int NECESSARY_ARGUMENTS = 4;

    private final SportManagementSystem sportManagementSystem;

    public PlayerCreate(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error execute(String[] arguments){
        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            ExecutionController controller = new ExecutionController(this.sportManagementSystem);
            error = controller.createPlayer(arguments);
        }
        return error;
    }
}
