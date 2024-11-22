package app.views.console;

import app.controllers.CommandController;
import app.views.Message;

public class ReadView {

    private CommandController commandController;

    ReadView(CommandController commandController) {
        this.commandController = commandController;
    }

    void interact() {
        new MessageView().writeln(Message.INPUT_COMMAND);
        new CommandView(this.commandController).interact();
    }
}
