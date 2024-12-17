package app;

import app.controllers.CommandController;
import app.models.system.SportManagementSystem;
import app.views.View;
import app.views.console.ConsoleView;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class CLIApp {
    private final SportManagementSystem sportManagementSystem;
    private final View view;
    private final CommandController commandController;


    private CLIApp(){
        this.sportManagementSystem = new SportManagementSystem();
        this.commandController = new CommandController(this.sportManagementSystem);
        this.view = new ConsoleView(this.commandController);
    }

    private void play() {
        this.view.test();
        do {
            this.view.read();
        } while (true);
    }

    public static void main(String[] args) {
        new CLIApp().play();
    }
}
