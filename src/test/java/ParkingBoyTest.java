import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void test_parking_boy_fetch_ticket() {
        ParkingLot parkinglot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car = new Car("abc");
        Ticket ticket = parkingBoy.park(car);

        assertNotNull(ticket);
    }

    @Test
    void test_parking_boy_fetch_car() {
        ParkingLot parkinglot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car = new Car("abc");
        Ticket ticket = parkingBoy.park(car);

        Car fetch_car = parkinglot.fetch(ticket);

        assertNotNull(fetch_car);
    }

    @Test
    void test_parking_boy_fetch_wrong_ticket() {
        ParkingLot parkinglot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car = new Car("abc");
        parkingBoy.park(car);

        Ticket wrong_ticket = new Ticket("123");


        assertThrows(IllegalArgumentException.class, () -> parkingBoy.fetch(wrong_ticket));
    }

    @Test
    void test_parking_boy_fetch_used_ticket() {
        ParkingLot parkinglot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car = new Car("123");
        Ticket ticket = parkingBoy.park(car);
        Car fetch_car = parkingBoy.fetch(ticket);

        assertNotNull(fetch_car);
        assertThrows(IllegalArgumentException.class, () -> parkingBoy.fetch(ticket));
    }

    @Test
    void test_park_no_position() {
        ParkingLot parkinglot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car car = new Car("123");
        Car second_car = new Car("321");
        parkingBoy.park(car);

        assertThrows(IllegalArgumentException.class, () -> parkingBoy.park(second_car));
    }

    @Test
    void test_fetch_car_twice() {
        ParkingLot parkinglot = new ParkingLot(10);
        ParkingBoy parkingBoy = new ParkingBoy(parkinglot);
        Car carA = new Car("a");
        Car carB = new Car("b");
        Ticket ticketA = parkingBoy.park(carA);
        Ticket ticketB = parkingBoy.park(carB);

        Car fetch_carA = parkingBoy.fetch(ticketA);
        Car fetch_carB = parkingBoy.fetch(ticketB);

        assertNotNull(fetch_carA);
        assertNotNull(fetch_carB);
    }


}
