import java.util.ArrayList;

public class SuperParkingBoy {

    public ArrayList<ParkingLot> parkingLotlist;
    public SuperParkingBoy(ArrayList<ParkingLot> parkingLotlist) {
        this.parkingLotlist = parkingLotlist;
    }

    public Ticket park(Car car) {
        ParkingLot toPark = parkingLotlist.get(0);
        float positionRate = (toPark.capacity - toPark.carList.size()) / toPark.capacity;
        for (ParkingLot curr : parkingLotlist) {
            float curr_rate = (curr.capacity - curr.carList.size()) / curr.capacity;
            if (curr_rate > positionRate) {
                toPark = curr;
                positionRate = curr_rate;
            }
        }
        return toPark.park(car);
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
