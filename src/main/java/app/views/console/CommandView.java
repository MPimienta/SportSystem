package app.views.console;

import app.controllers.CommandController;
import app.types.Error;
import app.types.commands.Command;
import app.views.Message;

public class CommandView {
    private static final int COMMAND = 0;
    private static final int ARGUMENTS = 1;

    private final CommandController commandController;

    CommandView(CommandController commandController) {
        this.commandController = commandController;
    }

    void interact() {
        String[] input =  this.readCommand();
        Command command = this.getCommand(input);
        String arguments = this.getArguments(input);
        Error error = this.getCommandError(command);

        if (error.isNull()){
            this.execute(command, arguments);
        }
    }

    private String[] readCommand(){
        new MessageView().write(Message.INPUT_COMMAND);
        return this.getInput();
    }

    private String[] getInput(){
        return new UserView().getInput().split(" ");
    }

    private Command getCommand(String[] input){
        return commandController.getCommand(input[COMMAND]);
    }

    private Error getCommandError(Command command) {
        Error error = this.commandController.getCommandError(command);
        new ErrorView().writeln(error);
        return error;
    }

    private void execute(Command command, String arguments) {
        assert command != null && arguments != null;

        Error error = this.commandController.executeCommand(command, arguments);
        new ErrorView().writeln(error);
    }

    private String getArguments(String[] input){
        if(input.length > 1){
            return input[ARGUMENTS];
        } else {
            return "";
        }
    }
}
