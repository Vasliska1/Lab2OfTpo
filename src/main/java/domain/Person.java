package domain;

import domain.exception.DistanceException;

import java.nio.file.AccessDeniedException;
import java.util.Objects;

public class Person {
    String name;
    State state;
    boolean hypnotize;
    Location location;

    public Person(String name, State state, Location location, boolean hypnotize) {
        this.name = name;
        this.state = state;
        this.location = location;
        this.hypnotize = hypnotize;
    }

    public boolean winAttack(Rodents r) throws DistanceException {
        System.out.print(this.name + " is trying to attack" + r.kind + "\n");
        System.out.println("Distance is " + distance(r));
        if (distance(r) <= 15) {
            if (!hypnotize) {
                r.kill();
                System.out.print(this.name + " kill rodents\n");
                return true;
            } else {
                this.kill();
                System.out.print(this.name + " is hypnotized. Can not attack the rodent\n");
                return false;
            }
        } else {
            throw new DistanceException("distances is too big");
        }
    }

    public void move(int delX, int delY) {
        this.location.x += delX;
        this.location.y += delY;
        System.out.print(this.name + " is now at (" + this.location.x + ", " + this.location.y + ")\n");
    }

    public double distance(Rodents r) {
        long x = this.location.x - r.location.x;
        long y = this.location.y - r.location.y;
        return Math.sqrt(x * x + y * y);
    }

    public void kill() {
        this.state = State.CORPSE;
        System.out.print(this.name + " is died\n");
    }

    public void tryOpenDoor(Door door) throws AccessDeniedException {
        if (!door.isOpen && (Objects.equals(this.name, "Zaphod") || Objects.equals(this.name, "Ford"))) {
            System.out.println(this.name + "try open the door");
            door.isOpen = true;
        } else {
            throw new AccessDeniedException("Try can open only Ford or Zaphord");
        }
    }
}
