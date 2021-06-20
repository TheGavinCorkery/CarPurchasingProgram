import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean continueRunning = true;
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        ArrayList<Truck> truckList = new ArrayList<Truck>();
        ArrayList<SportUtility> suvList = new ArrayList<SportUtility>();
        ArrayList<Motorcycle> motoList = new ArrayList<Motorcycle>();
        ArrayList<Car> carList = new ArrayList<Car>();

        do {
            int menuSelection = 0;
            menuSelection = displayMenu(menuSelection, input);
            switch(menuSelection){
                case 1:
                    createVehicle(vehicleList, truckList, suvList, motoList, carList);
                    break;
                case 2:
                    printList(vehicleList, truckList, suvList, motoList, carList);
                    break;
                case 3:
                    //Create File
                    createVehicleListFile(vehicleList, truckList, suvList, motoList, carList);
                    continueRunning = false;
                    break;
                case 4:
                    //Exit
                    continueRunning = false;
                    break;
            }



        }while (continueRunning == true);
        System.out.println("Thank you and have a great day!");
    }

    public static int displayMenu(int menuSelection, Scanner input) {
        System.out.println("Please choose from the following options:");
        System.out.println("1. Create a vehicle");
        System.out.println("2. View List");
        System.out.println("3. Print List");
        System.out.println("4. Exit");
        System.out.print("Selection: ");
        menuSelection = input.nextInt();
        return menuSelection;
    }

    /*createVehicle Method to create as many cars as they want.
    With duplicates of one car, only getting input once.
     */
    public static void createVehicle(ArrayList<Vehicle> vehicleList, ArrayList<Truck> truckList, ArrayList<SportUtility> suvList, ArrayList<Motorcycle> motoList, ArrayList<Car> carList) {
        Scanner input = new Scanner(System.in);
        int vehicleType  = 0;

        System.out.println("Enter the type of vehicle you wish to create:");
        System.out.println("1. Truck");
        System.out.println("2. Sport Utility Vehicle(SUV)");
        System.out.println("3. Motorcycle");
        System.out.println("4. Car");
        System.out.print("Selection: ");
        vehicleType = input.nextInt();
        switch(vehicleType) {
            case 1:
                createTruck(vehicleList, truckList);
                break;
            case 2:
                createSUV(vehicleList, suvList);
                break;
            case 3:
                createMotorcycle(vehicleList, motoList);
                break;
            case 4:
                createCar(vehicleList, carList);
                break;
        }
    }

    /*createTruck method to call getGeneralInformation to get all of
    Vehicle class information and then obtain Truck class information
    */
    public static void createTruck(ArrayList<Vehicle> vehicleList, ArrayList<Truck> truckList) {
        Scanner input = new Scanner(System.in);
        Truck truck1 = new Truck();
        vehicleList.add(truck1);
        truckList.add(truck1);
        String model = "";
        int towing = 0;
        int cargo = 0;
        int bedliner = 0;
        String type = "";
        int duplicateAmt = 0;


        System.out.println("Please enter the following information about the truck:");
        getGeneralInfo(vehicleList);

        //Get input for truck class data
        System.out.print("What is the vehicle's model? ");
        model = input.nextLine();
        truckList.get(truckList.size() - 1).setModelName(model);
        truckList.get(truckList.size() - 1).setVehicleType("Truck");

        System.out.print("What is the vehicle's towing capacity in pounds? ");
        towing = input.nextInt();
        truckList.get(truckList.size() - 1).setTowingCapacity(towing);

        System.out.print("What is the vehicle's cargo capacity in pounds? ");
        cargo = input.nextInt();
        truckList.get(truckList.size() - 1).setCargoCapacity(cargo);

        System.out.println("Does the vehicle have a bed liner? ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Selection: ");
        bedliner = input.nextInt();
        truckList.get(truckList.size() - 1).setBedliner(bedliner);
        input.nextLine();

        System.out.print("What is the type of truck? ");
        type = input.nextLine();
        truckList.get(truckList.size() - 1).setType(type);

        System.out.println("How many of the following truck would you like to create?");
        System.out.println("Manufacturer: " + truckList.get(truckList.size() - 1).getManufacturer());
        System.out.println("Price: " + truckList.get(truckList.size() - 1).getPrice());
        System.out.println("Wheels: " + truckList.get(truckList.size() - 1).getWheels());
        System.out.println("Doors: " + truckList.get(truckList.size() - 1).getDoors());
        System.out.println("Horsepower: " + truckList.get(truckList.size() - 1).getHorsepower());
        System.out.println("Passengers: " + truckList.get(truckList.size() - 1).getNumPassengers());
        System.out.println("Crash Rating: " + truckList.get(truckList.size() - 1).getCrashRating());
        System.out.println("Model: " + truckList.get(truckList.size() - 1).getModelName());
        System.out.println("Towing Capacity: " + truckList.get(truckList.size() - 1).getTowingCapacity());
        System.out.println("Cargo Capacity: " + truckList.get(truckList.size() - 1).getCargoCapacity());
        System.out.println("Bedliner: " + truckList.get(truckList.size() - 1).getBedliner());
        System.out.println("Type: " + truckList.get(truckList.size() - 1).getType());

        System.out.print("Number to create: ");
        duplicateAmt = input.nextInt();

        for (int x = 1; x < duplicateAmt; x++) {
            Truck truck = new Truck(model, cargo, towing, type);
            vehicleList.add(truck);
            truckList.add(truck);
            truckList.get(truckList.size() - 1).setVehicleType("Truck");
            truckList.get(truckList.size() - 1).setBedliner(bedliner);
            truckList.get(truckList.size() - 1).setBooleanBedLiner(truckList.get(truckList.size()-2).getBedliner());
            truckList.get(truckList.size() - 1).setManufacturer(truckList.get(truckList.size()-2).getManufacturer());
            truckList.get(truckList.size() - 1).setPrice(truckList.get(truckList.size()-2).getPrice());
            truckList.get(truckList.size() - 1).setWheels(truckList.get(truckList.size()-2).getWheels());
            truckList.get(truckList.size() - 1).setDoors(truckList.get(truckList.size()-2).getDoors());
            truckList.get(truckList.size() - 1).setHorsepower(truckList.get(truckList.size()-2).getHorsepower());
            truckList.get(truckList.size() - 1).setNumPassengers(truckList.get(truckList.size()-2).getNumPassengers());
            truckList.get(truckList.size() - 1).setCrashRating(truckList.get(truckList.size()-2).getCrashRating());
        }
        System.out.println("The system added " + duplicateAmt + " truck(s) to the list!");
    }

    /*
    createSUV will call getGeneralInformation to get Vehicle data
    then get SUV information
     */
    public static void createSUV(ArrayList<Vehicle> vehicleList, ArrayList<SportUtility> suvList) {
        Scanner input = new Scanner(System.in);
        SportUtility suv = new SportUtility();
        vehicleList.add(suv);
        suvList.add(suv);
        String model = "";
        int bench = 0;
        double towing = 0.0;
        int duplicateAmt = 0;

        System.out.println("Please enter all the information about the SUV: ");
        getGeneralInfo(vehicleList);

        //Get input for the car class props
        System.out.print("What is the vehicle's model: ");
        model = input.nextLine();
        suvList.get(suvList.size() - 1).setModelName(model);
        suvList.get(suvList.size() - 1).setVehicleType("SUV");

        System.out.print("How many bench seats?");
        bench = input.nextInt();
        suvList.get(suvList.size() - 1).setNumOfBenchSeats(bench);

        System.out.print("What is the vehicle's towing capacity in pounds?");
        towing = input.nextDouble();
        suvList.get(suvList.size() - 1).setTowingCapacity(towing);

        System.out.println("How many of the following SUV would you like to create?");
        System.out.println("Manufacturer: " + suvList.get(suvList.size() - 1).getManufacturer());
        System.out.println("Price: " + suvList.get(suvList.size() - 1).getPrice());
        System.out.println("Wheels: " + suvList.get(suvList.size() - 1).getWheels());
        System.out.println("Doors: " + suvList.get(suvList.size() - 1).getDoors());
        System.out.println("Horsepower: " + suvList.get(suvList.size() - 1).getHorsepower());
        System.out.println("Passengers: " + suvList.get(suvList.size() - 1).getNumPassengers());
        System.out.println("Crash Rating: " + suvList.get(suvList.size() - 1).getCrashRating());
        System.out.println("Model: " + suvList.get(suvList.size()-1).getModelName());
        System.out.println("Bench Seats: " + suvList.get(suvList.size() - 1).getNumOfBenchSeats());
        System.out.println("Towing Capacity: " + suvList.get(suvList.size() - 1).getTowingCapacity());

        System.out.print("Number to create: ");
        duplicateAmt = input.nextInt();

        for (int x = 1; x < duplicateAmt; x++) {
            SportUtility suv1 = new SportUtility(model, bench, towing);
            suvList.add(suv1);
            vehicleList.add(suv1);
            suvList.get(suvList.size() - 1).setVehicleType("SUV");
            suvList.get(suvList.size() - 1).setManufacturer(suvList.get(suvList.size()-2).getManufacturer());
            suvList.get(suvList.size() - 1).setPrice(suvList.get(suvList.size() - 2).getPrice());
            suvList.get(suvList.size() - 1).setWheels(suvList.get(suvList.size() - 2).getWheels());
            suvList.get(suvList.size() - 1).setDoors(suvList.get(suvList.size() - 2).getDoors());
            suvList.get(suvList.size() - 1).setHorsepower(suvList.get(suvList.size() - 2).getHorsepower());
            suvList.get(suvList.size() - 1).setNumPassengers(suvList.get(suvList.size() - 2).getNumPassengers());
            suvList.get(suvList.size() - 1).setCrashRating(suvList.get(suvList.size() - 2).getCrashRating());
            suvList.get(suvList.size() - 1).setModelName(suvList.get(suvList.size() - 2).getModelName());
            suvList.get(suvList.size() - 1).setNumOfBenchSeats(suvList.get(suvList.size() - 2).getNumOfBenchSeats());
            suvList.get(suvList.size() - 1).setTowingCapacity(suvList.get(suvList.size() - 2).getTowingCapacity());

        }
        System.out.println("The system added " + duplicateAmt + " SUV(s) to the list!");
    }
    /*
    createMotorcycle will call getGeneralInfo to get that information
    then get motorcycle class information
     */
    public static void createMotorcycle(ArrayList<Vehicle> vehicleList, ArrayList<Motorcycle> motoList) {
        Scanner input = new Scanner(System.in);
        Motorcycle moto = new Motorcycle();
        motoList.add(moto);
        vehicleList.add(moto);
        String model = "";
        int sidecar = 0;
        int signallights = 0;
        int radio = 0;
        int duplicateAmt = 0;

        System.out.println("Please enter all the information about the motorcycle: ");
        getGeneralInfo(vehicleList);

        System.out.print("What is the vehicle's model: ");
        model = input.nextLine();
        motoList.get(motoList.size() - 1).setModelName(model);
        motoList.get(motoList.size() - 1).setVehicleType("Moto");

        System.out.println("Does the vehicle have a side car? ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Selection: ");
        sidecar = input.nextInt();
        motoList.get(motoList.size() - 1).setSideCar(sidecar);
        input.nextLine();

        System.out.println("Does the vehicle have signal lights? ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Selection: ");
        signallights = input.nextInt();
        motoList.get(motoList.size() - 1).setSignalLights(signallights);
        input.nextLine();

        System.out.println("Does the vehicle have a radio? ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Selection: ");
        radio = input.nextInt();
        motoList.get(motoList.size() - 1).setRadio(radio);
        input.nextLine();

        System.out.println("How many of the following motorcycle would you like to create?");
        System.out.println("Manufacturer: " + motoList.get(motoList.size() - 1).getManufacturer());
        System.out.println("Price: " + motoList.get(motoList.size() - 1).getPrice());
        System.out.println("Wheels: " + motoList.get(motoList.size() - 1).getWheels());
        System.out.println("Doors: " + motoList.get(motoList.size() - 1).getDoors());
        System.out.println("Horsepower: " + motoList.get(motoList.size() - 1).getHorsepower());
        System.out.println("Passengers: " + motoList.get(motoList.size() - 1).getNumPassengers());
        System.out.println("Crash Rating: " + motoList.get(motoList.size() - 1).getCrashRating());
        System.out.println("Model: " + motoList.get(motoList.size()-1).getModelName());
        System.out.println("Side Car: " + motoList.get(motoList.size() - 1).getSideCar());
        System.out.println("Signal Lights: " + motoList.get(motoList.size() - 1).getSignalLights());
        System.out.println("Radio: " + motoList.get(motoList.size() - 1).getRadio());

        System.out.print("Number to create: ");
        duplicateAmt = input.nextInt();

        for (int x = 1; x < duplicateAmt; x++) {
            Motorcycle moto1 = new Motorcycle(model);
            motoList.add(moto1);
            vehicleList.add(moto1);
            motoList.get(motoList.size() - 1).setVehicleType("Moto");
            motoList.get(motoList.size() - 1).setManufacturer(motoList.get(motoList.size()-2).getManufacturer());
            motoList.get(motoList.size() - 1).setPrice(motoList.get(motoList.size() - 2).getPrice());
            motoList.get(motoList.size() - 1).setWheels(motoList.get(motoList.size() - 2).getWheels());
            motoList.get(motoList.size() - 1).setDoors(motoList.get(motoList.size() - 2).getDoors());
            motoList.get(motoList.size() - 1).setHorsepower(motoList.get(motoList.size() - 2).getHorsepower());
            motoList.get(motoList.size() - 1).setNumPassengers(motoList.get(motoList.size() - 2).getNumPassengers());
            motoList.get(motoList.size() - 1).setCrashRating(motoList.get(motoList.size() - 2).getCrashRating());
            motoList.get(motoList.size() - 1).setModelName(motoList.get(motoList.size() - 2).getModelName());
            motoList.get(motoList.size() - 1).setBooleanSideCar(motoList.get(motoList.size()-2).getSideCar());
            motoList.get(motoList.size() - 1).setBooleanSignalLights(motoList.get(motoList.size()-2).getSignalLights());
            motoList.get(motoList.size() - 1).setSideCar(sidecar);
            motoList.get(motoList.size() - 1).setBooleanRadio(motoList.get(motoList.size()-2).getRadio());
        }
        System.out.println("The system added " + duplicateAmt + " Motorcycle(s) to the list!");

    }

    /*
    createCar will call getGeneralInfo for that data, then get
    car class data
     */
    public static void createCar(ArrayList<Vehicle> vehicleList, ArrayList<Car> carList) {
        Scanner input = new Scanner(System.in);
        Car car = new Car();
        carList.add(car);
        vehicleList.add(car);
        String model = "";
        int convert = 0;
        String engine = "";
        int duplicateAmt = 0;

        System.out.println("Please enter all the information about the car: ");
        getGeneralInfo(vehicleList);
        carList.get(carList.size() - 1).setVehicleType("Car");

        System.out.print("What is the vehicle's model? ");
        model = input.nextLine();
        carList.get(carList.size() - 1).setModelName(model);

        System.out.println("Is the vehicle a convertible? ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Selection: ");
        convert = input.nextInt();
        carList.get(carList.size() - 1).setConvertible(convert);
        input.nextLine();

        System.out.print("What kind of engine does the car have? ");
        engine = input.nextLine();
        carList.get(carList.size() - 1).setEngineType(engine);

        System.out.println("How many of the following car would you like to create?");
        System.out.println("Manufacturer: " + carList.get(carList.size() - 1).getManufacturer());
        System.out.println("Price: " + carList.get(carList.size() - 1).getPrice());
        System.out.println("Wheels: " + carList.get(carList.size() - 1).getWheels());
        System.out.println("Doors: " + carList.get(carList.size() - 1).getDoors());
        System.out.println("Horsepower: " + carList.get(carList.size() - 1).getHorsepower());
        System.out.println("Passengers: " + carList.get(carList.size() - 1).getNumPassengers());
        System.out.println("Crash Rating: " + carList.get(carList.size() - 1).getCrashRating());
        System.out.println("Model: " + carList.get(carList.size()-1).getModelName());
        System.out.println("Convertible: " + carList.get(carList.size() - 1).getConvertible());
        System.out.println("Engine: " + carList.get(carList.size() - 1).getEngineType());

        System.out.print("Number to create: ");
        duplicateAmt = input.nextInt();

        for (int x = 1; x < duplicateAmt; x++) {
            Car car1 = new Car(model, engine);
            carList.add(car1);
            vehicleList.add(car1);
            carList.get(carList.size() - 1).setVehicleType("Car");
            carList.get(carList.size() - 1).setManufacturer(carList.get(carList.size() - 2).getManufacturer());
            carList.get(carList.size() - 1).setPrice(carList.get(carList.size() - 2).getPrice());
            carList.get(carList.size() - 1).setWheels(carList.get(carList.size() - 2).getWheels());
            carList.get(carList.size() - 1).setDoors(carList.get(carList.size() - 2).getDoors());
            carList.get(carList.size() - 1).setHorsepower(carList.get(carList.size() - 2).getHorsepower());
            carList.get(carList.size() - 1).setNumPassengers(carList.get(carList.size() - 2).getNumPassengers());
            carList.get(carList.size() - 1).setCrashRating(carList.get(carList.size() - 2).getCrashRating());
            carList.get(carList.size() - 1).setModelName(carList.get(carList.size() - 2).getModelName());
            carList.get(carList.size() - 1).setBooleanConvert(carList.get(carList.size()-2).getConvertible());
            carList.get(carList.size() - 1).setEngineType(carList.get(carList.size() - 2).getEngineType());
        }
        System.out.println("The system added " + duplicateAmt + " Car(s) to the list!");
    }

    //getGeneralInfo will obtain all Vehicle class information
    public static void getGeneralInfo(ArrayList<Vehicle> vehicleList) {
        Scanner input = new Scanner(System.in);
        int currentIndex = vehicleList.size() - 1;
        double price = 0.0;
        String manufact = "";
        int wheels = 0;
        int doors = 0;
        int hp = 0;
        int passengers = 0;
        int crashRating = 0;

        System.out.print("Who is the manufacturer? ");
        manufact = input.nextLine();
        vehicleList.get(currentIndex).setManufacturer(manufact);


        System.out.print("What is the vehicle's price? ");
        price = input.nextDouble();
        vehicleList.get(currentIndex).setPrice(price);

        System.out.print("How many wheels? ");
        wheels = input.nextInt();
        vehicleList.get(currentIndex).setWheels(wheels);

        System.out.print("How many doors? ");
        doors = input.nextInt();
        vehicleList.get(currentIndex).setDoors(doors);

        System.out.print("How many horsepower does the engine output? ");
        hp = input.nextInt();
        vehicleList.get(currentIndex).setHorsepower(hp);

        System.out.print("How many passengers does it hold? ");
        passengers = input.nextInt();
        vehicleList.get(currentIndex).setNumPassengers(passengers);

        System.out.print("What is its crash rating? ");
        crashRating = input.nextInt();
        vehicleList.get(currentIndex).setCrashRating(crashRating);
    }

    //printList will print out all current vehicles the user has entered
    public static void printList(ArrayList<Vehicle> vehicleList, ArrayList<Truck> truckList, ArrayList<SportUtility> suvList, ArrayList<Motorcycle> motoList, ArrayList<Car> carList) {

        for (int x = 0; x < vehicleList.size(); x++) {
            if(vehicleList.get(x).getVehicleType().equals("Truck")) {
                System.out.println("Manufacturer: " + truckList.get(truckList.size() - 1).getManufacturer());
                System.out.println("Price: " + truckList.get(truckList.size() - 1).getPrice());
                System.out.println("Wheels: " + truckList.get(truckList.size() - 1).getWheels());
                System.out.println("Doors: " + truckList.get(truckList.size() - 1).getDoors());
                System.out.println("Horsepower: " + truckList.get(truckList.size() - 1).getHorsepower());
                System.out.println("Passengers: " + truckList.get(truckList.size() - 1).getNumPassengers());
                System.out.println("Crash Rating: " + truckList.get(truckList.size() - 1).getCrashRating());
                System.out.println("Model: " + truckList.get(truckList.size() - 1).getModelName());
                System.out.println("Towing Capacity: " + truckList.get(truckList.size() - 1).getTowingCapacity());
                System.out.println("Cargo Capacity: " + truckList.get(truckList.size() - 1).getCargoCapacity());
                System.out.println("Bedliner: " + truckList.get(truckList.size() - 1).getBedliner());
                System.out.println("Type: " + truckList.get(truckList.size() - 1).getType());
            }else if (vehicleList.get(x).getVehicleType().equals(("SUV"))) {
                System.out.println("Manufacturer: " + suvList.get(suvList.size() - 1).getManufacturer());
                System.out.println("Price: " + suvList.get(suvList.size() - 1).getPrice());
                System.out.println("Wheels: " + suvList.get(suvList.size() - 1).getWheels());
                System.out.println("Doors: " + suvList.get(suvList.size() - 1).getDoors());
                System.out.println("Horsepower: " + suvList.get(suvList.size() - 1).getHorsepower());
                System.out.println("Passengers: " + suvList.get(suvList.size() - 1).getNumPassengers());
                System.out.println("Crash Rating: " + suvList.get(suvList.size() - 1).getCrashRating());
                System.out.println("Model: " + suvList.get(suvList.size()-1).getModelName());
                System.out.println("Bench Seats: " + suvList.get(suvList.size() - 1).getNumOfBenchSeats());
                System.out.println("Towing Capacity: " + suvList.get(suvList.size() - 1).getTowingCapacity());
            }else if (vehicleList.get(x).getVehicleType().equals("Moto")) {
                System.out.println("Manufacturer: " + motoList.get(motoList.size() - 1).getManufacturer());
                System.out.println("Price: " + motoList.get(motoList.size() - 1).getPrice());
                System.out.println("Wheels: " + motoList.get(motoList.size() - 1).getWheels());
                System.out.println("Doors: " + motoList.get(motoList.size() - 1).getDoors());
                System.out.println("Horsepower: " + motoList.get(motoList.size() - 1).getHorsepower());
                System.out.println("Passengers: " + motoList.get(motoList.size() - 1).getNumPassengers());
                System.out.println("Crash Rating: " + motoList.get(motoList.size() - 1).getCrashRating());
                System.out.println("Model: " + motoList.get(motoList.size()-1).getModelName());
                System.out.println("Side Car: " + motoList.get(motoList.size() - 1).getSideCar());
                System.out.println("Signal Lights: " + motoList.get(motoList.size() - 1).getSignalLights());
                System.out.println("Radio: " + motoList.get(motoList.size() - 1).getRadio());
            }else if (vehicleList.get(x).getVehicleType().equals("Car")) {
                System.out.println("Manufacturer: " + carList.get(carList.size() - 1).getManufacturer());
                System.out.println("Price: " + carList.get(carList.size() - 1).getPrice());
                System.out.println("Wheels: " + carList.get(carList.size() - 1).getWheels());
                System.out.println("Doors: " + carList.get(carList.size() - 1).getDoors());
                System.out.println("Horsepower: " + carList.get(carList.size() - 1).getHorsepower());
                System.out.println("Passengers: " + carList.get(carList.size() - 1).getNumPassengers());
                System.out.println("Crash Rating: " + carList.get(carList.size() - 1).getCrashRating());
                System.out.println("Model: " + carList.get(carList.size()-1).getModelName());
                System.out.println("Convertible: " + carList.get(carList.size() - 1).getConvertible());
                System.out.println("Engine: " + carList.get(carList.size() - 1).getEngineType());
            }
        }
    }

    /*
    createVehicleListFile will create the file with all user entered
    information
     */
    public static void createVehicleListFile(ArrayList<Vehicle> vehicleList, ArrayList<Truck> truckList, ArrayList<SportUtility> suvList, ArrayList<Motorcycle> motoList, ArrayList<Car> carList) throws IOException {
        File file = new File("vehicleList.txt");

        FileWriter myWriter = new FileWriter(file);


        for (int x = 0; x < vehicleList.size(); x++) {
            if(vehicleList.get(x).getVehicleType().equals("Truck")) {
                myWriter.write("\nManufacturer: " + truckList.get(truckList.size() - 1).getManufacturer());
                myWriter.write("\nPrice: " + truckList.get(truckList.size() - 1).getPrice());
                myWriter.write("\nWheels: " + truckList.get(truckList.size() - 1).getWheels());
                myWriter.write("\nDoors: " + truckList.get(truckList.size() - 1).getDoors());
                myWriter.write("\nHorsepower: " + truckList.get(truckList.size() - 1).getHorsepower());
                myWriter.write("\nPassengers: " + truckList.get(truckList.size() - 1).getNumPassengers());
                myWriter.write("\nCrash Rating: " + truckList.get(truckList.size() - 1).getCrashRating());
                myWriter.write("\nModel: " + truckList.get(truckList.size() - 1).getModelName());
                myWriter.write("\nTowing Capacity: " + truckList.get(truckList.size() - 1).getTowingCapacity());
                myWriter.write("\nCargo Capacity: " + truckList.get(truckList.size() - 1).getCargoCapacity());
                myWriter.write("\nBedliner: " + truckList.get(truckList.size() - 1).getBedliner());
                myWriter.write("\nType: " + truckList.get(truckList.size() - 1).getType());
            }else if (vehicleList.get(x).getVehicleType().equals(("SUV"))) {
                myWriter.write("\nManufacturer: " + suvList.get(suvList.size() - 1).getManufacturer());
                myWriter.write("\nPrice: " + suvList.get(suvList.size() - 1).getPrice());
                myWriter.write("\nWheels: " + suvList.get(suvList.size() - 1).getWheels());
                myWriter.write("\nDoors: " + suvList.get(suvList.size() - 1).getDoors());
                myWriter.write("\nHorsepower: " + suvList.get(suvList.size() - 1).getHorsepower());
                myWriter.write("\nPassengers: " + suvList.get(suvList.size() - 1).getNumPassengers());
                myWriter.write("\nCrash Rating: " + suvList.get(suvList.size() - 1).getCrashRating());
                myWriter.write("\nModel: " + suvList.get(suvList.size()-1).getModelName());
                myWriter.write("\nBench Seats: " + suvList.get(suvList.size() - 1).getNumOfBenchSeats());
                myWriter.write("\nTowing Capacity: " + suvList.get(suvList.size() - 1).getTowingCapacity());
            }else if (vehicleList.get(x).getVehicleType().equals("Moto")) {
                myWriter.write("\nManufacturer: " + motoList.get(motoList.size() - 1).getManufacturer());
                myWriter.write("\nPrice: " + motoList.get(motoList.size() - 1).getPrice());
                myWriter.write("\nWheels: " + motoList.get(motoList.size() - 1).getWheels());
                myWriter.write("\nDoors: " + motoList.get(motoList.size() - 1).getDoors());
                myWriter.write("\nHorsepower: " + motoList.get(motoList.size() - 1).getHorsepower());
                myWriter.write("\nPassengers: " + motoList.get(motoList.size() - 1).getNumPassengers());
                myWriter.write("\nCrash Rating: " + motoList.get(motoList.size() - 1).getCrashRating());
                myWriter.write("\nModel: " + motoList.get(motoList.size()-1).getModelName());
                myWriter.write("\nSide Car: " + motoList.get(motoList.size() - 1).getSideCar());
                myWriter.write("\nSignal Lights: " + motoList.get(motoList.size() - 1).getSignalLights());
                myWriter.write("\nRadio: " + motoList.get(motoList.size() - 1).getRadio());
            }else if (vehicleList.get(x).getVehicleType().equals("Car")) {
                myWriter.write("\nManufacturer: " + carList.get(carList.size() - 1).getManufacturer());
                myWriter.write("\nPrice: " + carList.get(carList.size() - 1).getPrice());
                myWriter.write("\nWheels: " + carList.get(carList.size() - 1).getWheels());
                myWriter.write("\nDoors: " + carList.get(carList.size() - 1).getDoors());
                myWriter.write("\nHorsepower: " + carList.get(carList.size() - 1).getHorsepower());
                myWriter.write("\nPassengers: " + carList.get(carList.size() - 1).getNumPassengers());
                myWriter.write("\nCrash Rating: " + carList.get(carList.size() - 1).getCrashRating());
                myWriter.write("\nModel: " + carList.get(carList.size()-1).getModelName());
                myWriter.write("\nConvertible: " + carList.get(carList.size() - 1).getConvertible());
                myWriter.write("\nEngine: " + carList.get(carList.size() - 1).getEngineType());
            }
        }
        myWriter.close();
        System.out.println("The program has written the file for you.");
    }

}
