import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //SETUP
        Rental rental = new Rental();
        Scanner sc = new Scanner(System.in, "Windows-1250");
        System.out.println("Author: Jiří Ress");
        int choice = -1;

        //Main Cycle
        while(choice != 0) {
            System.out.println("Car rental system");
            System.out.println("Choose what you want to do");
            System.out.println("1. Add new customer");
            System.out.println("2. Add new vehicle");
            System.out.println("3. List all customers");
            System.out.println("4. List all vehicles");
            System.out.println("5. Rent a vehicle");
            System.out.println("6. End rental");
            System.out.println("7. List all current rentals");
            System.out.println("0. Exit application");
            try {
                choice = Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                System.out.println("ERROR - You can choose only number");
            }
            switch (choice){
                case 1 -> rental.addCustomer();
                case 2 -> rental.addVehicle();
                case 3 -> rental.renderAllCustomers();
                case 4 -> rental.renderAllVehicles();
                case 5 -> rental.rentVehicle();
                case 6 -> rental.endRental();
                case 7 -> rental.renderAllRents();
                default -> System.out.println("ERROR - invalid command");
            }
        }
    }
}