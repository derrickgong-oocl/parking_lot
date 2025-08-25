import java.util.ArrayList;

public class ParkingLot {
    private final int capacity;
    ArrayList<Car> carList;
    ArrayList<Ticket> ticketList;


    public ParkingLot(int capacity) {
        this.carList = new ArrayList<>(capacity);
        this.capacity = capacity;
        this.ticketList = new ArrayList<>(capacity);
    }

    public Ticket park(Car car) {
        if (carList.size() >= capacity) {
            throw new IllegalArgumentException("No available position");
        }
        carList.add(car);
        Ticket ticket = new Ticket(car.id);
        ticketList.add(ticket);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if (!ticketList.contains(ticket)) {
            throw new IllegalArgumentException("Unrecognized parking ticket");
        }
        int index = ticketList.indexOf(ticket);
        ticketList.remove(index);
        Car car = carList.get(index);
        carList.remove(index);

        return car;
    }
}
