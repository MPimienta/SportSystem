package app;

import app.controllers.CommandController;
import app.models.CLIApp;
import app.views.View;
import app.views.console.ConsoleView;

public class SportSystem {
    private final CLIApp cliApp;
    private final View view;
    private final CommandController commandController;


    private SportSystem(){
        this.cliApp = new CLIApp();
        this.commandController = new CommandController(this.cliApp);
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
