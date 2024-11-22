package app.views.console;

import app.types.Command;
import utils.Console;

public class CommandView {

    public String getInput(){
        return Console.getInstance().readString();
    }
}
