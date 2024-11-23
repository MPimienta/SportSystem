package app.views.console;

import app.controllers.ReadController;
import app.types.CommandManager;
import app.types.Error;
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
        CommandManager commandManager = this.getCommand(input);
        String arguments = this.getArguments(input);
        Error error = this.getCommandError(commandManager);

        if (error.isNull()){
            this.execute(commandManager, arguments);
        }

    }

    private String[] getInput(){
        return new UserView().getInput().split(" ");
    }

    private CommandManager getCommand(String[] input){
        return CommandManager.getCommand(input[COMMAND]);
    }

    private Error getCommandError(CommandManager commandManager) {
        assert commandManager != null;

        Error error = this.readController.getCommandError(commandManager);
        new ErrorView().writeln(error);
        return error;
    }

    private void execute(CommandManager commandManager, String arguments) {
        assert commandManager != null && arguments != null;

        Error error = this.readController.executeCommand(commandManager, arguments);
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
