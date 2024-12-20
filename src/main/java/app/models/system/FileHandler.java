package app.models.system;

import app.models.elements.Element;
import app.models.lists.ListOfElements;
import app.types.Error;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class FileHandler {

    public Error saveSession(SportManagementSystem sportManagementSystem){
        Error error = Error.NULL;
        ListOfElements[] lists = sportManagementSystem.getLists();
        String[] files = new String[]{"players", "users", "teams", "tournaments"};
        int i = 0;
        while(error.isNull() && i < 4){
            error = this.saveList(lists[i],files[i]);
            i++;
        }

        return error;
    }

    private Error saveList(ListOfElements list, String file){
        Error error = Error.NULL;
        try{
            String path = String.format("src/main/resources/data/" + file + ".txt");
            ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(path));
            writeFile.reset();
            writeFile.writeObject(list.getList());
            writeFile.close();
        } catch(Exception ex){
            error = Error.OPENING_FILE_ERROR;
        }
        return error;
    }

    public Error recoverSession(SportManagementSystem sportManagementSystem){
        Error error = Error.NULL;
        ListOfElements[] lists = sportManagementSystem.getLists();
        String[] files = new String[]{"players", "users", "teams", "tournaments"};
        int i = 0;
        while(error.isNull() && i < 4){
            error = this.recoverList(lists[i],files[i]);
            i++;
        }

        return error;
    }


    private Error recoverList(ListOfElements list, String file){
        Error error = Error.NULL;
        try{
            String path = String.format("src/main/resources/data/" + file + ".txt");
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(path));
            LinkedList<Element> recoveredList = (LinkedList<Element>) readFile.readObject();
            list.getList().clear();
            for(Element element : recoveredList){
                list.getList().add(element);
            }
            readFile.close();
        } catch(Exception ex){
            error = Error.OPENING_FILE_ERROR;
        }
        return error;
    }
}
