//package miniProject.User;


public class GuestDonor extends User {

    public GuestDonor() {
        super("Default Name", "Guest Donor", "Default Contact", "Default Email");

        System.out.print("Name: ");
        this.setName(input.nextLine());

        System.out.print("Contact: ");
        this.setContact(input.nextLine());

        System.out.print("Email: ");
        this.setEmail(input.nextLine());

    }

    public void getUserInfo() {
        System.out.println("Guest Id: " + this.getUserID());
        System.out.println("Name    : " + this.getName());
        System.out.println("Contact : " + this.getContact());
        System.out.println("Email   : " + this.getEmail());
        System.out.println("");
    }

}