package model;

import java.util.ArrayList;
import java.util.List;

public class Suspect extends Person{
    private String criminalRecords;
    private int systemID;

    public Suspect(){

    }

    public Suspect(String name, int age, String description, String criminalRecords, int systemID){
        super(name, age, description);
        this.criminalRecords = criminalRecords;
        this.systemID = systemID;
    }

    public String getCriminalRecords(){
        return criminalRecords;
    }

    public int getSystemID(){
        return systemID;
    }

    public void setCriminalRecords(String criminalRecords) {
        this.criminalRecords = criminalRecords;
    }

    public void setSystemID(int systemID) {
        this.systemID = systemID;
    }
}
