package domain;

public class Car {
    public final String name;

    public int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void move() {
        this.location++;
    }


}


