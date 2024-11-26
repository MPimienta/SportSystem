package app.views.console;

import app.controllers.ReadController;
import app.types.Error;
import app.types.commands.Command;
import app.views.Message;

public class CommandView {
    private static final int COMMAND = 0;
    private static final int ARGUMENTS = 1;

    private final ReadController readController;

    CommandView(ReadController readController) {
        this.readController = readController;
    }

    void interact() {
        this.readCommand();
    }

    void readCommand(){
        new MessageView().write(Message.INPUT_COMMAND);
        String[] input = this.getInput();
        Command command = this.getCommand(input);
        String arguments = this.getArguments(input);
        Error error = this.getCommandError(command);

        if (error.isNull()){
            this.execute(command, arguments);
        }

    }

    private String[] getInput(){
        return new UserView().getInput().split(" ");
    }

    private Command getCommand(String[] input){
        return readController.getCommand(input[COMMAND]);
    }

    private Error getCommandError(Command command) {
        Error error = this.readController.getCommandError(command);
        new ErrorView().writeln(error);
        return error;
    }

    private void execute(Command command, String arguments) {
        assert command != null && arguments != null;

        Error error = this.readController.executeCommand(command, arguments);
        new ErrorView().writeln(error);

    }


    //Todo: Put this method somewhere else (perhaps the command manager
    private String getArguments(String[] input){
        if(input.length > 1){
            return input[ARGUMENTS];
        } else {
            return "";
        }
    }
}
