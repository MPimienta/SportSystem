package app.models.system;

import app.models.lists.ListOfElements;
import app.models.elements.users.Player;
import app.models.elements.users.SinglePlayer;
import app.models.elements.Team;
import app.models.elements.Tournament;
import app.types.Error;
import app.models.elements.users.User;

public class Creator {
    private static final int IDENTIFIER = 0;

    private static final int PLAYER_LIST = 0;
    private static final int USER_LIST = 1;
    private static final int TEAM_LIST = 2;
    private static final int TOURNAMENT_LIST = 3;

    private final ListOfElements[] lists;

    public Creator(ListOfElements[] lists){
        this.lists = lists;
    }

    public Error createUser(User user){
        return lists[USER_LIST].addElement(user);
    }

    public Error createPlayer(SinglePlayer player){
        return this.lists[PLAYER_LIST].addElement(player);
    }

    public Error createTeam(Team team){
        return this.lists[TEAM_LIST].addElement(team);
    }

    public Error createTournament(Tournament tournament){
        return lists[TOURNAMENT_LIST].addElement(tournament);
    }

    public Error teamAdd(Team team, SinglePlayer player){
        return team.addPlayer(player);
    }

    public Error tournamentAddPlayer(Player player, Tournament tournament){
        if (!tournament.isOngoing()){
            return tournament.addPlayer(player);
        } else {
            return Error.ONGOING_TOURNAMENT;
        }
    }
}
