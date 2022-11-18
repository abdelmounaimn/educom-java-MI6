package nu.educom.MI6;

public interface IPresenter {
    boolean authenticateAgent(String dienstnummer, String code);
     String showMsg();
    void exit();
}
