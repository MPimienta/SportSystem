package app.controllers;

import app.models.SportManagementSystem;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Team;
import app.models.lists.elements.Tournament;
import app.types.Error;
import app.types.users.Admin;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CreateController {
    private final SportManagementSystem sportManagementSystem;

    public CreateController(SportManagementSystem sportManagementSystem){
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
        SinglePlayer player = this.sportManagementSystem.getPlayerByIdentifier(arguments[PLAYER_NAME]);

        if(player != null){
            Team team = this.makeTeam(arguments[TEAM_NAME], player, admin);
            return this.sportManagementSystem.createTeam(team);
        } else {
            return Error.ELEMENT_DOES_NOT_EXIST;
        }
    }

    private Team makeTeam(String name, SinglePlayer player, Admin admin){
        return new Team(name, player, admin);
    }

    public Error createTournament(String[] arguments){
        final int START_DATE = 3;
        final int END_DATE = 4;

        Error error;
        try{
            Admin admin = (Admin) this.sportManagementSystem.getCurrentUser();
            String[] stringDates = new String[]{arguments[START_DATE], arguments[END_DATE]};
            LocalDate[] dates = this.makeDates(stringDates);
            Tournament tournament = this.makeTournament(arguments, dates);
            error = this.sportManagementSystem.createTournament(tournament);
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
        return new Tournament(arguments, dates);
    }

}
