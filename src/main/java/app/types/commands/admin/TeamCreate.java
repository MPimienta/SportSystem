package app.types.commands.admin;

import app.models.CLIApp;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Team;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.Admin;
import app.types.users.UserType;

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
            Admin admin = (Admin) this.cliApp.getCurrentUser();
            Team team = this.makeTeam(arguments, admin);
            error = this.cliApp.createTeam(team, arguments[1]);
        }

        return error;
    }

    private Team makeTeam(String[] arguments, Admin admin){
        return new Team(arguments[0], admin);
    }
}
