package app.views.console;

import app.controllers.CommandController;
import app.types.Command;
import app.types.Error;

public class CommandView {
    private CommandController commandController;

    CommandView(CommandController commandController) {
        this.commandController = commandController;
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
        this.commandController.executeCommand(command);
    }

    private Error getCommandError(Command command) {
        assert command != null;

        Error error = this.commandController.getCommandError(command);
        new ErrorView().writeln(error);
        return error;
    }

    private Command getCommand(){
        return Command.getCommand(new UserView().getInput());
    }
}
