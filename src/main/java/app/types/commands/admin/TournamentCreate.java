package app.types.commands.admin;

import app.models.CLIApp;
import app.models.lists.elements.SinglePlayer;
import app.models.lists.elements.Tournament;
import app.types.Error;
import app.types.commands.Command;
import app.types.users.Admin;
import app.types.users.UserType;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TournamentCreate implements Command {
    private static final int NECESSARY_ARGUMENTS = 5;

    private final CLIApp cliApp;

    public TournamentCreate(CLIApp cliApp){
        this.cliApp = cliApp;
    }

    public Error execute(String[] arguments){
        Error error;
        if(arguments.length < NECESSARY_ARGUMENTS){
            error = Error.NOT_ENOUGH_ARGUMENTS;
        } else {
            try{
                Admin admin = (Admin) this.cliApp.getCurrentUser();
                String[] stringDates = new String[]{arguments[3], arguments[4]};
                LocalDate[] dates = this.makeDates(stringDates);
                Tournament tournament = this.makeTournament(arguments, dates);
                error = this.cliApp.createTournament(tournament);
            } catch(DateTimeParseException ex){
                error = Error.WRONG_DATE_FORMAT;
            }
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
