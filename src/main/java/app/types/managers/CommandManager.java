package app.types.managers;

import app.models.CLIApp;
import app.types.Error;
import app.types.commands.Command;
import app.types.commands.common.Login;
import app.types.commands.common.Logout;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandManager {
    private final Map<String, Command> commands;

    public CommandManager(CLIApp cliApp) {
        this.commands = new HashMap<>();

        this.getCommandList().put("login",new Login(cliApp));
        this.getCommandList().put("logout",new Logout(cliApp));
    }

    public Command getCommand(String input) {
        return this.commands.get(input);
    }

    protected Map<String, Command> getCommandList(){
        return this.commands;
    }
}
