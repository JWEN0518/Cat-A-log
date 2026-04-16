//package miniProject.User;


import java.time.LocalDate;
import java.util.Vector;

public class Volunteer extends User implements CatCareAction {

    private LocalDate joinDate;

    public Volunteer(String name, String contact, String email) {
        super(name, "volunteer", contact, email);
        this.joinDate = LocalDate.now();

    }

    public Volunteer() {
        super("Default Name", "volunteer", "Default Contact", "Default Email");

        System.out.print("Name: ");
        this.setName(input.nextLine());

        System.out.print("Contact: ");
        this.setContact(input.nextLine());

        System.out.print("Email: ");
        this.setEmail(input.nextLine());

        this.joinDate = LocalDate.now();
    }

    public void getUserInfo() {
        System.out.println("============== Volunteer Info ==============");
        System.out.println("Name        : " + getName());
        System.out.println("Role        : " + getRole());
        System.out.println("Email       : " + getEmail());
        System.out.println("Join Date   : " + joinDate);
        System.out.println("");
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
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

        IncidentReport ir = new IncidentReport(location, typeIncident, descIncident, this, "volunteer", catInvolved);
        for (Cat c : catInvolved) {
            c.addIncidentReport(ir);
        }
    }
}
