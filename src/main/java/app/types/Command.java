package app.types;

import app.types.commands.CommandExecutor;
import app.types.commands.admin.PlayerCreate;

import java.util.HashMap;
import java.util.Map;

public enum Command {
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

    private String commandName;
    private CommandExecutor executor;

    private static final Map<String, Command> COMMANDS_MAP = new HashMap<>();

    static {
        for (Command cmd : Command.values()) {
            COMMANDS_MAP.put(cmd.getCommandName(), cmd);
        }
    }

    Command(String commandName, CommandExecutor executor) {
        this.commandName = commandName;
        this.executor = executor;
    }

    public static Command getCommand(String name) {
        Command command = COMMANDS_MAP.get(name);
        if (command == null) {
            command = COMMANDS_MAP.get("not_a_command");
        }
        return command;
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

    public void execute(){
        this.executor.execute();
    }
}
