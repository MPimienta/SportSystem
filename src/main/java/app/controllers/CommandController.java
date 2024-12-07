package app.controllers;

import app.models.system.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;
import app.types.commands.CommandManager;

public class CommandController extends Controller{
    private final CommandManager commandManager;

    public CommandController(SportManagementSystem sportManagementSystem){
        super(sportManagementSystem);
        this.commandManager = new CommandManager(sportManagementSystem);

    }

    public Error getCommandError(Command command){
        return this.commandManager.getCommandError(command);
    }

    public Error executeCommand(Command command, String arguments){
        return command.execute(arguments.split(";"));
    }

    public Command getCommand(String commandName){
        return this.commandManager.getCommand(commandName);
    }
}
