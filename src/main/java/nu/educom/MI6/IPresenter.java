package nu.educom.MI6;

public interface IPresenter {
    void triggerLogin(String login);

    void triggerPassword(String psw);
     String showErr();
    void exit();
}
