package nu.educom.MI6;

public class User {
    private String login;
    private String password;
    private String er="Errors : ";
    private boolean valid = false;

    public User(String login, String password, String er) {
        this.login = login;
        this.password = password;
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

    public boolean userNamevalidation(String login) {
        boolean valid = false;

        if (login.length() <= 3) {
            try {
                int dienstNummer = Integer.parseInt(login);
                if (dienstNummer >= 1 && dienstNummer <= 956 ) {
                    valid = true;
                }
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return valid;
    }
    public boolean passwordvalidation( String psw) {
        boolean valid = false;

            try {
                if (psw.equals("For ThE Royal QUEEN") ) {
                    valid = true;
                }
            } catch (NumberFormatException ex) {
                System.err.println(ex.getMessage());
            }
        return valid;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", er='" + er + '\'' +
                '}';
    }
}