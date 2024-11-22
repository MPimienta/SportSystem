package app.views.console;

import app.controllers.ReadController;
import app.types.Command;
import app.types.Error;

public class UserView {
    private ReadController readController;

    UserView(ReadController readController) {
        this.readController = readController;
    }

    void interact() {
        this.readCommand();
    }

    void readCommand(){
        Command command;
        Error error;
        do{
            command = this.getCommand();
            error = this.getCommandError(command);
        } while(!error.isNull());
        this.readController.executeCommand(command);
    }

    private Command getCommand(){
        return Command.getCommand(new CommandView().getInput());
    }
}
