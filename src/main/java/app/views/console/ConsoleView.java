package app.views.console;

import app.controllers.CommandController;
import app.views.View;

public class ConsoleView extends View {
    private ReadView readView;

    public ConsoleView(CommandController commandController){
        super(commandController);
        this.readView = new ReadView(this.commandController);
    }

    @Override
    public void read() {
        this.readView.interact();
    }

}
