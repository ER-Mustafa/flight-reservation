package system;

import interfaces.Printable;

public class Ticket implements Printable {
    private static int idCounter = 0;
    private int id;
    private int reservationId;

    public Ticket(int reservationId) {
        idCounter++;
        this.id = idCounter;
        this.reservationId = reservationId;
    }

    public int getId() {
        return id;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void print() {
        System.out.println(id + " " + reservationId);
    }
}
