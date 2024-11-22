package app.views.console;

import app.controllers.ReadController;
import app.views.Message;

public class ReadView {

    private ReadController readController;

    ReadView(ReadController readController) {
        this.readController = readController;
    }

    void interact() {
        new MessageView().writeln(Message.INPUT_COMMAND);
        new UserView(this.readController).interact();
    }
}
