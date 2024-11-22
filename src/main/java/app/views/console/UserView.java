package app.views.console;

import utils.Console;

public class UserView {

    public String getInput(){
        return Console.getInstance().readString();
    }
}
