import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class mainTest {
    Vehicle testVehicle = new Vehicle();
    Truck testTruck = new Truck();
    Car testCar = new Car();
    Motorcycle testMoto = new Motorcycle();
    SportUtility testSUV = new SportUtility();

    @Before
    public void setUp() {
        Vehicle testVehicle = new Vehicle();
        Truck testTruck = new Truck();
        Car testCar = new Car();
        Motorcycle testMoto = new Motorcycle();
        SportUtility testSUV = new SportUtility();
    }

    @Test
    public void truckGetters_returnsCorrectValue() {
        int expectedCargoValue = 5000;
        String expectedMake = "F150";
        String expectedType = "Passenger";

        testTruck.setCargoCapacity(5000);
        testTruck.setTowingCapacity(5000);
        testTruck.setModelName("F150");
        testTruck.setType("Passenger");


        assertEquals(expectedCargoValue, testTruck.getCargoCapacity());
        assertEquals(expectedCargoValue, testTruck.getTowingCapacity());
        assertEquals(expectedMake, testTruck.getModelName());
        assertEquals(expectedType, testTruck.getType());
    }

    @Test
    public void carGetters_returnsCorrectValue() {
        String expectedModel = "Honda";
        String expectedEngine = "V6";
        int expectedConvert = 1;

        testCar.setModelName("Honda");
        testCar.setEngineType("V6");
        testCar.setConvertible(1);

        assertEquals(expectedModel, testCar.getModelName());
        assertEquals(expectedEngine, testCar.getEngineType());
        assertEquals(expectedConvert, testCar.getBoolConvert());
    }

    //Test for moto correct getter values
    @Test
    public void motoGetters_returnsCorrectValue() {
        String expectedModel = "Kawasaki";

        testMoto.setModelName("Kawasaki");

        assertEquals(expectedModel, testMoto.getModelName());
    }

    //Test for SUV correct getter values
    @Test
    public void suvGetters_returnsCorrectValue() {
        String expectedModel = "GMC";
        int expectedBench = 3;
        double expectedTowing = 8000;

        testSUV.setModelName(expectedModel);
        testSUV.setNumOfBenchSeats(3);
        testSUV.setTowingCapacity(8000);

        assertEquals(expectedModel, testSUV.getModelName());
        assertEquals(expectedBench, testSUV.getNumOfBenchSeats());
        assertEquals(expectedTowing, testSUV.getTowingCapacity());
    }

    @Test
    public void vehicleGetters_returnsCorrectValue() {
        int expectedDoors = 4;
        int expectedWheels = 4;
        int expectedHorsepower = 450;
        int expectedPassengers = 5;
        double expectedPrice = 23000;
        String expectedManu = "Ford";
        int expectedCrash = 5;
        String expectedType = "Car";

        testVehicle.setDoors(4);
        testVehicle.setWheels(4);
        testVehicle.setHorsepower(450);
        testVehicle.setNumPassengers(5);
        testVehicle.setPrice(23000);
        testVehicle.setManufacturer("Ford");
        testVehicle.setCrashRating(5);
        testVehicle.setVehicleType("Car");

        assertEquals(expectedDoors, testVehicle.getDoors());
        assertEquals(expectedWheels, testVehicle.getWheels());
        assertEquals(expectedHorsepower, testVehicle.getHorsepower());
        assertEquals(expectedPassengers, testVehicle.getNumPassengers());
        assertEquals(expectedPrice, testVehicle.getPrice());
        assertEquals(expectedManu, testVehicle.getManufacturer());
        assertEquals(expectedCrash, testVehicle.getCrashRating());
        assertEquals(expectedType, testVehicle.getVehicleType());
    }
}
