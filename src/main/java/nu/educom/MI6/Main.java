package nu.educom.MI6;

public class Main {
    public static void main(String[] args) {
 IView view = new JFrameView();
        Presenter presenter= new Presenter(view);
        presenter.run();
    }
}