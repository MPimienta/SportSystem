package app.views.console;

import app.controllers.ReadController;
import app.views.View;

public class ConsoleView extends View {
    private ReadView readView;

    public ConsoleView(ReadController readController){
        super(readController);
        this.readView = new ReadView(this.readController);
    }

    @Override
    public void read() {
        this.readView.interact();
    }

}
