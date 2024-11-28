package app.controllers;

import app.models.CLIApp;
import app.models.lists.elements.Player;
import app.models.lists.elements.SinglePlayer;
import app.types.Error;
import app.types.users.Admin;

public class PlayerController {
    private final CLIApp cliApp;

    public PlayerController(CLIApp cliApp){
        this.cliApp = cliApp;
    }

    private Error playerCreate(String[] arguments, Admin admin){
        final int NECESSARY_ARGUMENTS = 4;
        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            SinglePlayer player = this.makePlayer(arguments, admin);
            error = this.cliApp.createPlayer(player);
        }

        return error;
    }

    private SinglePlayer makePlayer(String[] arguments, Admin admin){
        return new SinglePlayer(arguments, admin);
    }
}
