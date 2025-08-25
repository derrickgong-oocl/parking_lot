import java.util.ArrayList;

public class SmartParkingBoy extends ParkingBoy{

    public ArrayList<ParkingLot> parkingLotlist;

    public SmartParkingBoy(ArrayList<ParkingLot> parkingLotlist) {
        this.parkingLotlist = parkingLotlist;
    }

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


}
