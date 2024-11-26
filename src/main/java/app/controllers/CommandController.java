package app.controllers;

import app.models.CLIApp;
import app.types.CommandManager;
import app.types.Error;
import app.types.commands.Command;

public class CommandController extends Controller{
    private final CommandManager commandManager;

    public CommandController(CLIApp cliApp){
        super(cliApp);
        this.commandManager = new CommandManager(cliApp);
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
