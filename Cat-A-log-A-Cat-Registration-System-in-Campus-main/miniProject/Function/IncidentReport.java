//package miniProject.Function;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class IncidentReport {
    private String location, type, description, reportID, reportedRole;
    private User reportedBy;
    private LocalDate date;
    private LocalTime time;
    private static int idCounter = 0;

    private Cat[] catInvolved;

    public IncidentReport(String location, String type, String description, User reportBy, String reportedRole,
            Cat[] catInvolved) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();

        this.location = location;
        this.type = type;
        this.description = description;
        this.reportID = String.format("IR%03d", ++idCounter);
        this.reportedBy = reportBy;
        this.reportedRole = reportedRole;
        this.catInvolved = catInvolved;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getReportID() {
        return reportID;
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter.format(date);
    }

    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        return formatter.format(time);
    }

    public String getReportedBy() {
        return reportedBy.getName();
    }

    public String getReportedRole() {
        return reportedRole;
    }

    public void printReport() {
        System.out.println("\n            Cat Incident Report            ");
        System.out.println("===========================================");
        System.out.println("Report ID : " + getReportID());
        System.out.println("Date : " + getDate());
        System.out.println("Time : " + getTime());
        System.out.println("Location : " + getLocation());
        System.out.println();

        System.out.println("                Involved Cat               ");
        System.out.println("-------------------------------------------");
        for (Cat cat : catInvolved) {
            System.out.print("Cat ID : " + cat.getCatID() + " , ");
            System.out.print("Name : " + cat.getName());
            System.out.println();
        }
        System.out.println("Type : " + getType());
        System.out.println();

        System.out.println("                Reported By               ");
        System.out.println("------------------------------------------");
        System.out.println("Name : " + getReportedBy());
        System.out.println("Role : " + getReportedRole());
        System.out.println();

        System.out.println("            Incident Description           ");
        System.out.println("-------------------------------------------");
        System.out.println("Incident Desc: " + getDescription());

    }

}
