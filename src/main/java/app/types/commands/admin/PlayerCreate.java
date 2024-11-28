package app.types.commands.admin;

import app.models.CLIApp;
import app.models.lists.elements.SinglePlayer;
import app.types.commands.Command;
import app.types.Error;
import app.types.users.Admin;

public class PlayerCreate implements Command {
    private static final int NECESSARY_ARGUMENTS = 4;

    private final CLIApp cliApp;

    public PlayerCreate(CLIApp cliApp){
        this.cliApp = cliApp;
    }

    public Error execute(String[] arguments){
        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            Admin admin = (Admin) this.cliApp.getCurrentUser();
            SinglePlayer player = this.makePlayer(arguments, admin);
            error = this.cliApp.createPlayer(player);
        }

        return error;
    }

    private SinglePlayer makePlayer(String[] arguments, Admin admin){
        return new SinglePlayer(arguments, admin);
    }


}
