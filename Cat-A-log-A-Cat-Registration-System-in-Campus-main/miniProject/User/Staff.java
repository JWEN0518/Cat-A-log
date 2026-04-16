//package miniProject.User;


import java.util.*;

public class Staff extends User implements CatCareAction {

    private String password;
    private String address;
    private String workshift;
    private String employeeType;
    private String position;
    private String assignArea;

    public Staff(String name, String passw, String contact, String email, String address, String workshift,
            String employeeType, String position, String assignarea) {
        super(name, "staff", contact, email);
        this.password = passw;
        this.address = address;
        this.workshift = workshift;
        this.employeeType = employeeType;
        this.position = position;
        this.assignArea = assignarea;
    }

    public Staff() {
        super("Default Name", "staff", "Default Contact", "Default Email");

        System.out.println("Name: ");
        this.setName(input.nextLine());

        System.out.println("Contact: ");
        this.setContact(input.nextLine());

        System.out.println("Email: ");
        this.setEmail(input.nextLine());

    }

    @Override
    public String getUserID() {
        return super.getUserID();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setWorkshift(String workshift) {
        this.workshift = workshift;
    }

    public String getWorkshift() {
        return workshift;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setAssignArea(String area) {
        this.assignArea = area;
    }

    public String getAssignArea() {
        return assignArea;
    }

    public void getUserInfo() {

        System.out.println("============== STAFF INFORMATION ==============");
        System.out.println("Staff ID       : " + getUserID());
        System.out.println("Name           : " + getName());
        System.out.println("Role           : " + getRole());
        System.out.println("Email          : " + getEmail());
        System.out.println("Workshift      : " + getWorkshift());
        System.out.println("Employment Type: " + getEmployeeType());
        System.out.println("Position       : " + getPosition());
        System.out.println("Assigned Area  : " + getAssignArea());
        System.out.println("");
    }

    public void updateStaffProfile(Scanner input) {
        int choice;

        do {
            System.out.println("\n============== UPDATE STAFF PROFILE ==============");
            System.out.println("1. Update Name");
            System.out.println("2. Update Password");
            System.out.println("3. Update Contact");
            System.out.println("4. Update Email");
            System.out.println("5. Update Address");
            System.out.println("6. Update Workshift");
            System.out.println("7. Update Employment Type");
            System.out.println("8. Update Position");
            System.out.println("9. Done Updating");
            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number: ");
                input.next();
            }
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    this.setName(input.nextLine());
                    System.out.println("Name updated.");
                    break;
                case 2:
                    System.out.print("Enter new password: ");
                    this.setPassword(input.nextLine());
                    System.out.println("Password updated.");
                    break;
                case 3:
                    System.out.print("Enter new contact: ");
                    this.setContact(input.nextLine());
                    System.out.println("Contact updated.");
                    break;
                case 4:
                    System.out.print("Enter new email: ");
                    this.setEmail(input.nextLine());
                    System.out.println(" Email updated.");
                    break;
                case 5:
                    System.out.print("Enter new address: ");
                    this.setAddress(input.nextLine());
                    System.out.println("Address updated.");
                    break;
                case 6:
                    System.out.print("Enter new workshift: ");
                    this.setWorkshift(input.nextLine());
                    System.out.println("Workshift updated.");
                    break;
                case 7:
                    System.out.print("Enter new employment type: ");
                    this.setEmployeeType(input.nextLine());
                    System.out.println(" Employment Type updated.");
                    break;
                case 8:
                    System.out.print("Enter new position: ");
                    this.setPosition(input.nextLine());
                    System.out.println(" Position updated.");
                    break;
                case 9:
                    System.out.println("Done updating profile.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select from 1 to 9.");
                    break;
            }

        } while (choice != 9);
    }

    // INTERFACE
    @Override
    public void recordFeeding(Cat cat) {
        cat.addFeeding(this);
    }

    @Override
    public void logVetVisit(Cat cat) {
        cat.addHealthRecord(this);
    }

    @Override
    public void reportIncident(Vector<Cat> cats) {
        System.out.print("Number of cat(s) involved: ");
        int catNo = input.nextInt();
        input.nextLine();

        Cat[] catInvolved = new Cat[catNo];

        for (int i = 0; i < catNo; i++) {
            while (catInvolved[i] == null) {
                System.out.print("Enter cat ID: ");
                String catInvolvID = input.nextLine();
                catInvolved[i] = Catalog.findCat(cats, catInvolvID);
            }
        }

        System.out.print("Location of incident: ");
        String location = input.nextLine();
        System.out.print("Type of incident: ");
        String typeIncident = input.nextLine();
        System.out.print("Description of incident: ");
        String descIncident = input.nextLine();

        IncidentReport ir = new IncidentReport(location, typeIncident, descIncident, this, "staff", catInvolved);
        for (Cat c : catInvolved) {
            c.addIncidentReport(ir);
        }
    }

}