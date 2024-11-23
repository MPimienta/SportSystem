package app.types.commands;

import app.controllers.ExecuteController;
import app.types.Error;

public interface Command {

    Error execute(String[] arguments, ExecuteController executeController);
}
