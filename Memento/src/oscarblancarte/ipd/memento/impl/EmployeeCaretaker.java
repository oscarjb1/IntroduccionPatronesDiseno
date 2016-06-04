package oscarblancarte.ipd.memento.impl;

import java.util.LinkedList;

public class EmployeeCaretaker {
    private int currentIndex = -1;
    
    private final LinkedList<EmployeeMemento> states = new LinkedList<>();

    public void addNewMemento(EmployeeMemento m) {
        states.add(m);
        currentIndex++;
    }
    public EmployeeMemento getCurrentMemento() {
        return states.get(currentIndex);
    }
    
    public EmployeeMemento getNextMemento() {
        int newIndex = currentIndex +1;
        if( newIndex >= states.size()){
            return null;
        }
        currentIndex = newIndex;
        return states.get(currentIndex);
    }
    
    public EmployeeMemento getPreviousMemento() {
        int newIndex = currentIndex-1;
        
        if(newIndex  <= -1 || newIndex >= states.size()-1){
            return null;
        }
        currentIndex= newIndex;
        return states.get(currentIndex);
    }
}
