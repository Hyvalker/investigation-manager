package model;

public class Detective extends Person {
    private int badgeNumber;
    private String systemPassword;
    private String systemUsername;

    public Detective() {

    }

    public Detective(String name, int age, String description, int badgeNumber, String systemPassword, String systemUsername) {
        super(name, age, description);
        this.badgeNumber = badgeNumber;
        this.systemPassword = systemPassword;
        this.systemUsername = systemUsername;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public String getSystemPassword() {
        return systemPassword;
    }

    public void setSystemPassword(String systemPassword) {
        this.systemPassword = systemPassword;
    }

    public String getSystemUsername() {
        return systemUsername;
    }

    public void setSystemUsername(String systemUsername) {
        this.systemUsername = systemUsername;
    }
}
