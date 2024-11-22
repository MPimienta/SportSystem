package app;

import app.controllers.CommandController;
import app.models.CLI;
import app.views.View;
import app.views.console.ConsoleView;

public class SportSystem {
    private CLI cli;
    private View view;
    private CommandController commandController;

    private SportSystem(){
        this.cli = new CLI();
        this.commandController = new CommandController(this.cli);
        this.view = new ConsoleView(this.commandController);
    }

    private void play() {
        do {
            this.view.read();
        } while (true);
    }

    public static void main(String[] args) {
        new SportSystem().play();
    }
}
