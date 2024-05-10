package system;

import enums.AirlineCompany;
import enums.AirportCode;
import enums.PlaneModel;
import enums.PlaneType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tariff {
    private static int idCounter = 0;
    private final int id;
    private PlaneType planeType;
    private PlaneModel planeModel;
    private AirportCode origin;
    private AirportCode destination;
    private String departureHour;
    private String arrivalHour;
    private int[] days;
    private AirlineCompany airlineCompany;
    private String periodStart;
    private String periodEnd;
    private static final ArrayList<Tariff> tariffs = new ArrayList<>();
    private static final Map<Integer, Tariff> tariffMap = new HashMap<>();

    public Tariff(PlaneType planeType,
                  PlaneModel planeModel,
                  AirportCode origin,
                  AirportCode destination,
                  String departureHour,
                  String arrivalHour,
                  int[] days,
                  AirlineCompany airlineCompany,
                  String periodStart,
                  String periodEnd
                  ) {
        idCounter++;
        this.id = idCounter;
        this.planeType = planeType;
        this.planeModel = planeModel;
        this.origin = origin;
        this.destination = destination;
        this.departureHour = departureHour;
        this.arrivalHour = arrivalHour;
        this.days = days;
        this.airlineCompany = airlineCompany;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        Tariff.tariffs.add(this);
        tariffMap.put(this.id, this);
    }

    public int getId() {
        return id;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public PlaneModel getPlaneModel() {
        return planeModel;
    }

    public AirportCode getOrigin() {
        return origin;
    }

    public AirportCode getDestination() {
        return destination;
    }

    public String getDepartureHour() {
        return departureHour;
    }

    public String getArrivalHour() {
        return arrivalHour;
    }

    public int[] getDays() {
        return days;
    }

    public AirlineCompany getAirlineCompany() {
        return airlineCompany;
    }

    public String getPeriodStart() {
        return periodStart;
    }

    public String getPeriodEnd() {
        return periodEnd;
    }

    public void setPlaneType(PlaneType planeType) {
        this.planeType = planeType;
    }

    public void setPlaneModel(PlaneModel planeModel) {
        this.planeModel = planeModel;
    }

    public void setOrigin(AirportCode origin) {
        this.origin = origin;
    }

    public void setDestination(AirportCode destination) {
        this.destination = destination;
    }

    public void setDepartureHour(String departureHour) {
        this.departureHour = departureHour;
    }

    public void setArrivalHour(String arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public void setDays(int[] days) {
        this.days = days;
    }

    public void setAirlineCompany(AirlineCompany airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public void setPeriodStart(String periodStart) {
        this.periodStart = periodStart;
    }

    public void setPeriodEnd(String periodEnd) {
        this.periodEnd = periodEnd;
    }

    public void createFlights () {
        // Create new flights according to tariff.
        return;
    }

    public static Tariff getTariff(int id) {
        return tariffMap.get(id);
    }

    public static ArrayList<Tariff> getTariffs() {
        return tariffs;
    }
}
