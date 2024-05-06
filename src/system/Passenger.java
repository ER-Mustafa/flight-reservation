package system;

import java.util.ArrayList;

public class Passenger extends Client {
    private static int idCounter = 0;
    private final int id;
    private static final ArrayList<Passenger> passengers = new ArrayList<>();

    public Passenger(String name, int age, String surname,
                     String nationality, String gender, String nationalId ) {
        super(name, age, surname, nationality, gender, nationalId);
        Passenger.idCounter++;
        this.id = idCounter;
        Passenger.passengers.add(this);
    }

    public int getId() {
        return id;
    }

    public static ArrayList<Passenger> getPassengers() { return passengers; }
}
