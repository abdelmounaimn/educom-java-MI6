package nu.educom.MI6.models;

import java.util.Date;

public class LoginAttempt {

    private int id;
    private String diensnummer;
    private boolean succesvol;
    private Date tijdstempel;

    public LoginAttempt() {
    }

    public int getId() {
        return id;
    }

    public String getDiensnummer() {
        return diensnummer;
    }

    public boolean isSuccesvol() {
        return succesvol;
    }

    public Date getTijdstempel() {
        return tijdstempel;
    }
}
