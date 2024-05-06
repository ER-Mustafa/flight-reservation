package handlers;

import system.Flight;
import system.Passenger;
import system.Reservation;
import system.Ticket;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalHandler implements Runnable {

    @Override
    public void run() {
        System.out.println("WELCOME TO RS13+1! Please provide a command: ");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(":: ");
            String command = scanner.nextLine();
            String[] elements = command.split(" ");
            if (elements[0].equals("exit")) {
                break;
            }

            // query by date
            if (elements[0].equals("qd")) { // ::qd <DD/MM/YYYY>
                String date = elements[1];
                Flight.printFlightsByDate(date);
            }

            // create user
            if (elements[0].equals("cu")) { // ::cu
                System.out.println("Enter name,age,surname,nationality, gender, nationalId");
                System.out.print("-> ");
                String information = scanner.nextLine();
                String[] infoArray = information.split(",");
                String name = infoArray[0];

                int age = Integer.parseInt(infoArray[1]); // Convert this into integer
                String surname = infoArray[2];
                String nationality = infoArray[3];
                String gender = infoArray[4];
                String nationalId = infoArray[5];

                Passenger newPassenger = new Passenger(name, age, surname, nationality, gender, nationalId);
                System.out.println("Passenger created successfully!");
            }

            // make reservation
            if (elements[0].equals("mr")) {  // ::mr <flightNo> <passengerId>
                int flightNumber = Integer.parseInt(elements[1]);
                int passengerId = Integer.parseInt(elements[2]);
                if (Flight.getAvailableSeatForFlight(flightNumber) == 0) {
                    System.out.println("Cannot make reservations to this flight. No empty seats.");
                } else {
                    Reservation newReservation = new Reservation(passengerId, flightNumber);
                    Ticket newTicket = new Ticket(newReservation.getId());
                    Flight.sellTicketForFlight(flightNumber);
                    System.out.println("Reservation created successfully! Your ticket number: " + newTicket.getId());
                }
            }

            // ask-availability
            if (elements[0].equals("avs")) { // ::avs <flightNo>
                int flightNumber = Integer.parseInt(elements[1]);
                int seatAvailable = Flight.getAvailableSeatForFlight(flightNumber);
                System.out.println("Seat available: " + seatAvailable);
            }

            // show reservations of passenger
            if (elements[0].equals("srop")) { // ::srop <passengerId>
                int passengerId = Integer.parseInt(elements[1]);
                ArrayList<Reservation> reservations = Reservation.getReservationsByPassengerId(passengerId);
                if (reservations.isEmpty()) {
                    System.out.println("No reservations found for passenger: " + passengerId);
                }
                for (Reservation reservation : reservations) {
                    reservation.print();
                }
            }

            // show clients
            if (elements[0].equals("sc")) { // ::sc
                for (Passenger passenger: Passenger.getPassengers()) {
                    passenger.print();
                }
            }
        }
    }
}
