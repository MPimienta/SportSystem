package app.controllers;

import app.models.CLI;

public abstract class Controller {
    protected CLI cli;

    Controller(CLI cli) {
        this.cli = cli;
    }
}
