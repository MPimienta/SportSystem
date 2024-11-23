package app.types;

import app.controllers.ExecuteController;
import app.types.commands.Command;
import app.types.commands.NotACommand;
import app.types.commands.admin.PlayerCreate;
import app.types.commands.admin.PlayerDelete;
import app.types.commands.admin.TeamCreate;
import app.types.commands.admin.TeamDelete;
import app.types.commands.admin.TeamAdd;
import app.types.commands.admin.TeamRemove;
import app.types.commands.admin.TournamentCreate;
import app.types.commands.admin.TournamentDelete;
import app.types.commands.admin.TournamentMatchmaking;

import java.util.HashMap;
import java.util.Map;

public enum CommandManager {
    PLAYER_CREATE("player_create",new PlayerCreate()),
    TEAM_CREATE("team_create",new TeamCreate()),
    PLAYER_DELETE("player_delete",new PlayerDelete()),
    TEAM_DELETE("team_delete",new TeamDelete()),
    TEAM_ADD("team_add",new TeamAdd()),
    TEAM_REMOVE("team_remove",new TeamRemove()),
    TOURNAMENT_CREATE("tournament_create",new TournamentCreate()),
    TOURNAMENT_REMOVE("tournament_delete",new TournamentDelete()),
    TOURNAMENT_MATCHMAKING("tournament_matchmaking",new TournamentMatchmaking()),
    NOT_A_COMMAND("not_a_command",new NotACommand())
    ;

    private final String commandName;
    private final Command executor;

    private static final Map<String, CommandManager> COMMANDS_MAP = new HashMap<>();

    static {
        for (CommandManager cmd : CommandManager.values()) {
            COMMANDS_MAP.put(cmd.getCommandName(), cmd);
        }
    }

    CommandManager(String commandName, Command executor) {
        this.commandName = commandName;
        this.executor = executor;
    }

    public static CommandManager getCommand(String input) {
        CommandManager commandManager = COMMANDS_MAP.get(input);
        if (commandManager == null) {
            commandManager = COMMANDS_MAP.get("not_a_command");
        }
        return commandManager;
    }

    public String getCommandName(){
        return this.commandName;
    }

    public Error getCommandError(){
        Error error;

        if(this.commandName.equals(NOT_A_COMMAND.getCommandName())){
            error = Error.INVALID_COMMAND;
        } else {
            error = Error.NULL;
        }

        return error;
    }

    public Error execute(String arguments, ExecuteController executeController){
        return this.executor.execute(arguments.split(";"), executeController);
    }
}
