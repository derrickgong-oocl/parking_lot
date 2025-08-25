import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void test_parking_boy_fetch_ticket() {
        ArrayList<ParkingLot> parkinglotlist = new ArrayList<>();
        ParkingLot parkinglot = new ParkingLot(10);

        parkinglotlist.add(parkinglot);

        ParkingBoy parkingBoy = new ParkingBoy(parkinglotlist);
        Car car = new Car("abc");
        Ticket ticket = parkingBoy.park(car);

        assertNotNull(ticket);
    }

    @Test
    void test_parking_boy_fetch_car() {
        ArrayList<ParkingLot> parkinglotlist = new ArrayList<>();
        ParkingLot parkinglot = new ParkingLot(10);
        parkinglotlist.add(parkinglot);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglotlist);
        Car car = new Car("abc");
        Ticket ticket = parkingBoy.park(car);

        Car fetchCar = parkinglot.fetch(ticket);

        assertNotNull(fetchCar);
    }

    @Test
    void test_parking_boy_fetch_wrong_ticket() {
        ArrayList<ParkingLot> parkinglotlist = new ArrayList<>();
        ParkingLot parkinglot = new ParkingLot(10);
        parkinglotlist.add(parkinglot);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglotlist);
        Car car = new Car("abc");
        parkingBoy.park(car);

        Ticket wrongTicket = new Ticket("123");


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> parkingBoy.fetch(wrongTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void test_parking_boy_fetch_used_ticket() {
        ArrayList<ParkingLot> parkinglotlist = new ArrayList<>();
        ParkingLot parkinglot = new ParkingLot(10);
        parkinglotlist.add(parkinglot);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglotlist);
        Car car = new Car("123");
        Ticket ticket = parkingBoy.park(car);
        Car fetchCar = parkingBoy.fetch(ticket);

        assertNotNull(fetchCar);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> parkingBoy.fetch(ticket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void test_parking_boy_park_no_position() {
        ArrayList<ParkingLot> parkinglotlist = new ArrayList<>();
        ParkingLot parkinglot = new ParkingLot(1);
        parkinglotlist.add(parkinglot);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglotlist);
        Car car = new Car("123");
        Car secondCar = new Car("321");
        parkingBoy.park(car);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> parkingBoy.park(secondCar));
        assertEquals("No available position", exception.getMessage());
    }

    @Test
    void test_parking_boy_fetch_car_twice() {
        ArrayList<ParkingLot> parkinglotlist = new ArrayList<>();
        ParkingLot parkinglot = new ParkingLot(10);
        parkinglotlist.add(parkinglot);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglotlist);
        Car carA = new Car("a");
        Car carB = new Car("b");
        Ticket ticketA = parkingBoy.park(carA);
        Ticket ticketB = parkingBoy.park(carB);

        Car fetchCarA = parkingBoy.fetch(ticketA);
        Car fetchCarB = parkingBoy.fetch(ticketB);

        assertNotNull(fetchCarA);
        assertNotNull(fetchCarB);
    }


    @Test
    void test_parking_boy_park_second_lot() {
        ArrayList<ParkingLot> parkinglotlist = new ArrayList<>();
        ParkingLot parkinglotFirst = new ParkingLot(1);
        ParkingLot parkinglotSecond = new ParkingLot(10);
        parkinglotlist.add(parkinglotFirst);
        parkinglotlist.add(parkinglotSecond);

        ParkingBoy parkingBoy = new ParkingBoy(parkinglotlist);
        Car carA = new Car("a");
        Car carB = new Car("b");

        Ticket ticketA = parkingBoy.park(carA);
        Ticket ticketB = parkingBoy.park(carB);


        assertNotNull(ticketA);
        assertNotNull(ticketB);
        assertEquals(parkingBoy.parkingLotlist.get(0).carList.get(0), carA);
        assertEquals(parkingBoy.parkingLotlist.get(1).carList.get(0), carB);
    }

    @Test
    void test_smart_parking_boy_park() {
        ArrayList<ParkingLot> parkinglotlist = new ArrayList<>();
        ParkingLot parkinglotFirst = new ParkingLot(5);
        ParkingLot parkinglotSecond = new ParkingLot(5);
        ParkingLot parkinglotThird = new ParkingLot(5);
        parkinglotFirst.park(new Car("a"));
        parkinglotSecond.park(new Car("b"));

        parkinglotlist.add(parkinglotFirst);
        parkinglotlist.add(parkinglotSecond);
        parkinglotlist.add(parkinglotThird);

        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkinglotlist);



        Car tmpCar = new Car("c");
        Ticket ticket = smartParkingBoy.park(tmpCar);



        assertNotNull(ticket);
        assertEquals(smartParkingBoy.parkingLotlist.get(2).carList.get(0), tmpCar);
    }



}
