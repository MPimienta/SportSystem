package app;

import app.controllers.ExecuteController;
import app.controllers.ReadController;
import app.models.CLI;
import app.views.View;
import app.views.console.ConsoleView;

public class SportSystem {
    private final CLI cli;
    private final View view;
    private final ReadController readController;


    private SportSystem(){
        this.cli = new CLI();
        this.readController = new ReadController(this.cli);
        this.view = new ConsoleView(this.readController);
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
