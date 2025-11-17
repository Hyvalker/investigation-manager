package model;

public class AssignedDetective {
    private String name;
    private int badgeNumber;

    public AssignedDetective(String name, int badgeNumber) {
        this.name = name;
        this.badgeNumber = badgeNumber;
    }

    public String getName() {
        return name;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }
}

