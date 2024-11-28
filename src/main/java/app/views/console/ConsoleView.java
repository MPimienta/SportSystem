package app.views.console;

import app.controllers.CommandController;
import app.views.View;

public class ConsoleView extends View {
    private final CommandView commandView;

    public ConsoleView(CommandController commandController){
        super(commandController);
        this.commandView = new CommandView(this.commandController);
    }

    public void read() {
        this.commandView.interact();
    }

}
