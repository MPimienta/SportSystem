package app.types.managers;

import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;
import app.types.commands.admin.*;
import app.types.commands.common.Login;
import app.types.commands.common.Logout;
import app.types.commands.common.TournamentListCommand;
import app.types.commands.player.StatisticsShow;
import app.types.commands.player.TournamentAdd;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commands;

    public CommandManager(SportManagementSystem sportManagementSystem) {
        this.commands = new HashMap<>();

        this.commands.put("player_create",new PlayerCreate(sportManagementSystem));
        this.commands.put("team_create",new TeamCreate(sportManagementSystem));
        this.commands.put("player_delete",new PlayerDelete(sportManagementSystem));
        this.commands.put("team_delete",new TeamDelete(sportManagementSystem));
        this.commands.put("team_add",new TeamAdd(sportManagementSystem));
        this.commands.put("team_remove",new TeamRemove(sportManagementSystem));
        this.commands.put("tournament_create",new TournamentCreate(sportManagementSystem));
        this.commands.put("tournament_delete",new TournamentDelete(sportManagementSystem));
        this.commands.put("tournament_matchmaking",new TournamentMatchmaking(sportManagementSystem));
        this.commands.put("login",new Login(sportManagementSystem));
        this.commands.put("logout",new Logout(sportManagementSystem));
        this.commands.put("statistics_show",new StatisticsShow(sportManagementSystem));
        this.commands.put("tournament_add",new TournamentAdd(sportManagementSystem));
        this.commands.put("tournament_remove",new TournamentDelete(sportManagementSystem));
        this.commands.put("tournament_list", new TournamentListCommand(sportManagementSystem));
    }

    public Command getCommand(String input) {
        return this.commands.get(input);
    }

    public Error getCommandError(Command command){
        if(command == null){
            return Error.INVALID_COMMAND;
        } else {
            return Error.NULL;
        }
    }


}
