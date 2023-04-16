public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int odometer;
    protected String registrationPlate;
    protected boolean available;

    public Vehicle(String make, String model, String registrationPlate, int odometer) {
        this.make = make;
        this.model = model;
        this.odometer = odometer;
        this.registrationPlate = registrationPlate;
        this.available = true;
    }

    /**
     * @return String make
     */
    public String getMake() {
        return make;
    }

    /**
     * @return String model
     */
    public String getModel() {
        return model;
    }

    /**
     * @return int odometer
     */
    public int getOdometer() {
        return odometer;
    }

    /**
     * @return String registrationPlate
     */
    public String getRegistrationPlate() {
        return registrationPlate;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    /**
     * @return boolean available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * sets Vehicle param available false
     */
    public void setAvailableFalse(){
        available = false;
    }
    /**
     * sets Vehicle param available true
     */
    public void setAvailableTrue(){
        available = true;
    }

    /**
     * Virtual method used by inherited classes
     * Prints price of a vehicle based on its class
     */
    public String getRentalPrice(){
        return "This type of vehicle cannot be rented!!!";
    }
}
