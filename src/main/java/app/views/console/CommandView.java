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

    public void test(){
        String[] input = new String[]{"login", "sudo;sudopassword"};
        this.test(input);
        input = new String[]{"login", "arrobapaco;asd"};
        this.test(input);
        input = new String[]{"player_create", "arrobapaco;asd;paco;jones;12345678"};
        this.test(input);
        input  = new String[]{"player_create", "arrobajuana;asd;juana;juanita;15642398"};
        this.test(input);
        input  = new String[]{"player_create", "arrobajuana;asd;juana;juanita;98452675"};
        this.test(input);
        input  = new String[]{"team_create", "tiza;arrobapaco"};
        this.test(input);
        input  = new String[]{"team_create", "tiza;arrobapaco;arrobajuana"};
        this.test(input);
        input  = new String[]{"tournament_create", "flipo;furvo;champios"};
        this.test(input);
        input  = new String[]{"tournament_create", "flipo;furvo;champios;2024-05-25;2024-05-30;score"};
        this.test(input);
        input = new String[]{"logout", "sudo;asd"};
        this.test(input);
        input = new String[]{"logout", "sudo;asd"};
        this.test(input);
        input = new String[]{"login", "arrobapaco;asds"};
        this.test(input);
        input = new String[]{"login", "arrobapaco;asd"};
        this.test(input);
        input = new String[]{"tournament_add", "flipo;tiza"};
        this.test(input);
        input = new String[]{"tournament_list", ""};
        this.test(input);
        input = new String[]{"logout", "sudo;asd"};
        this.test(input);
        input = new String[]{"login", "sudo;sudopassword"};
        this.test(input);
        input  = new String[]{"tournament_create", "pepilleria;furvo;champios;2024-05-25;2024-12-30;score"};
        this.test(input);
        input = new String[]{"logout", "sudo;asd"};
        this.test(input);
        input = new String[]{"login", "arrobapaco;asd"};
        this.test(input);
        input = new String[]{"tournament_add", "pepilleria"};
        this.test(input);




    }

    private void test(String[] input){
        Command command = this.getCommand(input);
        String arguments = this.getArguments(input);
        Error error = this.getCommandError(command);
        if (error.isNull()){
            this.execute(command, arguments);
        }
    }
}
