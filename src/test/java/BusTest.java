import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BusTest {

    private Bus bus;
    private Person person;
    private BusStop busStop;

    @Before
    public void before(){
        bus = new Bus("Dalgety Bay");
        person = new Person();
        busStop = new BusStop("Main Street");
        busStop.addPerson(person);
        busStop.addPerson(person);
        busStop.addPerson(person);
        busStop.addPerson(person);
    }

    @Test
    public void hasDestination(){
        assertEquals("Dalgety Bay", bus.getDestination());
    }

    @Test
    public void hasCapacity(){
        assertEquals(2, bus.getCapacity());
    }

    @Test
    public void startsWithNoPassengers(){
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void canAddPassenger(){
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
    }

    @Test
    public void canNotAddPassenger(){
        bus.addPassenger(person);
        bus.addPassenger(person);
        bus.addPassenger(person);
        assertEquals(2, bus.passengerCount());
    }

    @Test
    public void canRemovePassenger(){
        bus.addPassenger(person);
        assertEquals(1, bus.passengerCount());
        bus.removePassenger();
        assertEquals(0, bus.passengerCount());
    }

    @Test
    public void pickUpPassengerFromBusStop(){
        bus.pickUpPassenger(busStop);
        assertEquals(1, bus.passengerCount());

    }
}
