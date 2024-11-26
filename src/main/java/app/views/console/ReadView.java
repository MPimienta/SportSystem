package app.views.console;

import app.controllers.CommandController;

public class ReadView {

    private CommandController commandController;

    ReadView(CommandController commandController) {
        this.commandController = commandController;
    }

    void interact() {
        new CommandView(this.commandController).interact();
    }
}
