package app.models.lists.elements;
import java.time.LocalDate;
import java.util.Date;

public class Tournament implements Element {
    private static final int NAME = 0;
    private static final int SPORT = 1;
    private static final int LEAGUE = 2;

    private static final int START_DATE = 0;
    private static final int END_DATE = 1;

    private final String name;
    private final String sport;
    private final LocalDate[] dates;
    private final String league;

    public Tournament(String[] arguments, LocalDate[] dates){
        this.name = arguments[NAME];
        this.sport = arguments[SPORT];
        this.league = arguments[LEAGUE];
        this.dates = dates;
    }

    @Override
    public String getIdentifier() {
        return this.name;
    }
}
