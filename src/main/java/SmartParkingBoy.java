import java.util.ArrayList;

public class SmartParkingBoy extends ParkingBoy {

    public ArrayList<ParkingLot> parkingLotlist;

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLotlist) {
        this.parkingLotlist = parkingLotlist;
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot toPark = parkingLotlist.get(0);
        int postionLeft = toPark.capacity - toPark.carList.size();
        for (ParkingLot curr : parkingLotlist) {
            int currPosLeft = curr.capacity - curr.carList.size();
            if (currPosLeft > postionLeft) {
                toPark = curr;
                postionLeft = currPosLeft;
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
