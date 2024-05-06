package system;

import enums.AirlineCompany;
import interfaces.Printable;

import java.util.ArrayList;

public class Flight implements Printable {
    private static int idCounter = 0;
    private final int id;
    private int tariffId;
    private String flightDate;
    private int planeId;
    private AirlineCompany airlineCompany;
    private int seatSold;
    private static final ArrayList<Flight> flights = new ArrayList<>();

    public Flight(int tariffId, String flightDate, int planeId, AirlineCompany airlineCompany) {
        this.id = idCounter++;
        this.tariffId = tariffId;
        this.flightDate = flightDate;
        this.planeId = planeId;
        this.airlineCompany = airlineCompany;
        this.seatSold = 0;
        Flight.getFlights().add(this);
    }

    public int getId() {
        return id;
    }

    public int getTariffId() {
        return tariffId;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public int getPlaneId() {
        return planeId;
    }

    public static ArrayList<Flight> getFlights() {
        return flights;
    }

    public void incrementSeatSold() {
        seatSold++;
    }

    public static void sellTicketForFlight(int flightNumber) {
        for (Flight flight : Flight.getFlights()) {
            if (flight.getPlaneId() == flight.getPlaneId()) {
                flight.incrementSeatSold();
            }
        }
    }

    public int getAvailableSeats() {
        Plane plane = Plane.getPlane(planeId);
        if (plane == null) {
            return 0;
        }
        return plane.getCapacity() - seatSold;
    }

    public static int getAvailableSeatForFlight(int flightNo) {
        for (Flight flight : flights) {
            if (flight.getId() == flightNo) {
                return flight.getAvailableSeats();
            }
        }
        return 0;
    }

    public static void printFlightsByDate(String date) {
        for (Flight flight : flights) {
            if (flight.flightDate.equals(date)) {
              flight.print();
            }
        }
    }

    public void print() {
        System.out.printf("*************\nFlight number: %d by %s\nDate: %s, Plane Number: %d, Tariff ID: %d\n*************\n",
                id, airlineCompany, flightDate, planeId, tariffId);
    }
}
