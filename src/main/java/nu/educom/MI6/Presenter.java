package nu.educom.MI6;

public class Presenter implements IPresenter {
    private IView view;
    private User user;

    public Presenter(IView view) {
        this.user = new User();
        this.view = view;
        this.view.installPresentor(this);
    }

    @Override
    public void triggerLogin(String login) {
        if (user.userNamevalidation(login)) {
            user.setLogin(login);
            user.setEr("");
        } else {
            user.setEr(" inlog gegevens zijn niet correct! ");
        }
    }

    @Override
    public void triggerPassword(String psw) {
        if (user.passwordvalidation(psw)) {
            user.setLogin(psw);
        } else {
            user.setEr(" inlog gegevens zijn niet correct! ");
        }

    }

    @Override
    public void exit() {

    }

    public void run() {
        this.view.show();
    }

    public String showErr() {
        return this.user.getEr();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
