package system;

import enums.PlaneModel;
import enums.PlaneType;

import java.util.ArrayList;
import java.util.HashMap;

public class Plane {
    // Plane is not a model. It is an entity.
    private static int idCounter = 0;
    private final int id;
    private PlaneType type;
    private int capacity;
    private PlaneModel model;
    private final ArrayList<String> busyDays = new ArrayList<>();
    private static final ArrayList<Plane> planes = new ArrayList<>();
    private static final HashMap<Integer, Plane> planeMap = new HashMap<>();

    public Plane(PlaneType type, int capacity, PlaneModel model) {
        Plane.idCounter++;
        this.id = Plane.idCounter;
        this.type = type;
        this.capacity = capacity;
        this.model = model;
        Plane.planes.add(this);
        Plane.planeMap.put(this.id, this);
    }

    public int getId() {
        return id;
    }

    public PlaneType getType() {
        return type;
    }

    public void setType(PlaneType type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public PlaneModel getModel() {
        return model;
    }

    public void setModel(PlaneModel model) {
        this.model = model;
    }

    public static ArrayList<Plane> getPlanes() {
        return planes;
    }

    public static Plane getPlane(int id) {
        return planeMap.get(id);
    }

    public static int getPlaneForDate(String date, PlaneType type, PlaneModel model) {
        for (Plane plane: planes) {
            if (!plane.checkIfBusy(date) && plane.getType() == type && plane.getModel() == model) {
                plane.addBusyDay(date);
                return plane.getId();
            }
        }
        return -1;
    }

    public boolean checkIfBusy(String date) {
        for (String day: busyDays) {
            if (day.equals(date)) {
                return true;
            }
        }
        return false;
    }

    public void addBusyDay(String date) {
        busyDays.add(date);
    }

    public ArrayList<String> getBusyDays() {
        return busyDays;
    }
}
