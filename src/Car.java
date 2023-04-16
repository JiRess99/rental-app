public class Car extends Vehicle{
    private final int seat;

    public Car(String make, String model, String registrationPlate, int odometer, int seat) {
        super(make, model, registrationPlate, odometer);
        this.seat = seat;
    }

    /**
     * @return int seat
     */
    public int getSeat() {
        return seat;
    }
    @Override
    public String toString(){
        return getMake() + " "
                + getModel()
                + " " + getRegistrationPlate()
                + "; odometer: " + getOdometer()
                + "; passenger seats: " + getSeat()
                + "; rental price: " + getRentalPrice()
                + "; avaliability: " + isAvailable();
    }
    @Override
    public String getRentalPrice(){
        return "65€/day";
    }
}
