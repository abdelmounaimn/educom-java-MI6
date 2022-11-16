package nu.educom.MI6;

public class User {
    private String login;
    private String password;
    private String er;

    public User(String login, String password, String er) {
        this.login = login;
        this.password = password;
        this.er = er;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEr() {
        return er;
    }

    public void setEr(String er) {
        this.er = er;
    }



}
