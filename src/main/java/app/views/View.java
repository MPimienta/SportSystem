package app.views;

import app.controllers.ContinueController;
import app.controllers.ReadController;
import app.controllers.StartController;

public abstract class View {
    protected StartController startController;
    protected ReadController readController;
    protected ContinueController continueController;

    public View(StartController startController, ReadController readController, ContinueController continueController) {
        this.startController = startController;
        this.readController = readController;
        this.continueController = continueController;
    }

    public abstract void start();

    public abstract void read();

    public abstract boolean continueApp();
}
