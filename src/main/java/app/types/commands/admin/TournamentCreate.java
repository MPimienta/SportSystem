package app.types.commands.admin;

import app.controllers.ExecutionController;
import app.models.CLIApp;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Tournament;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.Admin;
import app.types.users.UserType;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TournamentCreate implements Command {
    private static final int NECESSARY_ARGUMENTS = 5;

    private final CLIApp cliApp;

    public TournamentCreate(CLIApp cliApp){
        this.cliApp = cliApp;
    }

    public Error execute(String[] arguments){
        Error error;

        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            ExecutionController controller = new ExecutionController(this.cliApp);
            error = controller.createTournament(arguments);
        }

        return error;
    }
}
