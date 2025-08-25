import java.util.ArrayList;

public class ParkingBoy {
    public ArrayList<ParkingLot> parkingLotlist;

    public ParkingBoy() {
        this.parkingLotlist = new ArrayList<ParkingLot>();
    }

    public ParkingBoy(ArrayList<ParkingLot> parkingLotlist) {
        this.parkingLotlist = parkingLotlist;
    }

    public Ticket park(Car car) {
        for (ParkingLot curr : parkingLotlist) {
            if (curr.carList.size() < curr.capacity) {
                return curr.park(car);
            }
        }
        throw new IllegalArgumentException("No available position");
    }

    public Car fetch(Ticket ticket) {
        for (ParkingLot curr : parkingLotlist) {
            if (curr.ticketList.contains(ticket)) {
                return curr.fetch(ticket);
            }
        }
        throw new IllegalArgumentException("Unrecognized parking ticket");
    }
}
