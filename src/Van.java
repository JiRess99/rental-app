public class Van extends Vehicle{
    private final int maximumLoad;
    private final double cargoSpace;

    public Van(String make, String model, String registrationPlate, int odometer, int maximumLoad, double cargoSpace) {
        super(make,
                model,
                registrationPlate,
                odometer);
        this.available = true;
        this.maximumLoad = maximumLoad;
        this.cargoSpace = cargoSpace;
    }


    /**
     * @return int maximumLoad
     */
    public int getMaximumLoad() {
        return maximumLoad;
    }
    /**
     * @return int cargoSpace
     */
    public double getCargoSpace() {
        return cargoSpace;
    }

    @Override
    public String toString(){
        return getMake() + " "
                + getModel()
                + " " + getRegistrationPlate()
                + "; odometer: " + getOdometer()
                + "; maximum load: " + getMaximumLoad() + "kg"
                + "; cargo space: " + getCargoSpace() + " m^3"
                + "; rental price: " + getRentalPrice()
                + "; avaliability: " + isAvailable();
    }


    @Override
    public String getRentalPrice(){
        return "95€/day";
    }
}
