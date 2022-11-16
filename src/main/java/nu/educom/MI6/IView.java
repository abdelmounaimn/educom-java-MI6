package nu.educom.MI6;
public interface IView {
    void askFormLogin();

    void askFormPassword();

    void showLoggedIn();

    void show();

    void installPresentor(IPresentor presentor);

}
