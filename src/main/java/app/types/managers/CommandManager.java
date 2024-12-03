package app.types.managers;

import app.models.SportManagementSystem;
import app.types.commands.Command;
import app.types.commands.common.Login;
import app.types.commands.common.Logout;

import java.util.HashMap;
import java.util.Map;

public abstract class CommandManager {
    private final Map<String, Command> commands;

    public CommandManager(SportManagementSystem sportManagementSystem) {
        this.commands = new HashMap<>();

        this.getCommandList().put("login",new Login(sportManagementSystem));
        this.getCommandList().put("logout",new Logout(sportManagementSystem));
    }

    public Command getCommand(String input) {
        return this.commands.get(input);
    }

    protected Map<String, Command> getCommandList(){
        return this.commands;
    }
}
