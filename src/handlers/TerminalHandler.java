package handlers;

import system.Flight;
import system.Passenger;

import java.util.Scanner;

public class TerminalHandler implements Runnable {
    /*
    * HANDBOOK
    * COMMANDS:
    *
    * exit
    * query date: queries flights on this date --- date format DD/MM/YYYY
    * create-user
    * book flightNumber for passengerId
    * capacity flightNumber
    * show-reservations passengerId
    * show-ticket passengerId
    *
    * */

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

            if (elements[0].equals("query")) {
                String date = elements[1];
                Flight.printFlightsByDate(date);
            }

            if (elements[0].equals("create-user")) {
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
        }
    }
}
