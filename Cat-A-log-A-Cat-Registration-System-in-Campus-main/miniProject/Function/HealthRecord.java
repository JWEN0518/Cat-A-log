//package miniProject.Function;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HealthRecord {
    private static int hrCounter = 0;
    private String healthID;

    private String type;
    private String status;
    private String remarks;
    private LocalDate visitDate;
    private User handler;

    Scanner input = new Scanner(System.in);

    public HealthRecord(User u) {
        hrCounter++;
        this.healthID = String.format("HR%03d", hrCounter);

        System.out.print("Type: ");
        this.type = input.nextLine();

        System.out.print("Status: ");
        this.status = input.nextLine();

        System.out.print("Date (YYYY-MM-DD): ");
        String dateString = input.nextLine();

        System.out.print("Reason for vet visit: ");
        this.remarks = input.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.visitDate = LocalDate.parse(dateString, formatter);

        handler = u;

    }

    public String getHealthID() {
        return healthID;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getRemarks() {
        return remarks;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    @Override
    public String toString() {
        return "[" + visitDate + "] " + status + " - " + remarks;
    }

    public HealthRecord getHealthRecord() {
        return this;
    }

    public void printHealthRecord() {
        System.out.println("               Health Record               ");
        System.out.println("-------------------------------------------");
        System.out.println("Health ID   : " + healthID);
        System.out.println("Type        : " + type);
        System.out.println("Status      : " + status);
        System.out.println("Visit Date  : " + visitDate);
        System.out.println("Remarks     : " + remarks);
        System.out.println("-------------------------------------------\n");
    }

}
