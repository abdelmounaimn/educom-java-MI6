package nu.educom.MI6;

public class Presentor implements IPresentor {
    private IView view;

    public Presentor(IView view) {
        this.view = view;
        this.view.installPresentor(this);
    }

    @Override
    public void triggerLogin() {

    }

    @Override
    public void triggerPassword() {

    }

    @Override
    public void exit() {

    }

    public void run() {
        this.view.show();
    }
}
