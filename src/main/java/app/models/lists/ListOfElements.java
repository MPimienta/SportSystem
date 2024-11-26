package app.models.lists;

import java.util.Iterator;
import java.util.LinkedList;

import app.models.lists.elements.Element;
import app.types.Error;
import app.types.users.Admin;

public abstract class ListOfElements {
    private final LinkedList<Element> list;

    public ListOfElements(){
        this.list = new LinkedList<>();
    }

    public Error addElement(Element element) {
        Error error = Error.NULL;
        int index = this.getIndexOfElement(element.getIdentifier());

        if(!this.elementExists(index)){
           this.list.add(element);
        } else {
            //Todo: Change error name to Element instead of player
            error = Error.PLAYER_ALREADY_EXISTS;
        }

        return error;
    }

    public int getIndexOfElement(String identifier){
        assert identifier != null;

        int i = 0;
        while(i < this.list.size() && !this.list.get(i).getIdentifier().equals(identifier)){
            i++;
        }

        return i;
    }

    public boolean elementExists(int index){
        if(index == this.list.size()){
            return false;
        } else {
            return true;
        }
    }

    public Element getElement(int index){
        return list.get(index);
    }

    public Error removeElement(String identifier){
        Error error = Error.NULL;
        int index = this.getIndexOfElement(identifier);

        if(this.elementExists(index)){
            this.list.remove(index);
        } else {
            error = Error.PLAYER_DOES_NOT_EXIST;
        }

        return error;
    }

    public Element getElementByIdentifier(String identifier){
        assert identifier != null;

        int i = 0;
        while(i < this.list.size() && !this.list.get(i).getIdentifier().equals(identifier)){
            i++;
        }

        if(this.elementExists(i)){
            return this.list.get(i);
        } else {
            return null;
        }
    }

    protected LinkedList<Element> getList(){
        return this.list;
    }
}
