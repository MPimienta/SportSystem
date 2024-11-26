package app.controllers;

import app.models.CLI;
import app.types.CommandManager;
import app.types.Error;
import app.types.commands.Command;

public class ReadController extends Controller{
    private final CommandManager commandManager;

    public ReadController(CLI cli){
        super(cli);
        this.commandManager = new CommandManager(cli);
    }

    public Error getCommandError(Command command){
        return commandManager.getCommandError(command);
    }

    public Error executeCommand(Command command, String arguments){
        return command.execute(arguments.split(";"));
    }

    public Command getCommand(String commandName){
        return commandManager.getCommand(commandName);
    }
}
