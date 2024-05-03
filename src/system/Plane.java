package system;

import enums.PlaneModel;
import enums.PlaneType;

import java.util.ArrayList;

public class Plane {
    // Plane is not a model. It is an entity.
    private static int idCounter = 0;
    private final int id;
    private PlaneType type;
    private int capacity;
    private PlaneModel model;
    private static final ArrayList<Plane> planes = new ArrayList<>();

    public Plane(PlaneType type, int capacity, PlaneModel model) {
        Plane.idCounter++;
        this.id = Plane.idCounter;
        this.type = type;
        this.capacity = capacity;
        this.model = model;
        Plane.planes.add(this);
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
}
