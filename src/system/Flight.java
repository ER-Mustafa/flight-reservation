package system;

import enums.AirlineCompany;
import enums.AirportCode;
import interfaces.Printable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Flight implements Printable {
    private static int idCounter = 0;
    private final int id;
    private int tariffId;
    private String flightDate;
    private int planeId;
    private AirlineCompany airlineCompany;
    private int seatSold;
    private static final ArrayList<Flight> flights = new ArrayList<>();
    private static final HashMap<Integer, Flight> flightMap = new HashMap<>();

    public Flight(int tariffId, String flightDate, int planeId, AirlineCompany airlineCompany) {
        this.id = idCounter++;
        this.tariffId = tariffId;
        this.flightDate = flightDate;
        this.planeId = planeId;
        this.airlineCompany = airlineCompany;
        this.seatSold = 0;
        Flight.getFlights().add(this);
        flightMap.put(id, this);
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
        Flight wantedFlight = flightMap.get(flightNumber);
        if (wantedFlight == null) {
            return;
        }
        wantedFlight.incrementSeatSold();
    }

    public static Flight getFlight(int flightNumber) {
        return flightMap.get(flightNumber);
    }

    public int getAvailableSeats() {
        Plane plane = Plane.getPlane(planeId);
        if (plane == null) {
            return 0;
        }
        return plane.getCapacity() - seatSold;
    }

    public static int getAvailableSeatForFlight(int flightNo) {
        Flight flight = Flight.getFlight(flightNo);
        if (flight == null) {
            return 0;
        }
        return flight.getAvailableSeats();
    }

    public static void printFlightsByDate(String date) {
        for (Flight flight : flights) {
            if (flight.flightDate.equals(date)) {
              flight.print();
            }
        }
    }

    public static void printFlightsByQuery(AirportCode origin, AirportCode destination, String start, String end) {
        Date startDate = stringToDate(start);
        Date endDate = stringToDate(end);
        for (Flight flight: flights) {
            Tariff tariff = Tariff.getTariff(flight.getTariffId());
            Date flightD = stringToDate(flight.getFlightDate());
            boolean timeCondition = flightD.compareTo(startDate) >= 0 && flightD.compareTo(endDate) <= 0;
            boolean airportCondition = tariff.getOrigin() == origin && tariff.getDestination() == destination;
            if (timeCondition && airportCondition) {
                flight.print();
            }
        }
    }

    private static Date stringToDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formatter.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public void print() {
        System.out.printf("*************\nFlight number: %d by %s\nDate: %s, Plane Number: %d, Tariff ID: %d\n*************\n",
                id, airlineCompany, flightDate, planeId, tariffId);
    }
}
