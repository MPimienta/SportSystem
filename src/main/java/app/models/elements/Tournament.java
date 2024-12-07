package app.models.elements;

import app.models.elements.users.Player;
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
    private final int currentStatistic;

    public Tournament(String[] arguments, LocalDate[] dates, int currentStatistic){
        this.playerList = new PlayerList();
        this.matchList = new MatchList();
        this.name = arguments[NAME];
        this.sport = arguments[SPORT];
        this.league = arguments[LEAGUE];
        this.dates = dates;
        this.currentStatistic = currentStatistic;
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

    public Error removePlayer(String player){
        return this.playerList.removeElement(player);
    }

    public boolean hasPlayer(String identifier){
        if(this.playerList.getElementByIdentifier(identifier) != null){
            return true;
        } else {
            return false;
        }
    }

    public boolean isOngoing(){
        LocalDate currentDate = LocalDate.now();
        if(currentDate.isBefore(this.dates[END_DATE]) && currentDate.isAfter(this.dates[START_DATE])){
            return true;
        } else {
            return false;
        }
    }

    public boolean hasEnded(){
        LocalDate currentDate = LocalDate.now();
        if(currentDate.isAfter(this.dates[END_DATE])){
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return "Tournament: " + this.name + "\n" + (this.playerList).toString() + "\n";
    }

    public String rankedToString(){
        Player[] ranking = this.rankPlayers(currentStatistic);
        String result = "Tournament: " + this.name + "\n";
        for (int i = 0; i < this.playerList.getSize(); i++) {
            result = result + ranking[i].toString() + "\n";
        }
        return result;
    }

    private Player[] rankPlayers(int currentStatistic){
        Player[] ranking = new Player[this.playerList.getSize()];
        for (int i = 0; i < this.playerList.getSize(); i++) {
            ranking[i] = (Player) this.playerList.getElement(i);
        }

        this.sort(ranking, currentStatistic);

        return ranking;
    }

    private void sort(Player[] ranking, int currentStatistic){
        for (int i=1; i < ranking.length; i++) {
            Player aux = ranking[i];
            int j = i;
            while (j > 0 && ranking[j-1].getStatistic(currentStatistic) < aux.getStatistic(currentStatistic)){
                ranking[j] = ranking[j-1];
                j--;
            }
            ranking[j]=aux;
        }
    }
}
