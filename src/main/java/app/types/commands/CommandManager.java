package app.types.commands;

import app.controllers.ExecutionController;
import app.models.system.SportManagementSystem;
import app.types.Error;
import app.types.commands.admin.*;
import app.types.commands.common.*;
import app.types.commands.player.StatisticsShow;
import app.types.commands.player.TournamentAdd;
import app.types.commands.player.TournamentRemove;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commands;

    public CommandManager(SportManagementSystem sportManagementSystem) {
        ExecutionController executionController = new ExecutionController(sportManagementSystem);
        this.commands = new HashMap<>();

        this.commands.put("player_create",new PlayerCreate(executionController));
        this.commands.put("team_create",new TeamCreate(executionController));
        this.commands.put("player_delete",new PlayerDelete(executionController));
        this.commands.put("team_delete",new TeamDelete(executionController));
        this.commands.put("team_add",new TeamAdd(executionController));
        this.commands.put("team_remove",new TeamRemove(executionController));
        this.commands.put("tournament_create",new TournamentCreate(executionController));
        this.commands.put("tournament_delete",new TournamentDelete(executionController));
        this.commands.put("tournament_matchmaking",new TournamentMatchmaking(executionController));
        this.commands.put("login",new Login(executionController));
        this.commands.put("logout",new Logout(executionController));
        this.commands.put("statistics_show",new StatisticsShow(executionController));
        this.commands.put("tournament_add",new TournamentAdd(executionController));
        this.commands.put("tournament_remove",new TournamentRemove(executionController));
        this.commands.put("tournament_list", new TournamentListCommand(executionController));
        this.commands.put("save",new SaveSession(executionController));
        this.commands.put("recover", new RecoverSession(executionController));
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
