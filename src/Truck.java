public class Truck extends Vehicle{
    private String modelName;
    private double cargoCapacity;
    private double towingCapacity;
    private boolean bedliner;
    private String type;

    Truck() {

    }

    Truck(String modelName, double cargoCapacity, double towingCapacity, String type) {
        this.modelName = modelName;
        this.cargoCapacity = cargoCapacity;
        this.towingCapacity = towingCapacity;
        this.type = type;
    }

    //Getters
    public String getModelName() {
        return this.modelName;
    }
    public String getType() {
        return this.type;
    }
    public double getCargoCapacity() {
        return this.cargoCapacity;
    }
    public double getTowingCapacity() {
        return this.towingCapacity;
    }
    public boolean getBedliner() {
        return this.bedliner;
    }
    //Setters
    public void setBooleanBedLiner(boolean b) {
        this.bedliner = b;
    }
    public void setModelName(String m) {
        this.modelName = m;
    }
    public boolean setCargoCapacity(double c) {
        if (c < 0) {
            System.out.println("Cargo capacity must be greater than 0");
            return false;
        }else {
            this.cargoCapacity = c;
            return true;
        }
    }
    public boolean setTowingCapacity(double t) {
        if (t < 0) {
            System.out.println("Towing capacity must be greater than 0");
            return false;
        }else {
            this.towingCapacity = t;
            return false;
        }
    }
    public boolean setBedliner(int b) {
        if (b == 1) {
            this.bedliner = true;
            return true;
        }else if (b == 2) {
            this.bedliner = false;
            return true;
        }else {
            System.out.println("Invalid input. Please try again.");
            return false;
        }

    }
    public void setType(String t) {
        this.type = t;
    }
}
