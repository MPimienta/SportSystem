package app.controllers;

import app.models.SportManagementSystem;

public abstract class Controller {
    protected SportManagementSystem sportManagementSystem;

    Controller(SportManagementSystem sportManagementSystem) {
        this.sportManagementSystem = sportManagementSystem;
    }
}
