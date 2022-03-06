package domain;

public enum KindRodent {

    AIR("Воздухоплавающие грызуны"),
    EARTH("Земляные грызуны");

    private String message;

    KindRodent(String message) {
        this.message = message;
    }
}
