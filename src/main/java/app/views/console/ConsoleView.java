package app.views.console;

import app.controllers.ContinueController;
import app.controllers.ReadController;
import app.controllers.StartController;
import app.views.View;

public class ConsoleView extends View {
    private StartView startView;
    private ReadView readView;
    private ContinueView continueView;

    public ConsoleView(StartController startController, ReadController readController,
                       ContinueController continueController) {
        super(startController,readController,continueController);
        this.startView = new StartView(this.startController);
        this.readView = new ReadView(this.readController);
        this.continueView = new ContinueView(this.continueController);
    }

    @Override
    public void start() {
        this.startView.interact();
    }

    @Override
    public void read() {
        this.readView.interact();
    }

    @Override
    public boolean continueApp() {
        return this.continueView.interact();
    }
}
