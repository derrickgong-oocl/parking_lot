import java.util.ArrayList;

public class ParkingLot {
    private int capacity;
    ArrayList<Car> car_list;
    ArrayList<Ticket> ticket_list;


    public ParkingLot(int capacity) {
        this.car_list = new ArrayList<Car>(capacity);
        this.capacity = capacity;
        this.ticket_list = new ArrayList<Ticket>(capacity);
    }

    public Ticket park(Car car) {
        if (car_list.size() >= capacity) {
            return null;
        }
        car_list.add(car);
        Ticket ticket = new Ticket(car.id);
        ticket_list.add(ticket);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if (!ticket_list.contains(ticket)) {
            return null;
        }
        int index = ticket_list.indexOf(ticket);
        ticket_list.remove(index);
        Car car = car_list.get(index);
        car_list.remove(index);

        return car;
    }
}
