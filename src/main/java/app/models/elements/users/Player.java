package app.models.elements.users;

import app.models.elements.Element;

public abstract class Player implements Element {
    private static final int SCORE = 0;
    private static final int MATCHES_WON = 1;
    private static final int ASSISTANCE_SCORE = 2;
    private static final int TOURNAMENTS_WON = 3;
    private static final int MONEY = 4;

    private final String identifier;
    private final Admin creator;
    private final double[] statistics;

    public Player(String identifier, Admin creator){
        this.identifier = identifier;
        this.creator = creator;
        this.statistics = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
    }

    public String getIdentifier(){
        return this.identifier;
    }

    public Admin getCreator(){
        return this.creator;
    }

    protected double getScore(){
        return this.statistics[SCORE];
    }
    protected double getMatchesWon(){
        return this.statistics[MATCHES_WON];
    }
    protected double getAssistanceScore(){
        return this.statistics[ASSISTANCE_SCORE];
    }
    protected double getTournamentsWon(){
        return this.statistics[TOURNAMENTS_WON];
    }
    protected double getMoney(){
        return this.statistics[MONEY];
    }
    public double[] getStatistics(){
        return this.statistics;
    }

    public double getStatistic(int statistic){
        return this.statistics[statistic];
    }

    public String toString(){
        return "name: " + this.getIdentifier() + ", score: " + this.getScore();
    }

}
