//package miniProject.User;


import java.util.*;

public abstract class User {
    private static int staffCounter = 0;
    private static int volunteerCounter = 0;
    private static int donorCounter = 0;
    private String userID;
    private String name;
    private String role;
    private String contact;
    private String email;

    abstract void getUserInfo();

    Scanner input = new Scanner(System.in);

    public User(String name, String role, String contact, String email) {
        this.name = name;
        this.role = role;
        this.contact = contact;
        this.email = email;
        if (role.equals("staff")) {
            this.userID = String.format("SF%03d", ++staffCounter);
        } else if (role.equals("volunteer")) {
            this.userID = String.format("VR%03d", ++volunteerCounter);
        } else {
            this.userID = String.format("DN%03d", ++donorCounter);
        }

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
