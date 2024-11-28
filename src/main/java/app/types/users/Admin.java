package app.types.users;

import app.models.CLIApp;
import app.types.Error;
import app.types.commands.Command;
import app.types.managers.AdminCommandManager;
import app.types.managers.CommandManager;

public class Admin implements User{
    private final UserType userType;
    private final String userName;
    private final String password;
    private final CommandManager commandManager;

    public Admin(String userName, String password, CLIApp cliApp){
        this.userType = UserType.ADMIN;
        this.userName = userName;
        this.password = password;
        this.commandManager = new AdminCommandManager(cliApp);
    }

    public UserType getUserType(){
        return this.userType;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String toString(){
        return ("user_name: " + this.userName + "\npassword: " + this.password + "\nrole: admin");
    }

    @Override
    public String getIdentifier() {
        return this.getUserName();
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
}
