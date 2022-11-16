package nu.educom.MI6;

import nu.educom.MI6.models.Agent;

public class Presenter implements IPresenter {
    private IView view;
    private Agent agent;
    private String err = "*";
    private Database db;

    public Presenter(IView view) {
        this.db = new Database();

        this.agent = new Agent();
        this.view = view;
        this.view.installPresentor(this);
    }

    @Override
    public void triggerLogin(String login) {
        Agent a = db.findAgent(login);
        if (a != null) {
            this.agent = a;

        } else {
            this.err = "ACCESS DENIED";
        }
    }

    @Override
    public void triggerPassword(String psw) {
        if (this.agent != null) {
            if (this.agent.getCode().equals(psw)) {
                this.err = "";
            }else {
                this.err = "ACCESS DENIED";

            }
        } else this.err = "ACCESS DENIED";

    }

    public boolean saveAttempt(String diensnummer, boolean succesvol) {
        this.db.saveAttempt(diensnummer, succesvol);
        return true;
    }

    @Override
    public void exit() {

    }

    public void run() {
        this.view.show();
    }

    public String showErr() {
        return this.err;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }
}
