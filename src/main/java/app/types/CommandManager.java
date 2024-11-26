package app.types;

import app.models.CLI;
import app.types.commands.Command;
import app.types.commands.admin.PlayerCreate;
import app.types.commands.admin.PlayerDelete;
import app.types.commands.admin.TeamCreate;
import app.types.commands.admin.TeamDelete;
import app.types.commands.admin.TeamAdd;
import app.types.commands.admin.TeamRemove;
import app.types.commands.admin.TournamentCreate;
import app.types.commands.admin.TournamentDelete;
import app.types.commands.admin.TournamentMatchmaking;
import app.types.commands.common.Login;
import app.types.commands.common.Logout;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private Map<String, Command> commands;
    private final CLI cli;

    public CommandManager(CLI cli) {
        this.cli = cli;
        this.commands = new HashMap<>();

        this.commands.put("player_create",new PlayerCreate(cli));
        this.commands.put("team_create",new TeamCreate(cli));
        this.commands.put("player_delete",new PlayerDelete(cli));
        this.commands.put("team_delete",new TeamDelete(cli));
        this.commands.put("team_add",new TeamAdd(cli));
        this.commands.put("team_remove",new TeamRemove(cli));
        this.commands.put("tournament_create",new TournamentCreate(cli));
        this.commands.put("tournament_delete",new TournamentDelete(cli));
        this.commands.put("tournament_matchmaking",new TournamentMatchmaking(cli));
        this.commands.put("login",new Login(cli));
        this.commands.put("logout",new Logout(cli));
    }

    public Command getCommand(String input) {
        return this.commands.get(input);
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
