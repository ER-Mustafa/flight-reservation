package system;

import java.util.ArrayList;

public class Flight {
    private static int idCounter = 0;
    private final int id;
    private int tariffId;
    private String flightDate;
    private static final ArrayList<Flight> flights = new ArrayList<>();

    public Flight(int tariffId, String flightDate) {
        this.id = idCounter++;
        this.tariffId = tariffId;
        this.flightDate = flightDate;
        Flight.flights.add(this);
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

    public static ArrayList<Flight> getFlights() {
        return flights;
    }
}
