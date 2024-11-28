package app.types.commands.admin;

import app.controllers.ExecutionController;
import app.models.CLIApp;
import app.models.lists.elements.Team;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.Admin;

public class TeamCreate implements Command {
    private static final int NECESSARY_ARGUMENTS = 2;

    private final CLIApp cliApp;

    public TeamCreate(CLIApp cliApp){
        this.cliApp = cliApp;
    }

    public Error execute(String[] arguments){
        Error error;

        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            ExecutionController controller = new ExecutionController(this.cliApp);
            error = controller.createTeam(arguments);
        }

        return error;
    }

}
