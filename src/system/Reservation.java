package system;

import java.util.ArrayList;

public class Reservation {
    private static int idCounter = 0;
    private final int id;
    private int passengerId;
    private String date; // The format is "YYYY/MM/DD"
    private int flightId;
    private static final ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public Reservation(int passengerId, String date, int flightId) {
        idCounter++;
        this.id = idCounter;
        this.passengerId = passengerId;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
