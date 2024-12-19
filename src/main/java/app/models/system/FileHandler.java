package app.models.system;

import app.types.Error;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {

    public Error saveSession(SportManagementSystem sportManagementSystem){
        Error error = Error.NULL;
        try{
            ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("src/main/resources/data/session.txt"));
            writeFile.reset();
            writeFile.writeObject(sportManagementSystem);
            writeFile.close();
        } catch(Exception ex){
            error = Error.OPENING_FILE_ERROR;
            System.out.println(ex);
        }
        return error;
    }

    public Error recoverSession(SportManagementSystem sportManagementSystem){
        Error error = Error.NULL;
        try{
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("src/main/resources/data/session.txt"));
            sportManagementSystem = (SportManagementSystem) readFile.readObject();
            readFile.close();
        } catch(Exception ex){
            error = Error.OPENING_FILE_ERROR;
        }
        return error;
    }
}
