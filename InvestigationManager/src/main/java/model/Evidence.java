package model;

public class Evidence {
    private int evidenceID;
    private String description;
    private String title;
    private EvidenceType evidenceType;

    public Evidence(int evidenceID, String description, String title, EvidenceType evidenceType) {
        this.evidenceID = evidenceID;
        this.description = description;
        this.title = title;
        this.evidenceType = evidenceType;
    }

    public int getEvidenceID() {
        return evidenceID;
    }

    public void setEvidenceID(int evidenceID) {
        this.evidenceID = evidenceID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
