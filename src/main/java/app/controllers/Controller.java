package app.controllers;

import app.models.CommandHandler;

public abstract class Controller {
    protected CommandHandler commandHandler;

    Controller(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }
}
