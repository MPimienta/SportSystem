package app.views;

import app.controllers.CommandController;

public abstract class View {
    protected CommandController commandController;

    public View(CommandController commandController){
        this.commandController = commandController;
    }

    public abstract void read();
}
