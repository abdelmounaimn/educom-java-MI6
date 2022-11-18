package nu.educom.MI6.models;

import java.time.LocalDateTime;
import java.util.Date;

public class LoginAttempt {

    private int id;
    private String dienstnummer;
    private boolean succesvol;
    private LocalDateTime tijdstempel;

    public LoginAttempt() {
    }

    @Override
    public String toString() {
        return "LoginAttempt{" +
                "id=" + id +
                ", dienstnummer='" + dienstnummer + '\'' +
                ", succesvol=" + succesvol +
                ", tijdstempel=" + tijdstempel +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getDienstnummer() {
        return dienstnummer;
    }

    public boolean isSuccesvol() {
        return succesvol;
    }

    public LocalDateTime getTijdstempel() {
        return tijdstempel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDienstnummer(String dienstnummer) {
        this.dienstnummer = dienstnummer;
    }

    public void setSuccesvol(boolean succesvol) {
        this.succesvol = succesvol;
    }

    public void setTijdstempel(LocalDateTime tijdstempel) {
        this.tijdstempel = tijdstempel;
    }
}
