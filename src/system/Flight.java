package system;

import enums.AirportCode;
import enums.Days;
import enums.AirlineCompany;

public class Flight {
    private static int idCounter = 0;
    private int id;
    private int planeId;
    private String departureTime; // "hour:minute:second"
    private AirportCode origin;
    private AirportCode destination;
    private String duration; // "hour:minute:second"
    private Days[] availableDays;
    private AirlineCompany company;

    public Flight(int planeId, String departureTime, AirportCode origin, AirportCode destination, String duration, Days[] availableDays, AirlineCompany company) {
        Flight.idCounter++;
        this.id = idCounter;
        this.planeId = planeId;
        this.departureTime = departureTime;
        this.origin = origin;
        this.destination = destination;
        this.duration = duration;
        this.availableDays = availableDays;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public AirportCode getOrigin() {
        return origin;
    }

    public void setOrigin(AirportCode origin) {
        this.origin = origin;
    }

    public AirportCode getDestination() {
        return destination;
    }

    public void setDestination(AirportCode destination) {
        this.destination = destination;
    }
    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    public Days[] getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(Days[] availableDays) {
        this.availableDays = availableDays;
    }

    public AirlineCompany getCompany() {
        return company;
    }

    public void setCompany(AirlineCompany company) {
        this.company = company;
    }
}
