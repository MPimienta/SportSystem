package app.types.commands;

import app.types.Error;

public interface Command {

    Error execute(String[] arguments);
}
