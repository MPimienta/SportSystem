package app.types.commands.player;

import app.controllers.ExecutionController;
import app.types.Error;
import app.types.commands.Command;

public class TournamentRemove implements Command {
    private final static int NECESSARY_ARGUMENTS = 1;

    private final ExecutionController controller;

    public TournamentRemove(ExecutionController executionController){
        this.controller = executionController;

    }

    public Error execute(String[] arguments){
        Error error;

        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            if(arguments.length == 1){
                error = controller.tournamentRemovePlayer(arguments);
            } else {
                error = controller.tournamentRemoveTeam(arguments);
            }
        }

        return error;
    }
}
