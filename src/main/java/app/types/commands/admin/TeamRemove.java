package app.types.commands.admin;

import app.controllers.ExecutionController;
import app.models.CLIApp;
import app.types.Error;
import app.types.commands.Command;

public class TeamRemove implements Command {
    private static final int NECESSARY_ARGUMENTS = 2;

    private final CLIApp cliApp;

    public TeamRemove(CLIApp cliApp){
        this.cliApp = cliApp;
    }

    public Error execute(String[] arguments){
        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            ExecutionController controller = new ExecutionController(this.cliApp);
            error = controller.teamRemove(arguments);
        }

        return error;
    }
}
