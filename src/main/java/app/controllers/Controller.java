package app.controllers;

import app.models.CLIApp;

public abstract class Controller {
    protected CLIApp cliApp;

    Controller(CLIApp cliApp) {
        this.cliApp = cliApp;
    }
}
