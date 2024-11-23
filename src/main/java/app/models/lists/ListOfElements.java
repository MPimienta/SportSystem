package app.models.lists;

import java.util.LinkedList;

import app.models.lists.elements.Element;
import app.types.Error;

public abstract class ListOfElements {
    private final LinkedList<Element> list;

    public ListOfElements(){
        this.list = new LinkedList<>();
    }

    public abstract Error addElement(String[] arguments);

    protected int getIndexOfElement(String identifier){
        assert identifier != null;

        int i = 0;
        while(i < this.list.size() && !this.list.get(i).getIdentifier().equals(identifier)){
            i++;
        }

        return i;
    }

    protected boolean elementExists(int index){
        if(index == this.list.size()){
            return false;
        } else {
            return true;
        }
    }

    protected LinkedList<Element> getList(){
        return this.list;
    }
}
