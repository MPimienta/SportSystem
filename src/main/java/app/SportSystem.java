package app;

import app.controllers.ContinueController;
import app.controllers.ReadController;
import app.controllers.StartController;
import app.models.CommandHandler;
import app.views.View;

public class SportSystem {
    private CommandHandler commandHandler;
    private View view;
    private StartController startController;
    private ReadController readController;
    private ContinueController continueController;

    private SportSystem(){
        this.commandHandler = new CommandHandler();
        this.startController = new StartController(this.commandHandler);
        this.readController = new StartController(this.commandHandler);
        this.continueController = new StartController(this.commandHandler);
        this.view = new View(this.startController, this.readController, this.continueController);
    }

    private void play() {
        do {
            this.view.start();
            this.view.read();
        } while (this.view.continue());
    }

    public static void main(String[] args) {
        new SportSystem().play();
    }
}
