package system;

import java.util.ArrayList;

public class Reservation {
    private static int idCounter = 0;
    private final int id;
    private int passengerId;
    private int flightId;
    private static final ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public Reservation(int passengerId, int flightId) {
        idCounter++;
        this.id = idCounter;
        this.passengerId = passengerId;
        this.flightId = flightId;
        reservations.add(this);
    }

    public int getId() {
        return id;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }
}
