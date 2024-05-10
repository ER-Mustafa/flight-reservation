package system;

import interfaces.Printable;

import java.util.ArrayList;
import java.util.HashMap;

public class Passenger extends Client implements Printable {
    private static int idCounter = 0;
    private final int id;
    private static final ArrayList<Passenger> passengers = new ArrayList<>();
    private static final HashMap<Integer, Passenger> passengerMap = new HashMap<>();

    public Passenger(String name, int age, String surname,
                     String nationality, String gender, String nationalId ) {
        super(name, age, surname, nationality, gender, nationalId);
        Passenger.idCounter++;
        this.id = idCounter;
        Passenger.passengers.add(this);
        Passenger.passengerMap.put(this.id, this);
    }

    public int getId() {
        return id;
    }

    public static ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public static Passenger getPassenger(int id) {
        return passengerMap.get(id);
    }

    public void print() {
        System.out.println("Id: " + getId() +"Name: " + this.getName() + " Age: " + this.getAge() + " Surname: " + this.getSurname());
    }
}
