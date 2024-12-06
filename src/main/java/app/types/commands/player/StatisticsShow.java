package app.types.commands.player;

import app.controllers.ExecutionController;
import app.types.Error;
import app.types.commands.Command;

public class StatisticsShow implements Command {
    private static final int NECESSARY_ARGUMENTS = 1;

    private final ExecutionController controller;

    public StatisticsShow(ExecutionController executionController){
        this.controller = executionController;

    }

    public Error execute(String[] arguments){
        if(arguments.length < NECESSARY_ARGUMENTS){
            return Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            return controller.showStatistics(arguments);
        }
    }
}
