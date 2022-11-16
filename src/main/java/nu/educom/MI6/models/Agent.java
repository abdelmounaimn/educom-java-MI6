package nu.educom.MI6.models;

import java.util.Date;

public class Agent {
    private int id;
    private String diensnummer;
    private String code;
    private boolean actief;
    private boolean licentToKill;
    private Date eindLicence;

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", diensnummer='" + diensnummer + '\'' +
                ", code='" + code + '\'' +
                ", actief=" + actief +
                ", licentToKill=" + licentToKill +
                ", eindLicence=" + eindLicence +
                '}';
    }

    public Agent() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDiensnummer(String diensnummer) {
        this.diensnummer = diensnummer;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }

    public void setLicentToKill(boolean licentToKill) {
        this.licentToKill = licentToKill;
    }

    public void setEindLicence(Date eindLicence) {
        this.eindLicence = eindLicence;
    }

    public Agent(int id, String diensnummer, String code, boolean actief, boolean licentToKill, Date eindLicence) {
        this.id =id;
        this.diensnummer = diensnummer;
        this.code = code;
        this.actief = actief;
        this.licentToKill = licentToKill;
        this.eindLicence = eindLicence;
    }

    public int getId() {
        return id;
    }

    public String getDiensnummer() {
        return diensnummer;
    }

    public String getCode() {
        return code;
    }

    public boolean isActief() {
        return actief;
    }

    public boolean isLicentToKill() {
        return licentToKill;
    }

    public Date getEindLicence() {
        return eindLicence;
    }
}
