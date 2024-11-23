package app.views;

import app.controllers.ReadController;

public abstract class View {
    protected ReadController readController;

    public View(ReadController readController){
        this.readController = readController;
    }

    public abstract void read();
}
