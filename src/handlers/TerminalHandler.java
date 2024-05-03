package handlers;

import system.Flight;

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

            if (elements[0].equals("query")) {
                String date = elements[1];
                Flight.printFlightsByDate(date);
            }
        }
    }
}
