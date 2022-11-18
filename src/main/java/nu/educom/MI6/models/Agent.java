package nu.educom.MI6.models;

import java.util.Date;

public class Agent {
    private int id;
    private String dienstnummer;
    private String code;
    private boolean actief;
    private boolean licenceToKill;
    private Date eindLicence;

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", dienstnummer='" + dienstnummer + '\'' +
                ", code='" + code + '\'' +
                ", actief=" + actief +
                ", licenceToKill=" + licenceToKill +
                ", eindLicence=" + eindLicence +
                '}';
    }

    public Agent() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDienstnummer(String dienstnummer) {
        this.dienstnummer = dienstnummer;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setActief(boolean actief) {
        this.actief = actief;
    }

    public void setLicenceToKill(boolean licenceToKill) {
        this.licenceToKill = licenceToKill;
    }

    public void setEindLicence(Date eindLicence) {
        this.eindLicence = eindLicence;
    }

    public Agent(int id, String dienstnummer, String code, boolean actief, boolean licenceToKill, Date eindLicence) {
        this.id =id;
        this.dienstnummer = dienstnummer;
        this.code = code;
        this.actief = actief;
        this.licenceToKill = licenceToKill;
        this.eindLicence = eindLicence;
    }

    public int getId() {
        return id;
    }

    public String getDienstnummer() {
        return dienstnummer;
    }

    public String getCode() {
        return code;
    }

    public boolean isActief() {
        return actief;
    }

    public boolean isLicenceToKill() {
        return licenceToKill;
    }

    public Date getEindLicence() {
        return eindLicence;
    }
}
