import enums.AirlineCompany;
import enums.AirportCode;
import enums.PlaneModel;
import enums.PlaneType;
import system.Tariff;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Create planes.

        int[] everyDay = {1, 1, 1, 1, 1, 1, 1};
        Tariff tariff = new Tariff(
                PlaneType.NARROW_BODY,
                PlaneModel.AIRBUS_A320,
                AirportCode.ADB,
                AirportCode.IST,
                "12:30",
                "13:20",
                everyDay,
                AirlineCompany.TK,
                "03/05/2024",
                "07/05/2024"
                );

        // Create flights.

        // Take reservations with a handler.
    }
}