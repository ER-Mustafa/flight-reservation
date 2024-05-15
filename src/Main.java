import enums.AirlineCompany;
import enums.AirportCode;
import enums.PlaneModel;
import enums.PlaneType;
import handlers.TerminalHandler;
import system.*;
import handlers.TariffHandler;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TariffHandler tariffHandler = new TariffHandler();

        int[] everyDay = {1, 1, 1, 1, 1, 1, 1};

        Plane airbus1 = new Plane(PlaneType.NARROW_BODY, 65, PlaneModel.AIRBUS_A320);
        Plane airbus2 = new Plane(PlaneType.NARROW_BODY, 65, PlaneModel.AIRBUS_A320);
        Plane boeing1 = new Plane(PlaneType.WIDE_BODY, 300, PlaneModel.BOEING_737);


        Tariff tariff1 = new Tariff(
                PlaneType.NARROW_BODY,
                PlaneModel.AIRBUS_A320,
                AirportCode.ADB,
                AirportCode.IST,
                "12:30",
                "13:20",
                everyDay,
                AirlineCompany.TK,
                "01/01/2024",
                "15/12/2024"
                );

        Tariff tariff2 = new Tariff(
                PlaneType.NARROW_BODY,
                PlaneModel.AIRBUS_A320,
                AirportCode.BER,
                AirportCode.SAW,
                "17:00",
                "19:30",
                everyDay,
                AirlineCompany.TK,
                "01/01/2024",
                "15/12/2024"
        );

        Tariff tariff3 = new Tariff(
                PlaneType.WIDE_BODY,
                PlaneModel.BOEING_737,
                AirportCode.BER,
                AirportCode.IST,
                "10:00",
                "13:00",
                everyDay,
                AirlineCompany.PC,
                "01/01/2024",
                "15/12/2024"
        );

        tariffHandler.handleNewTariff(tariff1.getId());
        tariffHandler.handleNewTariff(tariff2.getId());
        tariffHandler.handleNewTariff(tariff3.getId());

        // CREATE PASSENGERS

        Passenger pass1 = new Passenger(
                "Gorkem",
                22,
                "Varis",
                "Turk",
                "M",
                "12342536475"
        );

        Passenger pass2 = new Passenger(
                "Mustafa",
                32,
                "Er",
                "Turk",
                "M",
                "1234253622"
        );

        Passenger pass3 = new Passenger(
                "Enes Can",
                42,
                "Ulutas",
                "Turk",
                "M",
                "1234253622"
        );

        Passenger pass4 = new Passenger(
                "Bahadir",
                31,
                "Celik",
                "Turk",
                "M",
                "123413513622"
        );

        Passenger pass5 = new Passenger(
                "Samet",
                322,
                "Biber",
                "Turk",
                "M",
                "12232323122"
        );

        Runnable TerminalHandler = new TerminalHandler();
        Thread thread = new Thread(TerminalHandler);
        thread.start();
    }
}