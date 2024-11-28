package app.types.users;

import app.models.CLIApp;
import app.types.Error;
import app.types.commands.Command;
import app.types.commands.managers.AdminCommandManager;
import app.types.commands.managers.CommandManager;
import app.types.commands.managers.CommonCommandManager;

public class CommonUser implements User{
    private final UserType userType;
    private final CommandManager commandManager;

    public CommonUser(CLIApp cliApp){
        this.userType = UserType.COMMON;
        this.commandManager = new CommonCommandManager(cliApp);
    }

    public UserType getUserType(){
        return this.userType;
    }

    public String getUserName() {
        return "guest";
    }

    @Override
    public String getPassword() {
        return "null";
    }

    public Command getCommand(String input) {
        return this.commandManager.getCommand(input);
    }

    public Error getCommandError(Command command){
        Error error;

        if(command == null){
            error = Error.INVALID_COMMAND;
        } else {
            error = Error.NULL;
        }

        return error;
    }

    @Override
    public String getIdentifier() {
        return null;
    }
}
