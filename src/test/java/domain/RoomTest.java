package domain;

import domain.exception.DoorException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    Room room;
    Person arthur;
    Person trillian;
    Person ford;
    Person zaphod;
    Rodents rod1;
    Door door;

    @BeforeEach
    void setUp() {
        arthur = new Person("Athur", State.ALIVE, new Location(10, 10), false);
        trillian = new Person("Trillian", State.ALIVE, new Location(9, 8), false);
        ford = new Person("Ford", State.ALIVE, new Location(30, 25), false);
        zaphod = new Person("Zaphod ", State.ALIVE, new Location(5, 5), false);
        rod1 = new Rodents(new Location(13, 13), KindRodent.AIR);
        room = new Room();
        door = new Door(new Location(5, 5));
    }

    @Test
    void createRoomTest() {
        room.addPerson(trillian);
        room.addPerson(arthur);
        room.addPerson(ford);
        room.addPerson(zaphod);
        room.addRodents(rod1);
        Assertions.assertEquals(4, room.getNumHuman());
        Assertions.assertEquals(1, room.getNumRodent());
    }

    @Test
    void isEmptyRoomTest() {
        Assertions.assertTrue(room.isEmptyRoom());
    }

    @Test
    void notEmptyRoomTest() {
        room.addPerson(trillian);
        room.addRodents(rod1);
        Assertions.assertFalse(room.isEmptyRoom());
    }

    @Test
    void removePersonTestSuccess() throws Exception {
        room.addPerson(zaphod);
        room.addPerson(trillian);
        ford.tryOpenDoor(door);
        room.removeHuman(zaphod, door);
        Assertions.assertEquals(1, room.getNumHuman());
    }

    @Test
    void removePersonTestFail() {
        room.addPerson(zaphod);
        room.addPerson(trillian);
        assertThrows(DoorException.class, ()->room.removeHuman(zaphod, door));
    }
}