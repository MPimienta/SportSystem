package app.types.managers;

import app.models.SportManagementSystem;
import app.types.commands.admin.*;
import app.types.commands.common.TournamentList;
import app.types.commands.player.PlayerTournamentList;
import app.types.commands.player.StatisticsShow;
import app.types.commands.player.TournamentAdd;

public class PlayerCommandManager extends CommandManager {
    public PlayerCommandManager(SportManagementSystem sportManagementSystem){
        super(sportManagementSystem);

        this.getCommandList().put("statistics_show",new StatisticsShow(sportManagementSystem));
        this.getCommandList().put("tournament_add",new TournamentAdd(sportManagementSystem));
        this.getCommandList().put("tournament_remove",new TournamentDelete(sportManagementSystem));
        this.getCommandList().put("tournament_list", new PlayerTournamentList(sportManagementSystem));

    }
}
