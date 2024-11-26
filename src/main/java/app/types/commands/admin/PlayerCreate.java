package app.types.commands.admin;

import app.models.CLI;
import app.models.lists.elements.SinglePlayer;
import app.types.commands.Command;
import app.types.Error;
import app.types.users.Admin;
import app.types.users.UserType;

public class PlayerCreate implements Command {
    private static final int NECESSARY_ARGUMENTS = 4;

    private final CLI cli;

    public PlayerCreate(CLI cli){
        this.cli = cli;
    }

    public Error execute(String[] arguments){
        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            error = this.playerCreate(arguments);
        }

        return error;
    }

    private Error playerCreate(String[] arguments){
        Error error;
        if(this.cli.getCurrentUserType() == UserType.ADMIN){
            Admin admin = (Admin) this.cli.getCurrentUser();
            SinglePlayer player = this.makePlayer(arguments,admin);
            error = this.cli.playerCreate(player);
        } else {
            error = Error.NOT_ADMIN;
        }

        return error;
    }

    private SinglePlayer makePlayer(String[] arguments, Admin admin){
        final int USER_NAME = 0;
        final int PASSWORD = 1;
        final int NAME = 2;
        final int LAST_NAME = 3;

        return new SinglePlayer(arguments[USER_NAME], arguments[PASSWORD], arguments[NAME], arguments[LAST_NAME], admin);
    }


}
