package model;

import java.util.ArrayList;
import java.util.List;

public class Case {
    private int id;
    private String title;
    private String description;
    private Status status;
    private List<Suspect> suspectList = new ArrayList<>();
    private List<Clue> clueList = new ArrayList<>();
    private List<Evidence> evidenceList = new ArrayList<>();
    private List<AssignedDetective> assignedDetectiveList = new ArrayList<>();

    public Case() {

    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AssignedDetective> getAssignedDetectiveList() {
        return assignedDetectiveList;
    }

    public int getId() {
        return id;
    }

    public void setAssignedDetectiveList(List<AssignedDetective> assignedDetectiveList) {
        this.assignedDetectiveList = assignedDetectiveList;
    }

    public Case(String title, String description, Status status, int id) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.id = id;
        this.suspectList = new ArrayList<>();
        this.clueList = new ArrayList<>();
        this.evidenceList = new ArrayList<>();
        this.assignedDetectiveList = new ArrayList<>();
    }

    public void addAssignedDetective (AssignedDetective assignedDetective) {
        assignedDetectiveList.add(assignedDetective);
    }

    public void addSuspect(Suspect suspect) {
        suspectList.add(suspect);
    }

    public void addClue(Clue clue) {
        clueList.add(clue);
    }

    public void addEvidence(Evidence evidence) {
        evidenceList.add(evidence);
    }

    public Status getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Suspect> getSuspectList() {
        return suspectList;
    }

    public List<Clue> getClueList() {
        return clueList;
    }

    public List<Evidence> getEvidenceList() {
        return evidenceList;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
