package nu.educom.MI6;

public interface IPresenter {
    void triggerLogin(String login);

    void triggerPassword(String psw);
     String showErr();
    public boolean saveAttempt(String diensnummer, boolean succesvol);
    void exit();
}
