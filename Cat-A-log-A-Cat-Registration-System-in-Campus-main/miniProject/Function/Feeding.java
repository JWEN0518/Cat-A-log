//package miniProject.Function;


import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

public class Feeding {
    private String portion;
    private String remark;
    private User feeder;
    private LocalDate date;
    private LocalTime time;

    Scanner input = new Scanner(System.in);

    public Feeding(User u) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();

        System.out.println("\nLog Feeding");
        System.out.println("Date: " + getDate());
        System.out.println("Time: " + getTime());
        System.out.print("Portion: ");
        portion = input.nextLine();
        System.out.print("Remark: ");
        remark = input.nextLine();

        feeder = u;
    }

    public void displayFeeding() {
        System.out.println("    Date: " + getDate());
        System.out.println("    Time: " + getTime());
        System.out.println("    Portion: " + getPortion());
        System.out.println("    Remark: " + remark);
        System.out.println("    Feeder: " + feeder.getName());
        System.out.println("");
    }

    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter.format(date);
    }

    public String getPortion() {
        return portion;
    }

    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        return formatter.format(time);
    }

}
