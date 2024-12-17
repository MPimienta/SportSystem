package app.models.system;

import app.models.lists.ListOfElements;
import app.models.elements.users.Player;
import app.models.elements.users.SinglePlayer;
import app.models.elements.Team;
import app.models.elements.Tournament;
import app.models.lists.PlayerList;
import app.models.lists.UserList;
import app.types.Error;
import app.models.elements.users.User;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Creator {
    private static final int PLAYER_LIST = 0;
    private static final int USER_LIST = 1;
    private static final int TEAM_LIST = 2;
    private static final int TOURNAMENT_LIST = 3;

    private final ListOfElements[] lists;

    public Creator(ListOfElements[] lists){
        this.lists = lists;
    }

    public Error createUser(User user){
        Error error = lists[USER_LIST].addElement(user);
        if(error.isNull()){
            try{
                ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("src/main/resources/data/users.txt"));
                writeFile.reset();
                writeFile.writeObject(this.lists[USER_LIST]);
                writeFile.close();
            } catch (Exception e){
                System.out.println("ERROR AL ABRIR EL ARCHIVO");
            }
        }
        return error;
    }

    public Error createPlayer(SinglePlayer player){
        Error error = this.lists[PLAYER_LIST].addElement(player);
        if(error.isNull()){
            try{
                ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("src/main/resources/data/players.txt"));
                writeFile.reset();
                writeFile.writeObject(this.lists[PLAYER_LIST]);
                writeFile.close();
            } catch (Exception e){
                System.out.println("ERROR AL ABRIR EL ARCHIVO");
            }
        }
        return error;
    }

    public Error createTeam(Team team){
        Error error = this.lists[TEAM_LIST].addElement(team);
        if(error.isNull()){
            try{
                ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("src/main/resources/data/teams.txt"));
                writeFile.reset();
                writeFile.writeObject(this.lists[TEAM_LIST]);
                writeFile.close();
            } catch (Exception e){
                System.out.println("ERROR AL ABRIR EL ARCHIVO");
            }
        }
        return error;
    }

    public Error createTournament(Tournament tournament){
        Error error = lists[TOURNAMENT_LIST].addElement(tournament);
        if(error.isNull()){
            try{
                ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("src/main/resources/data/tournaments.txt"));
                writeFile.reset();
                writeFile.writeObject(this.lists[TOURNAMENT_LIST]);
                writeFile.close();
            } catch (Exception e){
                System.out.println("ERROR AL ABRIR EL ARCHIVO");
            }
        }
        return error;
    }

    public Error teamAdd(Team team, SinglePlayer player){
        Error error = team.addPlayer(player);
        if(error.isNull()){
            try{
                ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("src/main/resources/data/teams.txt"));
                writeFile.reset();
                writeFile.writeObject(this.lists[TEAM_LIST]);
                writeFile.close();
            } catch (Exception e){
                System.out.println("ERROR AL ABRIR EL ARCHIVO");
            }
        }
        return error;
    }

    public Error tournamentAddPlayer(Player player, Tournament tournament){
        if (!tournament.isOngoing()){
            Error error = tournament.addPlayer(player);
            if(error.isNull()){
                try{
                    ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("src/main/resources/data/tournaments.txt"));
                    writeFile.reset();
                    writeFile.writeObject(this.lists[TOURNAMENT_LIST]);
                    writeFile.close();
                } catch (Exception e){
                    System.out.println("ERROR AL ABRIR EL ARCHIVO");
                }
            }
            return error;
        } else {
            return Error.ONGOING_TOURNAMENT;
        }
    }
}
