package app.controllers;

import app.models.SportManagementSystem;
import app.models.lists.elements.Player;
import app.models.lists.elements.Tournament;
import app.types.Error;

public class MatchmakingController {
    private final SportManagementSystem sportManagementSystem;

    public MatchmakingController(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error tournamentMatchmaking(String[] arguments){
        final int TOURNAMENT_NAME = 0;
        final int MATCHMAKING = 1;

        Error error = Error.NULL;
        Tournament tournament = this.sportManagementSystem.getTournamentByIdentifier(arguments[TOURNAMENT_NAME]);

        if(tournament != null){
            if(arguments[MATCHMAKING].equals("-a")){
                error = this.sportManagementSystem.randomMatchmake(tournament);
            } else if(arguments[MATCHMAKING].equals("-m")){
                error = this.manualTournamentMatchmaking(tournament, arguments);
            }
        } else {
            error = Error.ELEMENT_DOES_NOT_EXIST;
        }

        return error;
    }

    private Error manualTournamentMatchmaking(Tournament tournament, String[] arguments){
        final int PLAYER_1 = 2;
        final int PlAYER_2 = 3;

        Error error;
        String[] playerIdentifiers = new String[]{arguments[PLAYER_1], arguments[PlAYER_2]};
        Player[] players = this.getPlayers(playerIdentifiers);
        if(players[0] == null || players[1] == null){
            error = Error.ELEMENT_DOES_NOT_EXIST;
        } else {
            error = this.sportManagementSystem.manualMatchmake(tournament, players);
        }

        return error;
    }

    private Player[] getPlayers(String[] identifiers){
        Player[] players = new Player[identifiers.length];
        for (int i = 0; i < identifiers.length; i++) {
            players[i] = this.sportManagementSystem.getPlayerByIdentifier(identifiers[i]);
        }
        return players;
    }
}
