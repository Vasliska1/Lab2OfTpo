package domain;

public class Door {
    private final String name = "door";
    boolean isOpen;
    Location location;

    public Door(Location location) {
        this.isOpen = false;
        this.location = location;
    }
}
