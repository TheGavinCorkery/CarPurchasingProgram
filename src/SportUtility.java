public class SportUtility extends Vehicle{
    private String modelName;
    private int numOfBenchSeats;
    private double towingCapacity;

    SportUtility() {

    }

    SportUtility(String modelName, int numOfBenchSeats, double towingCapacity) {
        this.modelName = modelName;
        this.numOfBenchSeats = numOfBenchSeats;
        this.towingCapacity = towingCapacity;
    }

    //Getters
    public String getModelName() {
        return this.modelName;
    }
    public int getNumOfBenchSeats() {
        return this.numOfBenchSeats;
    }
    public double getTowingCapacity() {
        return this.towingCapacity;
    }
    //Setters
    public void setModelName(String m) {
        this.modelName = m;
    }
    public boolean setTowingCapacity(double t) {
        if (t < 0) {
            System.out.println("Towing capacity must be greater than 0");
            return false;
        }else {
            this.towingCapacity = t;
            return true;
        }
    }
    public boolean setNumOfBenchSeats(int b) {
        if (b < 1 || b > 6) {
            System.out.println("Number of bench seats must be between 1 and 6.");
            return false;
        }else {
            this.numOfBenchSeats = b;
            return true;
        }
    }
}
