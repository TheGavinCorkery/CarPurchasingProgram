public class Vehicle {
    private int doors;
    private int wheels;
    private int horsepower;
    private int numPassengers;
    private double price;
    private String manufacturer;
    private int crashRating;
    private String vehicleType  = "";

    /*I chose not to create a constructor for this class because
    there is no need for it. A user should be creating a sub-class
    of Vehicle. No actual Vehicle object will be created.
     */
    //Getters
    public String getVehicleType() {
        return this.vehicleType;
    }
    public int getDoors() {
        return this.doors;
    }
    public int getWheels() {
        return this.wheels;
    }
    public int getHorsepower() {
        return this.horsepower;
    }
    public int getNumPassengers() {
        return this.numPassengers;
    }

    public int getCrashRating() {
        return this.crashRating;
    }
    public String getManufacturer() {
        return this.manufacturer;
    }
    public double getPrice() {
        return this.price;
    }
    //Setter
    public void setVehicleType(String v) {
        this.vehicleType = v;
    }
    public boolean setPrice(double p) {
        if (p < 0) {
            System.out.println("Price must be over 0.");
            return false;
        } else {
            this.price = p;
            return true;
        }
    }
    public boolean setDoors(int d) {
        if (d < 0 || d > 8) {
            System.out.println("Doors must be between 0 and 8");
            return false;
        }else {
            this.doors = d;
            return true;
        }
    }
    public boolean setWheels(int w) {
        if (w < 2 || w > 8) {
            System.out.println("Wheels must be between 2 and 8.");
            return false;
        }else {
            this.wheels = w;
            return true;
        }
    }
    public boolean setHorsepower(int h) {
        if (h < 100) {
            System.out.println("Horsepower must be greater than 100");
            return false;
        }else {
            this.horsepower = h;
            return true;
        }
    }
    public boolean setNumPassengers(int p) {
        if (p < 0) {
            System.out.println("Number of passengers must be greater than 0.");
            return false;
        } else {
            this.numPassengers = p;
            return true;
        }
    }
    public void setManufacturer(String m) {
        this.manufacturer = m;
    }
    public boolean setCrashRating(int c) {
        if (c > 5 || c < 0) {
            System.out.println("Crash rating must be between 0 and 5.");
            return false;
        }else {
            this.crashRating = c;
            return true;
        }
    }
}

