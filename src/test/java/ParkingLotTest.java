import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void test_fetch_ticket() {

        ParkingLot parkinglot = new ParkingLot(10);
        Car car = new Car("abc");
        Ticket ticket = parkinglot.park(car);

        assertNotNull(ticket);
    }

    @Test
    void test_fetch_car() {
        ParkingLot parkinglot = new ParkingLot(10);
        Car car = new Car("abc");
        Ticket ticket = parkinglot.park(car);

        Car fetch_car = parkinglot.fetch(ticket);

        assertNotNull(fetch_car);
    }

    @Test
    void test_fetch_wrong_ticket() {
        ParkingLot parkinglot = new ParkingLot(10);
        Car car = new Car("abc");
        parkinglot.park(car);

        Ticket wrong_ticket = new Ticket("123");


        assertThrows(IllegalArgumentException.class, () -> parkinglot.fetch(wrong_ticket));
    }

    @Test
    void test_fetch_used_ticket() {
        ParkingLot parkinglot = new ParkingLot(10);
        Car car = new Car("123");
        Ticket ticket = parkinglot.park(car);
        Car fetch_car = parkinglot.fetch(ticket);

        assertNotNull(fetch_car);
        assertThrows(IllegalArgumentException.class, () -> parkinglot.fetch(ticket));
    }

    @Test
    void test_park_no_position() {
        ParkingLot parkinglot = new ParkingLot(1);
        Car car = new Car("123");
        Car second_car = new Car("321");
        parkinglot.park(car);

        assertThrows(IllegalArgumentException.class, () -> parkinglot.park(second_car));
    }

    @Test
    void test_fetch_car_twice() {
        ParkingLot parkinglot = new ParkingLot(10);
        Car carA = new Car("a");
        Car carB = new Car("b");
        Ticket ticketA = parkinglot.park(carA);
        Ticket ticketB = parkinglot.park(carB);

        Car fetch_carA = parkinglot.fetch(ticketA);
        Car fetch_carB = parkinglot.fetch(ticketB);

        assertNotNull(fetch_carA);
        assertNotNull(fetch_carB);
    }








}
