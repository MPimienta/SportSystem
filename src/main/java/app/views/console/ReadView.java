package app.views.console;

import app.controllers.ReadController;

public class ReadView {

    private ReadController readController;

    ReadView(ReadController readController) {
        this.readController = readController;
    }

    void interact() {
        new CommandView(this.readController).interact();
    }
}
