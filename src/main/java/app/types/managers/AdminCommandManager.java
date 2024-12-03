package app.types.managers;

import app.models.SportManagementSystem;
import app.types.commands.admin.*;

public class AdminCommandManager extends CommandManager{

    public AdminCommandManager(SportManagementSystem sportManagementSystem){
        super(sportManagementSystem);

        this.getCommandList().put("player_create",new PlayerCreate(sportManagementSystem));
        this.getCommandList().put("team_create",new TeamCreate(sportManagementSystem));
        this.getCommandList().put("player_delete",new PlayerDelete(sportManagementSystem));
        this.getCommandList().put("team_delete",new TeamDelete(sportManagementSystem));
        this.getCommandList().put("team_add",new TeamAdd(sportManagementSystem));
        this.getCommandList().put("team_remove",new TeamRemove(sportManagementSystem));
        this.getCommandList().put("tournament_create",new TournamentCreate(sportManagementSystem));
        this.getCommandList().put("tournament_delete",new TournamentDelete(sportManagementSystem));
        this.getCommandList().put("tournament_matchmaking",new TournamentMatchmaking(sportManagementSystem));
    }

    public void putCommands(){

    }

}
