package domain;

public class Rodents {

    KindRodent kind;
    Location location;
    boolean alive;

    public Rodents(Location location, KindRodent kind) {
        this.kind = kind;
        this.location = location;
        this.alive = true;
    }

    public void hypnotize(Person person) {
        person.hypnotize = true;
        System.out.println(person.name + " загипнотизирoвали " + this.kind);
    }
    public void move(int delX, int delY){
        this.location.x += delX;
        this.location.y += delY;
        System.out.print(this.kind + " is now at (" + this.location.x + ", " + this.location.x + ")\n");
    }

    public void kill(){
        this.alive = false;
        System.out.print(this.kind + " is died\n");
    }
}
