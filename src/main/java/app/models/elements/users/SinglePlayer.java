package app.models.elements.users;

import app.types.UserType;

public class SinglePlayer extends Player implements User {
    private static final int USER_NAME = 0;
    private static final int PASSWORD = 1;
    private static final int NAME = 2;
    private static final int LAST_NAME = 3;
    private static final int DNI = 4;


    private final String name;
    private final String lastName;
    private final String password;
    private final UserType userType;
    private final String playerDNI;

    public SinglePlayer(String[] data, Admin admin){
        super(data[USER_NAME], admin);
        this.name = data[NAME];
        this.lastName = data[LAST_NAME];
        this.password = data[PASSWORD];
        this.userType = UserType.PLAYER;
        this.playerDNI = data[DNI];
    }

    public UserType getUserType() {
        return this.userType;
    }

    public String getUserName() {
        return super.getIdentifier();
    }

    public String getPassword() {
        return this.password;
    }

    public String toCsvFormat(){
        String result = this.name + "," + this.lastName + "," + this.getIdentifier() + "," + this.playerDNI + "," +
                        this.getScore() + "," + this.getMatchesWon() + "," + this.getAssistanceScore() + ","
                        + this.getAssistanceScore() + "," + this.getMoney();

        return result;
    }

    public String toJsonFormat(){
        String result = "name: " + this.name + "\nlastname: " + this.lastName + "\nusername: " + this.getUserName() +
                        "\ndni: " + this.playerDNI + "\nscore: " + this.getScore() + "\nmatches_won: "
                        + this.getMatchesWon() + "\nassistance_score" + this.getAssistanceScore()
                        + "\ntournaments_won: " + this.getTournamentsWon() + "\nmoney: " + this.getMoney();

        return result;
    }
}
