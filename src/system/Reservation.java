package system;

import interfaces.Printable;

import java.util.ArrayList;
import java.util.HashMap;

public class Reservation implements Printable {
    private static int idCounter = 0;
    private final int id;
    private int passengerId;
    private int flightId;
    private static final ArrayList<Reservation> reservations = new ArrayList<Reservation>();
    private static final HashMap<Integer, Reservation> reservationMap = new HashMap<>();

    public Reservation(int passengerId, int flightId) {
        idCounter++;
        this.id = idCounter;
        this.passengerId = passengerId;
        this.flightId = flightId;
        reservations.add(this);
        reservationMap.put(id, this);
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

    public static ArrayList<Reservation> getReservationsByPassengerId(int passengerId) {
        ArrayList<Reservation> result = new ArrayList<Reservation>();
        for (Reservation reservation : reservations) {
            if (reservation.getPassengerId() == passengerId) {
                result.add(reservation);
            }
        }
        return result;
    }

    public static Reservation getReservation(int id) {
        return reservationMap.get(id);
    }

    public void print() {
        System.out.println("Passenger ID: " + passengerId + " Flight ID: " + flightId);
    }

}
