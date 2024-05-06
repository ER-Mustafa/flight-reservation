package handlers;

import system.Flight;
import system.Plane;
import system.Tariff;

import java.text.SimpleDateFormat;
import java.util.*;

public class TariffHandler {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    public TariffHandler() {}

    public void handleNewTariff(int tariffId) {
        Tariff tariff = Tariff.getTariff(tariffId);

        if (tariff == null) {
            System.out.println("No Tariff with ID " + tariffId);
            return;
        }

        try {
            Date startDate = sdf.parse(tariff.getPeriodStart());
            Date endDate = sdf.parse(tariff.getPeriodEnd());
            List<String> dateArray = getDateArray(startDate, endDate);

            for (String date : dateArray) {
                int planeId = Plane.getPlaneForDate(date, tariff.getPlaneType(), tariff.getPlaneModel());
                if (planeId == -1) {
                    System.err.printf("For the date: %s and the tariff id: %d , there is no available plane\n", date, tariffId);
                } else {
                    Flight newFlight = new Flight(tariffId, date, planeId, tariff.getAirlineCompany());
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private List<String> getDateArray(Date startDate, Date endDate) {

        List<String> dateArray = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);

        while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
            dateArray.add(sdf.format(calendar.getTime()));
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dateArray;
    }
}
