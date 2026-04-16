//package miniProject;

/*
 * Team Members:
 * Yong Jing Wen 
 * Wong Shi Yun 
 * Tan Keqin 
 * Lee Lai Queen 
 */

import java.util.*;

public class Catalog {

    // list of area
    public static void dispArea(String[] universityAreas) {

        for (String Area : universityAreas) {
            System.out.println(Area);
        }
    }

    // list of breed
    public static void dispBreed(String[] breed) {

        for (String i : breed) {
            System.out.println(i);
        }
    }

    // validate area method - exception handling
    public static String validateArea(String[] areaList, String area)
            throws InvalidAreaException {

        for (String a : areaList) {
            if (a.equalsIgnoreCase(area)) {
                return area;
            }
        }
        throw new InvalidAreaException(area);
    }

    // staff menu
    public static int staffMenu(Scanner input) {

        System.out.println("\nWhat would you like to do ?");
        System.out.println("1. Record a feeding\r\n" + //
                "2. Log a vet visit\r\n" + //
                "3. Make an incident report\r\n" + //
                "4. Add cat\r\n" + //
                "5. Remove cat\r\n" + //
                "6. Update Profile\r\n" + //
                "7. View Feeding Records\r\n" +
                "8. View Donation Records\r\n" +
                "9. Return\r\n");

        System.out.print("Enter your choice: ");
        int choice;
        choice = input.nextInt();
        return choice;
    }

    // look for a cat
    public static Cat findCat(Vector<Cat> cats, String catID) {
        for (int i = 0; i < cats.size(); i++) {
            if (cats.get(i).getCatID().equals(catID)) {
                return cats.get(i);
            }
        }
        System.out.println("Cat not found!");
        return null;
    }

    public static void viewCatDetail(Vector<Cat> foundCats, Scanner input) {

        boolean catNoValid = false;
        while (catNoValid == false) {
            System.out.print("Which cat's detail would you like to view? ");
            int selection = input.nextInt();
            input.nextLine();

            if (selection >= 1 && selection <= foundCats.size()) {
                foundCats.get(selection - 1).printCatProfile();
                foundCats.get(selection - 1).viewIRHR();
                catNoValid = true;
            } else {
                System.out.println("Invalid choice. Please refer to the list provided.");
            }
        }
    }

    public static void handleByArea(Vector<Cat> cats, String[] universityAreas, Scanner input) {

        System.out.println("\nList of Area:");
        dispArea(universityAreas);

        String areaChosen = null;
        while (areaChosen == null) {
            System.out.print("\nSelect the area you interested in: ");
            String areaInput = input.nextLine().trim();
            try {
                areaChosen = validateArea(universityAreas, areaInput);
            } catch (InvalidAreaException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }

        Vector<Cat> foundCats = new Vector<>();

        for (Cat cat : cats) {
            if (cat.getHome().contains(areaChosen)) {
                foundCats.add(cat);
            }
        }

        if (foundCats.isEmpty()) {
            System.out.println("No cats found in that area.");
            return;
        }

        System.out.println("\nList of cats:");
        for (int i = 0; i < foundCats.size(); i++) {
            Cat c = foundCats.get(i);
            System.out.printf("%d. %s - %s%n", i + 1, c.getCatID(), c.getName());
        }
        viewCatDetail(foundCats, input);
    }

    public static void handleByBreed(Vector<Cat> cats, String[] breed, Scanner input) {

        System.out.println("List of Breed:");
        dispBreed(breed);

        System.out.print("\nWhich breed are you interested in: ");
        String breedChosen = input.nextLine();

        Vector<Cat> foundCats = new Vector<>();

        for (Cat cat : cats) {
            if (cat.getBreed().contains(breedChosen)) {
                foundCats.add(cat);
            }
        }

        if (foundCats.isEmpty()) {
            System.out.println("No cats found in that breed.");
            return;
        }

        System.out.println("List of cats:");
        for (int i = 0; i < foundCats.size(); i++) {
            Cat c = foundCats.get(i);
            System.out.printf("%d. %s - %s%n", i + 1, c.getCatID(), c.getName());
        }
        viewCatDetail(foundCats, input);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create List of Staff
        Vector<Cat> cats = new Vector<>();
        Vector<Cat> catHistoryLogs = new Vector<>();
        Vector<Staff> staffs = new Vector<>();
        Vector<Volunteer> volunteers = new Vector<>();
        Vector<Donation> donations = new Vector<>();
        // Vector<IncidentReport> incidentReports = new Vector<>();
        Vector<GuestDonor> donors = new Vector<>();

        String[] universityAreas = { "Block A", "Block B",
                "Canteen", "Computer Lab", "Lecture Hall",
                "Administration Office" };

        String[] breedList = { "Tabby", "Siamese", "Sphynx", "Ragdoll", "Burmese" };

        Staff staff1 = new Staff("Lee", "1234", "0129321111", "lee@gmail.com", "Block A", "90", "Part time", "Boss",
                "Block A");
        staffs.add(staff1);

        Cat cat1 = new Cat(
                "Whiskers", 3, "Tabby",
                "Block A - Library", "Good", "Male",
                "Calm, Loves to sunbathe", "Orange Mackarel");

        Cat cat2 = new Cat(
                "Milo", 2, "Siamese",
                "Block B - Cafeteria", "Fair", "Female",
                "Playful, Always follows students", "Lilac point");

        cats.add(cat1);
        cats.add(cat2);

        System.out.println("Welcome to Cat-a-log: University Cat System !");

        int LogInRole = -1;
        do {
            System.out.println("\nPlease select your role to log in: ");
            System.out.println("0. Register as Staff\r\n" + //
                    "1. Login as Staff\r\n" + //
                    "2  Volunteer\r\n" + //
                    "3. Patron - I just want to make some donation\r\n" + //
                    "4. Guest - I have nothing to do but just interested in watching cat\r\n" + //
                    "5. Exit\r\n" + //
                    "");
            System.out.print("Enter your choice: ");

            try {
                LogInRole = input.nextInt();
                input.nextLine();
                Staff currStaff = null;
                switch (LogInRole) {
                    case 0:
                        System.out.println("\n=============== Staff Portal ================");
                        System.out.println("\nRegistration");

                        System.out.print("Name: ");
                        String name = input.nextLine();

                        System.out.print("Password: ");
                        String password = input.nextLine();

                        System.out.print("Contact: ");
                        String contact = input.nextLine();

                        System.out.print("Email: ");
                        String email = input.nextLine();

                        System.out.print("Address: ");
                        String address = input.nextLine();

                        System.out.print("Employment Type (Part time/ Full time): ");
                        String employmentType = input.nextLine();

                        System.out.print("Workshift: ");
                        String workshift = input.nextLine();

                        System.out.print("Position: ");
                        String position = input.nextLine();

                        System.out.println("\nList of available area: ");
                        dispArea(universityAreas);

                        // exception
                        String area = null;
                        while (area == null) {
                            System.out.print("Please select your area: ");
                            String areaInput = input.nextLine().trim();
                            try {
                                area = validateArea(universityAreas, areaInput);
                            } catch (InvalidAreaException e) {
                                System.out.println("Error: " + e.getMessage());
                                System.out.println("Please try again.\n");
                            }
                        }

                        currStaff = new Staff(name, password, contact, email, address, workshift, employmentType,
                                position, area);
                        staffs.add(currStaff);

                        System.out.println("\nStaff Registered Successfully!");
                        System.out.println("Your user ID is: " + currStaff.getUserID());
                        System.out.println("\nHere are your assigned cats: ");
                        for (int i = 0; i < cats.size(); i++) {
                            if (cats.get(i).getHome().contains(area)) {
                                System.out.println(cats.get(i).getCatID() + "(" + cats.get(i).getName() + ")");
                            }
                        }

                        System.out.println("\nReturning to main menu for login...\n\n");

                        break;

                    case 1:
                        System.out.println("\nLogin");
                        boolean login = false;

                        CatCareAction user = null;
                        while (login == false) {
                            System.out.print("User ID: ");
                            String id = input.nextLine();

                            System.out.print("Password: ");
                            String pass = input.nextLine();

                            for (int i = 0; i < staffs.size(); i++) {
                                if ((id.equals(staffs.get(i).getUserID()))
                                        && (pass.equals(staffs.get(i).getPassword()))) {
                                    System.out.println("Login Successful!");
                                    currStaff = staffs.get(i);

                                    user = currStaff;

                                    login = true;
                                    break;
                                }
                            }
                            if (!login)
                                System.out.println("Login failed. Please try again.");
                        }

                        do {
                            System.out.println("\n============== Staff Portal ===============");
                            int staffAction = staffMenu(input);

                            if (staffAction == 9) {
                                break;
                            }

                            Cat staffc;
                            input.nextLine();

                            switch (staffAction) {
                                case 1:
                                    System.out.print("Cat ID : ");
                                    String fedCat = input.nextLine();
                                    staffc = findCat(cats, fedCat);
                                    if (staffc != null)
                                        user.recordFeeding(staffc);
                                    break;

                                case 2: // log vet visit
                                    System.out.print("Cat ID: ");
                                    String illCat = input.nextLine();
                                    staffc = findCat(cats, illCat);

                                    if (staffc != null) {
                                        user.logVetVisit(staffc);
                                    }
                                    break;

                                case 3: // make incident report
                                    user.reportIncident(cats);
                                    System.out.println("Successfully created incident report.");
                                    break;

                                case 4: // add cat
                                    System.out.println("\nAdding cat...");
                                    System.out.print("Name: ");
                                    String cname = input.nextLine();
                                    System.out.print("Age: ");
                                    int age = input.nextInt();
                                    input.nextLine();
                                    System.out.println("List of breed: ");
                                    dispBreed(breedList);
                                    System.out.print("Breed: ");
                                    String breed = input.nextLine();
                                    System.out.print("Home: ");
                                    String home = input.nextLine();
                                    System.out.print("Health Status: ");
                                    String healthStatus = input.nextLine();
                                    System.out.print("Gender: ");
                                    String gender = input.nextLine();
                                    System.out.print("Personality: ");
                                    String personality = input.nextLine();
                                    System.out.print("Characteristic: ");
                                    String characteristic = input.nextLine();

                                    Cat newCat = new Cat(cname, age, breed, home, healthStatus, gender, personality,
                                            characteristic);
                                    newCat.addCat(cats);
                                    break;

                                case 5: // remove cat
                                    boolean found = false;
                                    while (!found) {
                                        System.out.println("\nRemoving cat...");
                                        System.out.print("Cat ID: ");
                                        String catID = input.nextLine();
                                        System.out.print("Cat Name: ");
                                        String catName = input.nextLine();

                                        Cat catRemove = findCat(cats, catID);
                                        if (catRemove != null && catName.equals(catRemove.getName())) {
                                            System.out.print("Reason to remove: ");
                                            String reason = input.nextLine();

                                            catRemove.addRemark(reason);
                                            catRemove.addCat(catHistoryLogs);
                                            catRemove.removeCat(cats);

                                            System.out.println("Cat " + catRemove.getCatID() + " removed.");
                                            found = true;

                                            break;
                                        }

                                        if (!found) {
                                            System.out.println(
                                                    "Cat not found. Please enter the correct Cat ID and Name.\n");
                                        }
                                    }
                                    break;

                                case 6:
                                    currStaff.updateStaffProfile(input);
                                    System.out.println("");
                                    break;

                                case 7:
                                    System.out.println("\n============ Feeding Records ==============");
                                    boolean feedRecord = false;

                                    for (Cat cat : cats) {
                                        Vector<Feeding> feedlog = cat.getFeedingRecords();
                                        if (!feedlog.isEmpty()) {
                                            System.out.println(
                                                    "\nCats ID: " + cat.getCatID() + "(" + cat.getName() + ")");
                                            System.out.println("Feeding Log:");
                                            for (Feeding feed : feedlog) {
                                                feed.displayFeeding();
                                            }

                                            feedRecord = true;
                                        }
                                    }

                                    if (!feedRecord) {
                                        System.out.println("No feeding records available.");
                                    }
                                    break;

                                case 8:
                                    System.out.println("\n============== Donation Records ==============");
                                    if (donations.isEmpty()) {
                                        System.out.println("No donation records available.");
                                    } else {
                                        for (Donation donation : donations) {
                                            System.out.printf("%-15s %-20s%n", "Donation ID", "Name");
                                            System.out.println("----------------------------------------");
                                            donation.getDonationInfo();
                                        }
                                    }

                                    System.out.println(
                                            "\nDo you wish to view the Donation Summary for each category? 1 - Yes , 2 - No");
                                    int yn = input.nextInt();
                                    if (yn == 1) {
                                        Donation.displayCategorySummary(donations);
                                    }
                                    break;

                                default:
                                    break;
                            }

                        } while (LogInRole != 9);
                        break;

                    case 2:
                        System.out.println("\n============ Volunteer Portal =============\n");

                        Volunteer v = new Volunteer();
                        volunteers.add(v);
                        CatCareAction userV = v;

                        System.out.println("\nWhat would you like to do ? ");
                        System.out.println("1. Record a feeding\r\n" + //
                                "2. Log a vet visit\r\n" + //
                                "3. Make an incident report\r\n" + //
                                "4. Return\r\n" + //
                                "");
                        System.out.print("\nEnter your choice: ");

                        int volunteerAction = input.nextInt();
                        input.nextLine();

                        Cat c;
                        switch (volunteerAction) {
                            case 1:
                                // feeding
                                System.out.print("Cat ID: ");
                                String fedCat = input.nextLine();
                                c = findCat(cats, fedCat);

                                if (c != null)
                                    userV.recordFeeding(c);

                                break;

                            case 2:
                                // vet visit
                                System.out.print("Cat ID: ");
                                String illCat = input.nextLine();
                                c = findCat(cats, illCat);

                                if (c != null)
                                    userV.logVetVisit(c);

                                break;

                            case 3:
                                // incident report
                                userV.reportIncident(cats);
                                System.out.println("Successfully created incident report.");

                                break;

                            case 4:
                                System.out.println("Thank You for your help! ");
                                break;

                            default:
                                // exception handling
                                System.out.println("Invalid input");
                                break;
                        }

                        break;

                    case 3:
                        System.out.println("\n============== Donor Portal ===============");
                        GuestDonor donor;

                        System.out.println("Registering Guest Donor...");
                        donor = new GuestDonor();

                        donors.add(donor);
                        Donation d = new Donation(donor);
                        donations.add(d);
                        break;

                    case 4:
                        System.out.println("\n============== Guest Portal ==============");
                        System.out.println("Welcome to the guest portal !");
                        System.out.println("1. View Profile \n2. View Cat");
                        System.out.print("Enter your choice: ");
                        int guestinput = input.nextInt();
                        input.nextLine();
                        switch (guestinput) {
                            case 1:
                                System.out.println("Please choose which profile you would like to view: ");
                                System.out.println("1. Staff\n2. Volunteer\n3. Donor");
                                System.out.print("Enter your choice: ");
                                int profileinput = input.nextInt();
                                input.nextLine();
                                switch (profileinput) {
                                    case 1:
                                        System.out.println("\nAll Staff Information: ");
                                        for (Staff staffprofile : staffs) {
                                            staffprofile.getUserInfo();
                                            System.out.println();
                                        }
                                        break;
                                    case 2:
                                        System.out.println("\nAll Volunteer Information: ");
                                        for (Volunteer volunteerprof : volunteers) {
                                            volunteerprof.getUserInfo();
                                            System.out.println();
                                        }
                                        break;
                                    case 3:
                                        System.out.println("\nAll Donor Information:");
                                        for (GuestDonor donorprof : donors) {
                                            donorprof.getUserInfo();
                                            System.out.println();
                                        }
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case 2:
                                System.out.print("Please choose the way you prefer to look for a cat :\r\n" + //
                                        "1. By Area\r\n" + //
                                        "2. By Breed\r\n" + //
                                        "Enter your preference : " + //
                                        "");

                                int guestChoice = input.nextInt();
                                input.nextLine();

                                switch (guestChoice) {
                                    case 1:
                                        handleByArea(cats, universityAreas, input);
                                        break;
                                    case 2:
                                        handleByBreed(cats, breedList, input);
                                        break;
                                    default:
                                        System.out.println("Invalid choice.");
                                        break;
                                }
                                break;
                        }

                        break;

                    case 5:
                        System.out.println("Thank You for using Cat-a-log !");

                        break;
                    default:
                        // exception handling
                        System.out.println("Invalid");
                        break;

                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid.Please try again.");
                input.nextLine();
            }

        } while (LogInRole != 5);

        input.close();
    }

}
