package app.types.managers;

import app.models.SportManagementSystem;
import app.types.commands.common.CommonTournamentList;

public class CommonCommandManager extends CommandManager{
    public CommonCommandManager(SportManagementSystem sportManagementSystem) {
        super(sportManagementSystem);

        this.getCommandList().put("tournament_list", new CommonTournamentList(sportManagementSystem));
    }
}
