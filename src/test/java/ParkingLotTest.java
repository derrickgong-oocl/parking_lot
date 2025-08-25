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

        Car fetchCar = parkinglot.fetch(ticket);

        assertNotNull(fetchCar);
    }

    @Test
    void test_fetch_wrong_ticket() {
        ParkingLot parkinglot = new ParkingLot(10);
        Car car = new Car("abc");
        parkinglot.park(car);

        Ticket wrongTicket = new Ticket("123");


        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> parkinglot.fetch(wrongTicket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void test_fetch_used_ticket() {
        ParkingLot parkinglot = new ParkingLot(10);
        Car car = new Car("123");
        Ticket ticket = parkinglot.park(car);
        Car fetchCar = parkinglot.fetch(ticket);

        assertNotNull(fetchCar);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> parkinglot.fetch(ticket));
        assertEquals("Unrecognized parking ticket", exception.getMessage());
    }

    @Test
    void test_park_no_position() {
        ParkingLot parkinglot = new ParkingLot(1);
        Car car = new Car("123");
        Car secondCar = new Car("321");
        parkinglot.park(car);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> parkinglot.park(secondCar));
        assertEquals("No available position", exception.getMessage());
    }

    @Test
    void test_fetch_car_twice() {
        ParkingLot parkinglot = new ParkingLot(10);
        Car carA = new Car("a");
        Car carB = new Car("b");
        Ticket ticketA = parkinglot.park(carA);
        Ticket ticketB = parkinglot.park(carB);

        Car fetchCarA = parkinglot.fetch(ticketA);
        Car fetchCarB = parkinglot.fetch(ticketB);

        assertNotNull(fetchCarA);
        assertNotNull(fetchCarB);
    }








}
