package app.views.console;

import app.views.Message;
import utils.Console;

public class PlayersView {
    public void showPlayerList(String playerList){
        new MessageView().writeln(Message.LIST_OF_PLAYERS);
        Console.getInstance().writeln(playerList);
    }
}
