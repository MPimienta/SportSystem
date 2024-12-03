package app.controllers;

import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.User;

public class CommandController extends Controller{

    public CommandController(SportManagementSystem sportManagementSystem){
        super(sportManagementSystem);
    }

    public Error getCommandError(Command command){
        User currentUser = this.sportManagementSystem.getCurrentUser();
        return currentUser.getCommandError(command);
    }

    public Error executeCommand(Command command, String arguments){
        return command.execute(arguments.split(";"));
    }

    public Command getCommand(String commandName){
        User currentUser = this.sportManagementSystem.getCurrentUser();
        return currentUser.getCommand(commandName);
    }
}
