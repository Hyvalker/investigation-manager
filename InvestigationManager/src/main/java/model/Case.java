package model;

import java.util.ArrayList;
import java.util.List;

public class Case {
    private String title;
    private String description;
    private Status status;
    private List<Suspect> suspectList = new ArrayList<>();
    private List<Clue> clueList = new ArrayList<>();
    private List<Evidence> evidenceList = new ArrayList<>();

    public Case() {

    }

    public Case(String title, String description, Status status) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.suspectList = new ArrayList<>();
        this.clueList = new ArrayList<>();
        this.evidenceList = new ArrayList<>();
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setSuspectList(List<Suspect> suspectList) {
        this.suspectList = suspectList;
    }

    public void setClueList(List<Clue> clueList) {
        this.clueList = clueList;
    }

    public void setEvidenceList(List<Evidence> evidenceList) {
        this.evidenceList = evidenceList;
    }

}
