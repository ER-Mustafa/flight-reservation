package system;

public class Passenger extends Client {
    private static int idCounter = 0;
    private final int id;

    public Passenger(String name, int age, String surname,
                     String nationality, String gender, String nationalId ) {
        super(name, age, surname, nationality, gender, nationalId);
        Passenger.idCounter++;
        this.id = idCounter;
    }

    public int getId() {
        return id;
    }
}
