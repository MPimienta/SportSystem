package app.types.commands.player;

import app.models.SportManagementSystem;
import app.types.Error;
import app.types.commands.Command;

public class TournamentAdd implements Command {
    private final SportManagementSystem sportManagementSystem;

    public TournamentAdd(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error execute(String[] arguments){
        return null;
    }
}
