package app.models.system;

import app.models.elements.Team;
import app.models.elements.Tournament;
import app.models.elements.users.*;
import app.models.lists.*;
import app.types.Error;
import app.types.UserType;
import app.views.console.PlayersView;

import java.io.Serial;
import java.io.Serializable;

public class SportManagementSystem implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int PLAYER_LIST = 0;
    private static final int USER_LIST = 1;
    private static final int TEAM_LIST = 2;
    private static final int TOURNAMENT_LIST = 3;

    private final ListOfElements[] lists;
    private User currentUser;
    private final Creator creator;
    private final Deleter deleter;

    public SportManagementSystem(){
        this.lists = new ListOfElements[]{
                new PlayerList(),
                new UserList(),
                new TeamList(),
                new TournamentsList()
        };
        this.creator = new Creator(this.lists);
        this.deleter = new Deleter(this.lists);

        this.currentUser = new CommonUser();
        this.createUser(new Admin("sudo", "sudopassword"));


    }
    public Error createUser(User user){
        return this.creator.createUser(user);
    }

    public Error createPlayer(SinglePlayer player){
        return this.creator.createPlayer(player);
    }

    public Error createTeam(Team team){
        return this.creator.createTeam(team);
    }

    public Error createTournament(Tournament tournament){
        return this.creator.createTournament(tournament);
    }

    public Error deletePlayer(String player){
        return this.deleter.deletePlayer(player);
    }

    public Error deleteTeam(String team){
        return this.deleter.deleteTeam(team);
    }

    public Error deleteTournament(String tournament){
        return this.deleter.deleteTournament(tournament);
    }

    public Error updateUser(String[] arguments){
        final int PASSWORD = 1;

        Error error = Error.NULL;
        int IDENTIFIER = 0;
        int index = this.lists[USER_LIST].getIndexOfElement(arguments[IDENTIFIER]);
        if(this.lists[USER_LIST].elementExists(index)){
            User user = (User) this.lists[USER_LIST].getElement(index);
            if(user.getPassword().equals(arguments[PASSWORD])){
                this.currentUser = user;
            } else {
                error = Error.INCORRECT_PASSWORD;
            }
        } else {
            error = Error.USER_DOES_NOT_EXIST;
        }
        return error;
    }

    public void logout(){
        this.currentUser = new CommonUser();
    }

    public UserType getCurrentUserType(){
        return this.currentUser.getUserType();
    }

    public User getCurrentUser(){
        return this.currentUser;
    }

    public SinglePlayer getPlayerByIdentifier(String name){
        return (SinglePlayer) this.lists[PLAYER_LIST].getElementByIdentifier(name);
    }

    public Team getTeamByIdentifier(String name){
        return (Team) this.lists[TEAM_LIST].getElementByIdentifier(name);
    }

    public Tournament getTournamentByIdentifier(String tournament){
        return (Tournament) this.lists[TOURNAMENT_LIST].getElementByIdentifier(tournament);
    }

    public Error teamAdd(Team team, SinglePlayer player){
        return this.creator.teamAdd(team, player);
    }

    public Error teamRemove(Team team, String player){
        return this.deleter.teamRemove(team, player);
    }

    public Error manualMatchmake(Tournament tournament, Player[] players){
        return tournament.manualMatchmake(players);
    }

    public Error randomMatchmake(Tournament tournament){
        return tournament.randomMatchmake();
    }

    public Error tournamentAddPlayer(Player player, Tournament tournament){
        return this.creator.tournamentAddPlayer(player, tournament);
    }

    public Error tournamentRemovePlayer(Player player, Tournament tournament){
        return this.deleter.tournamentRemovePlayer(player, tournament);
    }

    public void showTournamentList(){
        new PlayersView().showTournamentList((TournamentsList) this.lists[TOURNAMENT_LIST]);
    }

    public void showTournamentListRanked(){
        TournamentsList tournamentsList = (TournamentsList) this.lists[TOURNAMENT_LIST];
        new PlayersView().showTournamentListRanked(tournamentsList.rankedToString());
    }

    public void deletePastTournaments(){
        TournamentsList tournamentsList = (TournamentsList) this.lists[TOURNAMENT_LIST];
        tournamentsList.deletePastTournaments();
    }

    public ListOfElements[] getLists(){
        return this.lists;
    }


}
