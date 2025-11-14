package model;

import java.time.LocalDate;

public class Clue {
    private int clueID;
    private LocalDate date;
    private String description;

    public Clue() {

    }

    public Clue(int clueID, LocalDate date, String description) {
        this.clueID = clueID;
        this.date = date;
        this.description = description;
    }

    public int getClueID() {
        return clueID;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setClueID(int clueID) {
        this.clueID = clueID;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
