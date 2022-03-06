package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RodentsTest {
    Person arthur;
    Rodents rod1;
    Room room;

    @BeforeEach
    void setUp() {
        arthur = new Person("Athur", State.ALIVE, new Location(10, 10), false);
        rod1 = new Rodents(new Location(13, 13), KindRodent.AIR);
        room = new Room();
    }
    @Test
    void moveRodentsTest() {
        rod1.move(1, 2);
        Assertions.assertEquals(rod1.location.x, 14);
        Assertions.assertEquals(rod1.location.y, 15);
    }

    @Test
    void hypnotizingTest() {
        rod1.hypnotize(arthur);
        Assertions.assertTrue(arthur.hypnotize);
    }

    @Test
    void killRodentsTest() {
        rod1.kill();
        Assertions.assertFalse(rod1.alive);
    }
}