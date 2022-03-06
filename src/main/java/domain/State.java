package domain;

public enum State {
    ALIVE("Живой"),
    CORPSE("Труп");

    private String message;

    State(String message) {
        this.message = message;
    }
}
