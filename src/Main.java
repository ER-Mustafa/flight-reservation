import enums.AirlineCompany;
import enums.AirportCode;
import enums.PlaneModel;
import enums.PlaneType;
import handlers.TerminalHandler;
import system.Flight;
import system.Plane;
import system.Tariff;
import handlers.TariffHandler;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TariffHandler tariffHandler = new TariffHandler();

        Plane airbus = new Plane(PlaneType.NARROW_BODY, 65, PlaneModel.AIRBUS_A320);
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

        tariffHandler.handleNewTariff(tariff.getId());

        for (Flight flight : Flight.getFlights()) {
            flight.print();
        }

        Runnable TerminalHandler = new TerminalHandler();
        Thread thread = new Thread(TerminalHandler);
        thread.start();
    }
}