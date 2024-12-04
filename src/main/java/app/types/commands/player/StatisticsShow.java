package app.types.commands.player;

import app.controllers.ExecutionController;
import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;

public class StatisticsShow implements Command {
    private static final int NECESSARY_ARGUMENTS = 1;

    private final SportManagementSystem sportManagementSystem;

    public StatisticsShow(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error execute(String[] arguments){
        if(arguments.length < NECESSARY_ARGUMENTS){
            return Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            ExecutionController executionController = new ExecutionController(sportManagementSystem);
            return executionController.showStatistics(arguments);
        }
    }
}
