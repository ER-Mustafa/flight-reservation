package system;

import interfaces.Printable;

import java.util.ArrayList;

public class Ticket implements Printable {
    private static int idCounter = 0;
    private int id;
    private int reservationId;
    private static final ArrayList<Ticket> tickets = new ArrayList<>();

    public Ticket(int reservationId) {
        idCounter++;
        this.id = idCounter;
        this.reservationId = reservationId;
        Ticket.tickets.add(this);
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
        System.out.println("-- Ticket id: " + id);
    }
}
