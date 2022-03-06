package domain;

import domain.exception.DistanceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {

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
        door = new Door(new Location(5, 5));
    }


    @Test
    void movePersonTest() {
        trillian.move(-2, -3);
        Assertions.assertEquals(trillian.location.x, 7);
        Assertions.assertEquals(trillian.location.y, 5);
    }

    @Test
    void tryAttackTest() {
        assertThrows(DistanceException.class, ()-> ford.winAttack(rod1));
    }

    @Test
    void attackWinHumanTest() throws Exception {
        Assertions.assertTrue(zaphod.winAttack(rod1));
        Assertions.assertFalse(rod1.alive);
    }

    @Test
    void attackWinRodentsTest() throws Exception {
        zaphod.hypnotize = true;
        Assertions.assertFalse(zaphod.winAttack(rod1));
        Assertions.assertTrue(rod1.alive);
    }

    @Test
    void personKillTest() {
        trillian.kill();
        Assertions.assertEquals(trillian.state, State.CORPSE);
    }

    @Test
    void openDoorTestSuccess() throws Exception {
        ford.tryOpenDoor(door);
        Assertions.assertTrue(door.isOpen);
    }

    @Test
    void openDoorTestFail(){
        assertThrows(AccessDeniedException.class, ()-> trillian.tryOpenDoor(door));
    }
}