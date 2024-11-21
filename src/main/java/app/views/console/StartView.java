package app.views.console;

import app.controllers.StartController;
import app.views.Message;

public class StartView {
    private StartController startController;

    StartView(StartController startController) {
        this.startController = startController;
    }

    void interact() {
        new MessageView().writeln(Message.INPUT_COMMAND);
    }
}
