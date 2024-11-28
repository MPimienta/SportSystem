package app.types.managers;

import app.models.CLIApp;
import app.types.commands.admin.*;

public class AdminCommandManager extends CommandManager{

    public AdminCommandManager(CLIApp cliApp){
        super(cliApp);

        this.getCommandList().put("player_create",new PlayerCreate(cliApp));
        this.getCommandList().put("team_create",new TeamCreate(cliApp));
        this.getCommandList().put("player_delete",new PlayerDelete(cliApp));
        this.getCommandList().put("team_delete",new TeamDelete(cliApp));
        this.getCommandList().put("team_add",new TeamAdd(cliApp));
        this.getCommandList().put("team_remove",new TeamRemove(cliApp));
        this.getCommandList().put("tournament_create",new TournamentCreate(cliApp));
        this.getCommandList().put("tournament_delete",new TournamentDelete(cliApp));
        this.getCommandList().put("tournament_matchmaking",new TournamentMatchmaking(cliApp));
    }

}
