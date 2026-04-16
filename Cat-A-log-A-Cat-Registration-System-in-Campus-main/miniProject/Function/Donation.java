//package miniProject.Function;


import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

enum DonationType {
    FOOD, MONEY, MEDICINE, OTHERS;
}

public class Donation {
    private static int donationCounter = 0;
    private String donationID;
    private DonationType type;
    private String itemName;
    private int quantity;
    private double amountRM;
    private String remark;
    private LocalDate donationDate;
    User donor;

    Scanner input = new Scanner(System.in);

    public Donation(User u) {
        donor = u;
        donationCounter++;
        donationID = String.format("D%03d", donationCounter);
        donationDate = LocalDate.now();
        System.out.println("Donation ID: " + donationID);
        System.out.println("Date of donation: " + donationDate);

        int choice;
        System.out.println("\nSelect type of donation:");
        System.out.println("1. Food ");
        System.out.println("2. Money ");
        System.out.println("3. Medicine ");
        System.out.println("4. Others ");
        System.out.print("Enter your choice: ");
        choice = input.nextInt();
        input.nextLine();

        while ((choice < 1) || (choice > 4)) {
            System.out.print("Enter valid code: ");
            choice = input.nextInt();
            input.nextLine();
        }

        System.out.println("");

        if (choice == 1) {
            donateFood();
        } else if (choice == 2) {
            donateMoney();
        } else if (choice == 3) {
            donateMedicine();
        } else {
            donateOthers();
        }

        System.out.print("Remark: ");
        remark = input.nextLine();

        System.out.println("Donation recorded successfully!\nThankyou for your contribution!");
    }

    public void donateFood() {
        type = DonationType.FOOD;
        System.out.print("Item name: ");
        itemName = input.nextLine();

        System.out.print("Quantity: ");
        quantity = input.nextInt();
        input.nextLine();

        amountRM = -1;
    }

    public void donateMoney() {
        type = DonationType.MONEY;
        itemName = "Money";
        quantity = -1;
        while (true) {
            try {
                System.out.print("Amount (RM): ");

                amountRM = input.nextDouble();
                if (amountRM <= 0) {

                    throw new InvalidDonationAmountException("Donation amount must more than RM0.00");
                }
                break;
            } catch (InvalidDonationAmountException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Please enter numbers.");
                input.nextLine();
            }
        }
    }

    public void donateMedicine() {
        type = DonationType.MEDICINE;
        System.out.print("Item name: ");
        itemName = input.nextLine();

        System.out.print("Quantity: ");
        quantity = input.nextInt();
        input.nextLine();

        amountRM = -1;
    }

    public void donateOthers() {
        type = DonationType.OTHERS;
        System.out.print("Item name: ");
        itemName = input.nextLine();

        System.out.print("Quantity: ");
        quantity = input.nextInt();
        input.nextLine();

        amountRM = -1;
    }

    public void getDonationInfo() {
        System.out.printf("%-15s %-20s%n", donationID, donor.getName());

    }

    public static void displayCategorySummary(Vector<Donation> donations) {
        int totalFood = 0;
        int totalMedicine = 0;
        int totalOthers = 0;
        double totalMoney = 0.0;

        for (Donation d : donations) {
            switch (d.type) {
                case FOOD:
                    totalFood += d.quantity;
                    break;
                case MEDICINE:
                    totalMedicine += d.quantity;
                    break;
                case OTHERS:
                    totalOthers += d.quantity;
                    break;
                case MONEY:
                    totalMoney += d.amountRM;
                    break;
            }
        }

        System.out.println("\n===== Donation Summary by Category =====");
        System.out.println("Food     : " + totalFood + " items");
        System.out.printf("Money    : RM %.2f%n", totalMoney);
        System.out.println("Medicine : " + totalMedicine + " items");
        System.out.println("Others   : " + totalOthers + " items");
    }

}
