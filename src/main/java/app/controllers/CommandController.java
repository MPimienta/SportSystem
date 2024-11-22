package app.controllers;

import app.models.CLI;
import app.types.Command;
import app.types.Error;

public class CommandController extends Controller{
    public CommandController(CLI cli){
        super(cli);
    }

    public void executeCommand(Command command){
        command.execute();
    }

    public Error getCommandError(Command command){
        return command.getCommandError();
    }
}
