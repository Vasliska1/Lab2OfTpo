package domain;

import domain.exception.DoorException;

import java.util.ArrayList;
import java.util.List;

public class Room {

    public List<Person> human = new ArrayList<>();
    public List<Rodents> rodent = new ArrayList<>();

    public Room() {
        System.out.print("The room is created.\n");
    }

    public void addPerson(Person h) {
        human.add(h);
    }

    public int getNumHuman() {
        return human.size();
    }

    public int getNumRodent() {
        return rodent.size();
    }

    public void removeHuman(Person h, Door door) throws DoorException {
        if (door.isOpen) {
            human.remove(h);
        }else{
            throw new DoorException("door is close");
        }
    }

    public void addRodents(Rodents r) {
        rodent.add(r);
    }

    public boolean isEmptyRoom(){
        return human.size() == 0 && rodent.size() == 0;
    }
}
