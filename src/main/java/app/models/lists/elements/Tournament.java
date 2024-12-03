package app.models.lists.elements;

import app.models.lists.MatchList;
import java.time.LocalDate;

import app.models.lists.PlayerList;
import app.types.Error;

public class Tournament implements Element {
    private static final int NAME = 0;
    private static final int SPORT = 1;
    private static final int LEAGUE = 2;

    private static final int START_DATE = 0;
    private static final int END_DATE = 1;

    private final MatchList matchList;
    private final PlayerList playerList;
    private final String name;
    private final String sport;
    private final LocalDate[] dates;
    private final String league;

    public Tournament(String[] arguments, LocalDate[] dates){
        this.playerList = new PlayerList();
        this.matchList = new MatchList();
        this.name = arguments[NAME];
        this.sport = arguments[SPORT];
        this.league = arguments[LEAGUE];
        this.dates = dates;
    }

    public Error addPlayer(Player player){
        return this.playerList.addElement(player);
    }

    public String getIdentifier() {
        return this.name;
    }

    public Error randomMatchmake(){
        Error error = Error.NULL;

        if(this.playerList.getSize() % 2 == 1){
            error = Error.UNEVEN_AMOUNT_OF_PLAYERS;
        } else {
            this.matchList.clearMatches();
            this.matchList.randomMatchmake(this.playerList);
        }

        return error;
    }

    public Error manualMatchmake(Player[] players){
        return this.matchList.manualMatchmake(players);
    }

    public PlayerList getPlayerList(){
        return this.playerList;
    }
}
