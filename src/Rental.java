import java.util.Scanner;

public class Rental {
    private Database database;
    private Scanner sc = new Scanner(System.in, "Windows-1250");

    public Rental(){
        database = new Database();
        /*
        Fills this.database properties with objects
         */
        database.fillCustomerDatabase();
        database.fillVehicleDatabase();
    }

    /**
     * Builds parameters for database.newCustomer method to create
     * a new Customer object in this.database
     */
    public void addCustomer(){
        System.out.println("Enter first name:");
        String firstName = sc.nextLine();
        System.out.println("Enter last name:");
        String lastName = sc.nextLine();
        System.out.println("Enter phone number:");
        int phoneNumber = 0;
        try {
            phoneNumber = Integer.parseInt(sc.nextLine());
        } catch (Exception e){
            System.out.println("ERROR - You can choose only number!");
        }
        System.out.println("Enter email:");
        String email = sc.nextLine();
        database.newCustomer(firstName,lastName,phoneNumber,email);
    }
    /**
     * Renders all customers from customersList in database object
     * if List is empty then prints error line
     */
    public void renderAllCustomers(){
        if(!database.getCustomersList().isEmpty()) {
            for (Customer c : database.getCustomersList()) {
                System.out.println(database.getCustomersList().indexOf(c) + " - " + c);
            }
        }else{
            System.out.println("There are no customers in database, you need to add them first");
        }
    }
    /**
     * Builds parameters for database.newVehicle method to create
     * a new Vehicle object in this.database
     */
    public void addVehicle(){
        int choice = 0;
        do {
            System.out.println("Choose type of vehicle");
            System.out.println("1 - Car");
            System.out.println("2 - Van");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e){
                System.out.println("ERROR - You can choose only number!");
            }
            if(choice != 1 && choice != 2){
                System.out.println("ERROR - Invalid vehicle type!");
            }
        }while(choice  != 1 && choice != 2);
        System.out.println("Enter make:");
        String make = sc.nextLine();
        System.out.println("Enter model:");
        String model = sc.nextLine();
        System.out.println("Enter registration plate number:");
        String registrationPlate = sc.nextLine();
        System.out.println("Enter state of odometer");
        int odometer = Integer.parseInt(sc.nextLine());
        if(choice == 1){
            System.out.println("Enter number of seats:");
            int seat = Integer.parseInt(sc.nextLine());
            database.newCar(make, model, registrationPlate, odometer, seat);
        }
        else if(choice == 2){
            System.out.println("Enter maximumLoad:");
            int maximumLoad = Integer.parseInt(sc.nextLine());
            System.out.println("Enter cargoSpace");
            double cargoSpace = Double.parseDouble(sc.nextLine());
            database.newVan(make, model, registrationPlate, odometer, maximumLoad, cargoSpace);
        }
    }

    /**
     * Renders all vehicles from vehiclesList in database object
     * if List is empty then prints error line
     */
    public void renderAllVehicles(){
        if(!database.getVehiclesList().isEmpty()) {
            for (Vehicle v : database.getVehiclesList()) {
                System.out.println(database.getVehiclesList().indexOf(v) + " - " + v);
            }
        }else{
            System.out.println("There are no vehicles in database, you need to add them first");
        }
    }

    /**
     * Renders all current rentals from rentedVehicles in database object
     * if HashMap is empty then prints error line
     */
    public void renderAllRents(){
        if(!database.getRentedVehicles().isEmpty()) {
            database.getRentedVehicles().forEach((customerId, vehicle)
                    -> System.out.println(customerId + " - " + database.getCustomersList().get(customerId).getFirstName() +
                    " " + database.getCustomersList().get(customerId).getLastName() + " - " + vehicle.getMake() + " " + vehicle.getModel()));
        }else{
            System.out.println("Currently there are no active rents!");
        }
    }

    /**
     * Inserts Vehicle object and indexOf customerList object into a HashMap
     * Using access methods sets Vehicle availability to false
     */
    public void rentVehicle() {
        System.out.println("Choose customer by ID from the list:");
        renderAllCustomers();
        try {
            int customerId = Integer.parseInt(sc.nextLine());
            if (customerId < database.getCustomersList().size()) {
                System.out.println("Choose a vehicle by ID that you want to rent:");
                renderAllVehicles();
                int vehicleId = Integer.parseInt(sc.nextLine());
                try {
                    Vehicle vehicle = database.getVehiclesList().get(vehicleId);
                    if (vehicle.isAvailable()) {
                        vehicle.setAvailableFalse();
                        database.newRent(customerId, vehicle);
                        System.out.println("Vehicle successfully rented to " + database.getCustomersList().get(customerId).getFirstName() + " " + database.getCustomersList().get(customerId).getLastName());
                    } else {
                        System.out.println("This vehicle cannot be rented!");
                    }
                } catch (Exception e) {
                    System.out.println("ERROR - This vehicle does not exist");
                }
            } else {
                System.out.println("Customer with this ID does not exist");
            }
        }catch (Exception e){
            System.out.println("ERROR - ID must be number");
        }
    }

    /**
     * Removes objects from HashMap
     * Using access methods sets Vehicle availability to true
     *                      sets new value of odometer
     */
    public void endRental(){
        if(!database.getRentedVehicles().isEmpty()){
            System.out.println("Choose which rental would you like to end");
            renderAllRents();
            int choice = Integer.parseInt(sc.nextLine());
            System.out.println("Enter state of odometer:");
            int odometer = Integer.parseInt(sc.nextLine());
            try {
                database.getRentedVehicles().get(choice).setAvailableTrue();
                database.getRentedVehicles().get(choice).setOdometer(odometer);
                database.getRentedVehicles().remove(choice);
                System.out.println("Rental successfully ended");
            } catch (Exception e){
                System.out.println("ERROR - rental with this id does not exist!");
            }
        }
        else{
            System.out.println("Currently there are no active rents!");
        }
    }


}
