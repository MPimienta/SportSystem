package app.controllers;

import app.models.CLI;
import app.types.Error;

public class ExecuteController extends Controller{

    public ExecuteController(CLI cli){
        super(cli);
    }

    public Error playerCreate(String[] arguments){
        return this.cli.playerCreate(arguments);
    }


}
