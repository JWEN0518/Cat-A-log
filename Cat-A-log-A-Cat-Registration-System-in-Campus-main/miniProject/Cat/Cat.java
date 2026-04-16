//package miniProject.Cat;

import java.util.*;

public class Cat {
    private String catID;
    private static int catCounter = 0;
    private String name;
    private int age;
    private String breed;
    private String home;
    private String healthStatus;
    private String gender; 
    private String personality;
    private String characteristic;
    private String remarkIfRemoved;
    private Date joinDate;
    private Vector<Feeding> feedingRecords;
    private ArrayList<HealthRecord> healthRecords;
    private Vector<IncidentReport> incidentReports = new Vector<>();

    Scanner input = new Scanner(System.in);

    public Cat(String name, int age, String breed, String home, String healthStatus, String gender,
            String personality, String characteristic) {

        catCounter++;
        catID = String.format("CAT%03d", catCounter);
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.home = home;
        this.healthStatus = healthStatus;
        this.gender = gender;
        this.personality = personality;
        this.characteristic = characteristic;
        remarkIfRemoved = null;
        this.joinDate = new Date();

        this.feedingRecords = new Vector<>();
        this.healthRecords = new ArrayList<>();
    }

    public String getHome() {
        return home;
    }

    public String getCatID() {
        return catID;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getRemoveRemark() {
        return remarkIfRemoved;
    }

    public Vector<Feeding> getFeedingRecords() {
        return feedingRecords;
    }

    public ArrayList<HealthRecord> getHealthRecords() {
        return healthRecords;
    }

    public void printHealthRecords() {
        if (healthRecords.isEmpty()) {
            System.out.println("No health records available.");
        } else {
            for (HealthRecord hr : healthRecords)
                hr.printHealthRecord();
        }
    }

    public void addCat(Vector<Cat> list) {
        list.add(this);
    }

    public void removeCat(Vector<Cat> list) {
        list.remove(this);
    }

    public void addFeeding(User u) {
        Feeding record = new Feeding(u);
        feedingRecords.add(record);
        System.out.println("Feeding recorded successfully!");

    }

    void addHealthRecord(User u) {
        healthRecords.add(new HealthRecord(u));
    }

    void addRemark(String remark) {
        remarkIfRemoved = remark;
    }

    public void addIncidentReport(IncidentReport ir) {
        incidentReports.add(ir);
    }

    public Vector<IncidentReport> getIncidentReports() {
        return incidentReports;
    }

    public void printCatProfile() {
        System.out.println("\n            Campus Cat Profile             ");
        System.out.println("===========================================");
        System.out.println("Cat ID        : " + catID);
        System.out.println("Name          : " + name);
        System.out.println("Age           : " + age + " years");
        System.out.println("Breed         : " + breed);
        System.out.println("Home          : " + home);
        System.out.println("Join Date     : " + joinDate);
        System.out.println("Health Status : " + healthStatus);
        System.out.println("Gender        : " + gender);
        System.out.println("Personality   : " + personality);
        System.out.println("Characteristic: " + characteristic);
        System.out.println("===========================================\n");
    }

    public void viewIRHR() {
        boolean choiceValid = false;

        while (choiceValid == false) {
            System.out.println("Do you wish to view the cat's Health Record or Incident Report? ");
            System.out.print("Enter 1 for Health Records, 2 for Incident Reports: ");
            int choice = input.nextInt();
            System.out.println("");

            if (choice == 1) {
                if (healthRecords.isEmpty()) {
                    System.out.println("Currently no health records.");
                } else {
                    healthRecords.forEach(HealthRecord::printHealthRecord);
                }
                choiceValid = true;
            } else if (choice == 2) {
                if (incidentReports.isEmpty()) {
                    System.out.println("Currently no incident reports.");
                } else {
                    incidentReports.forEach(IncidentReport::printReport);
                }
                choiceValid = true;
            } else {
                System.out.println("Invalid choice. Try again.\n\n");
            }
        }

    }
}
