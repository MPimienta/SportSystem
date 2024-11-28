package app.controllers;

import app.models.CLIApp;
import app.types.commands.managers.CommandManager;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.User;

public class CommandController extends Controller{

    public CommandController(CLIApp cliApp){
        super(cliApp);
    }

    public Error getCommandError(Command command){
        User currentUser = this.cliApp.getCurrentUser();
        return currentUser.getCommandError(command);
    }

    public Error executeCommand(Command command, String arguments){
        return command.execute(arguments.split(";"));
    }

    public Command getCommand(String commandName){
        User currentUser = this.cliApp.getCurrentUser();
        return currentUser.getCommand(commandName);
    }
}
