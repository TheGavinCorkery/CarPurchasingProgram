public class Motorcycle extends Vehicle{
    private String modelName;
    private boolean sideCar;
    private boolean signalLights;
    private boolean radio;

    Motorcycle() {

    }

    Motorcycle(String modelName) {

    }

    //Getters
    public String getModelName() {
        return this.modelName;
    }
    public boolean getSideCar() {
        return this.sideCar;
    }
    public boolean getSignalLights() {
        return this.signalLights;
    }
    public boolean getRadio() {
        return this.radio;
    }
    //Setters
    public void setModelName(String m) {
        this.modelName = m;
    }
    public void setBooleanSideCar(boolean b) {
        this.sideCar = b;
    }
    public void setBooleanSignalLights(boolean s) {
        this.signalLights = s;
    }
    public void setBooleanRadio(boolean r) {
        this.radio = r;
    }
    public boolean setSideCar(int c) {
        if (c == 1) {
            this.sideCar = true;
            return true;
        }else if (c == 2) {
            this.sideCar = false;
            return true;
        }else {
            System.out.println("Invalid input. Please try again.");
            return false;
        }

    }
    public boolean setSignalLights(int s) {
        if (s == 1) {
           this.signalLights = true;
           return true;
        }else if (s == 2) {
            this.signalLights = false;
            return true;
        }else {
            System.out.println("Invalid input. Please try again.");
            return false;
        }

    }
    public boolean setRadio(int r) {
        if (r == 1) {
            this.radio = true;
            return true;
        }else if (r == 2) {
            this.radio = false;
            return true;
        }else {
            System.out.println("Invalid input. Please try again.");
            return false;
        }
    }
}
