package app.controllers.execution;

import app.models.system.FileHandler;
import app.models.system.SportManagementSystem;
import app.models.elements.users.Player;
import app.models.elements.users.SinglePlayer;
import app.models.elements.Team;
import app.models.elements.Tournament;
import app.types.Category;
import app.types.Error;
import app.models.elements.users.Admin;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AdminController {
    private final SportManagementSystem sportManagementSystem;

    public AdminController(SportManagementSystem sportManagementSystem){
        this.sportManagementSystem = sportManagementSystem;
    }

    public Error createPlayer(String[] arguments){
        Error error;
        Admin admin = (Admin) this.sportManagementSystem.getCurrentUser();
        SinglePlayer player = this.makePlayer(arguments, admin);
        error = this.sportManagementSystem.createPlayer(player);
        if(error.isNull()){
            this.sportManagementSystem.createUser(player);
        }
        return error;
    }

    private SinglePlayer makePlayer(String[] arguments, Admin admin){
        return new SinglePlayer(arguments, admin);
    }

    public Error createTeam(String[] arguments){
        final int TEAM_NAME = 0;
        final int PLAYER_NAME = 1;

        Admin admin = (Admin) this.sportManagementSystem.getCurrentUser();
        SinglePlayer[] players = new SinglePlayer[2];
        for (int i = 0; i < 2; i++) {
            players[i] = this.sportManagementSystem.getPlayerByIdentifier(arguments[PLAYER_NAME + i]);
        }

        if(players[0] != null && players[1] != null){
            Team team = this.makeTeam(arguments[TEAM_NAME], players, admin);
            return this.sportManagementSystem.createTeam(team);
        } else {
            return Error.ELEMENT_DOES_NOT_EXIST;
        }
    }

    private Team makeTeam(String name, SinglePlayer[] players, Admin admin){
        return new Team(name, players, admin);
    }

    public Error createTournament(String[] arguments){
        final int START_DATE = 3;
        final int END_DATE = 4;

        Error error;
        try{
            String[] stringDates = new String[]{arguments[START_DATE], arguments[END_DATE]};
            LocalDate[] dates = this.makeDates(stringDates);
            Tournament tournament = this.makeTournament(arguments, dates);
            if(tournament != null){
                error = this.sportManagementSystem.createTournament(tournament);
            } else {
                error = Error.UNKNOWN_CATEGORY;
            }
        } catch(DateTimeParseException ex){
            error = Error.WRONG_DATE_FORMAT;
        }
        return error;
    }

    private LocalDate[] makeDates(String[] arguments){
        LocalDate[] dates = new LocalDate[2];
        for (int i = 0; i < 2; i++) {
            dates[i] = LocalDate.parse(arguments[i]);
        }
        return dates;
    }

    private Tournament makeTournament(String[] arguments, LocalDate[] dates){
        final int CATEGORIE = 5;
        final Integer currentCategorie = this.getCurrentCategorie(arguments[CATEGORIE]);
        if(currentCategorie != null){
            return new Tournament(arguments, dates, currentCategorie);
        } else {
            return null;
        }

    }

    private Integer getCurrentCategorie(String categorie){
        return new Category().getCategorie(categorie);
    }

    public Error teamAdd(String[] arguments){
        final int TEAM_NAME = 0;
        final int PLAYER_NAME = 1;

        SinglePlayer player = this.sportManagementSystem.getPlayerByIdentifier(arguments[PLAYER_NAME]);
        Team team = this.sportManagementSystem.getTeamByIdentifier(arguments[TEAM_NAME]);

        if(player != null && team != null){
            return this.sportManagementSystem.teamAdd(team, player);
        } else {
            return Error.ELEMENT_DOES_NOT_EXIST;
        }
    }

    public Error deletePlayer(String[] arguments){
        final int PLAYER_IDENTIFIER = 0;
        return this.sportManagementSystem.deletePlayer(arguments[PLAYER_IDENTIFIER]);
    }

    public Error deleteTeam(String[] arguments){
        final int PLAYER_IDENTIFIER = 0;
        return this.sportManagementSystem.deleteTeam(arguments[PLAYER_IDENTIFIER]);
    }

    public Error deleteTournament(String[] arguments){
        final int TOURNAMENT_IDENTIFIER = 0;
        return this.sportManagementSystem.deleteTournament(arguments[TOURNAMENT_IDENTIFIER]);
    }

    public Error teamRemove(String[] arguments){
        final int TEAM_NAME = 0;
        final int PLAYER_NAME = 1;

        Team team = this.sportManagementSystem.getTeamByIdentifier(arguments[TEAM_NAME]);

        if(team != null){
            return this.sportManagementSystem.teamRemove(team, arguments[PLAYER_NAME]);
        } else {
            return Error.ELEMENT_DOES_NOT_EXIST;
        }
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
