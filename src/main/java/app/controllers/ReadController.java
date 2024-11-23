package app.controllers;

import app.models.CLI;
import app.types.CommandManager;
import app.types.Error;

public class ReadController extends Controller{
    private final ExecuteController executeController;

    public ReadController(CLI cli){
        super(cli);
        this.executeController = new ExecuteController(cli);
    }

    public Error getCommandError(CommandManager commandManager){
        return commandManager.getCommandError();
    }

    public Error executeCommand(CommandManager commandManager, String arguments){
        return commandManager.execute(arguments,this.executeController);
    }
}
