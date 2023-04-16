public class Customer {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;

    public Customer(String firstName, String lastName, int phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString(){
        return getFirstName() + " "
                + getLastName() + "; "
                + getPhoneNumber() + "; "
                + getEmail();
    }
}
