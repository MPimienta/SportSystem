package app.views.console;

import app.models.lists.TournamentsList;
import app.models.elements.users.SinglePlayer;
import app.views.Message;
import utils.Console;

public class PlayersView {
    public void showPlayerList(String playerList){
        new MessageView().writeln(Message.LIST_OF_PLAYERS);
        Console.getInstance().writeln(playerList);
    }

    public void showStatisticsCsv(SinglePlayer player){
        new MessageView().writeln(Message.CSV_FORMAT);
        Console.getInstance().writeln(player.toCsvFormat());
    }

    public void showStatisticsJson(SinglePlayer player){
        Console.getInstance().writeln(player.toJsonFormat());
    }

    public void showTournamentList(TournamentsList tournamentsList){
        new MessageView().writeln((Message.TOURNAMENT_LIST));
        Console.getInstance().writeln(tournamentsList.toString());
    }

    public void showTournamentListRanked(String tournamentList){
        new MessageView().writeln((Message.TOURNAMENT_LIST));
        Console.getInstance().writeln(tournamentList);
    }
}
