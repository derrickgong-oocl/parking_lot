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
        Ticket ticket = parkinglot.park(car);

        Ticket wrong_ticket = new Ticket("123");
        Car fetch_car = parkinglot.fetch(wrong_ticket);

        assertNull(fetch_car);
    }

    @Test
    void test_fetch_used_ticket() {
        ParkingLot parkinglot = new ParkingLot(10);
        Car car = new Car("123");
        Ticket ticket = parkinglot.park(car);
        Car fetch_car = parkinglot.fetch(ticket);
        Car fetch_tmp = parkinglot.fetch(ticket);

        assertNotNull(fetch_car);
        assertNull(fetch_tmp);
    }

    @Test
    void test_park_no_position() {
        ParkingLot parkinglot = new ParkingLot(1);
        Car car = new Car("123");
        Car second_car = new Car("321");
        Ticket first_ticket = parkinglot.park(car);
        Ticket second_ticket = parkinglot.park(second_car);

        assertNull(second_ticket);
    }




}
