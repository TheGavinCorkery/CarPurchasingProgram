public class Car extends Vehicle{
    private String modelName;
    private boolean convertible;
    private String engineType;
    private int rawConvert;

    Car() {

    }

    Car(String modelName, String engineType) {
        this.modelName = modelName;
        this.engineType = engineType;
    }

    //Getters
    public String getModelName() {
        return this.modelName;
    }
    public boolean getConvertible() {
        return this.convertible;
    }
    public int getBoolConvert() {
        return this.rawConvert;
    }
    public String getEngineType() {
        return this.engineType;
    }
    //Setters
    public void setBooleanConvert(boolean r) {
        this.convertible = r;
    }
    public void setModelName(String m) {
        this.modelName = m;
    }
    public boolean setConvertible(int c) {
        this.rawConvert = c;
        if (c == 1) {
            this.convertible = true;
            return true;
        }else if (c == 2) {
            this.convertible = false;
            return true;

        }else {
            System.out.println("Invalid input. Please try again.");
            return false;
        }
    }
    public void setEngineType(String e) {
        this.engineType = e;
    }
}

