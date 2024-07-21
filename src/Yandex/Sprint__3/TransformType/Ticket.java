package Yandex.Sprint__3.TransformType;

import java.util.ArrayList;

public class Ticket {


    public static void main(String[] args) {
        ArrayList<Bus> buses = new ArrayList<>();
        Bus bus = new Bus(23765);
        String[] passengersTimestamps = new String[]{
                "08:33",
                "09:42",
                "10:43",
                "17:59",
                "18:01",
                "19:15"
        };

        for (int i = 0; i < passengersTimestamps.length; i++) {
            increaseTicketNumber(bus);
            System.out.println("Оплата поездки в " + passengersTimestamps[i]
                    + ". Номер билета: " + bus.ticketNumber);
        }

        System.out.println(buses.toString());
    }

    private static Bus increaseTicketNumber(Bus bus) {
        bus.ticketNumber++;
        // вставьте код для увеличения номера билета
        return bus;
    }

}

class Bus {
    public Bus(int initialNumber) {
        ticketNumber = initialNumber;
    }

    int ticketNumber;

    @Override
    public String toString() {
        return "Bus{" +
                "ticketNumber=" + ticketNumber +
                '}';
    }
}
