package nu.educom.MI6;

public class Presenter implements IPresenter {
    private IView view;

    private String msg = "*";
    private Database db;

    public Presenter(IView view) {
        this.db = new Database();
        this.view = view;
        this.view.installPresentor(this);
    }

    @Override
    public boolean authenticateAgent(String dienstnummer, String code) {
        String valideDinstNummer = this.ValidateDienstnummer(dienstnummer);
        if (valideDinstNummer.length() > 0) {
            int wachtTime = db.wachtTijd(valideDinstNummer);
            if (wachtTime < 1) {
                boolean logenIn = db.authenticateAgent(valideDinstNummer, code);
                if (logenIn) {
                    var enidLicence = db.findAgent(valideDinstNummer).getEindLicence();
                    if (enidLicence != null) {
                        this.msg = "jouw licence is valide tot : " + enidLicence.toString();
                    } else {
                        this.msg = "jij hebt geen Licence: ";
                    }
                    return true;
                } else {
                    this.msg = "gegevens niet correct, prober het opnieuw na 1M";
                }
            } else {
                int sec = wachtTime % 60;
                int min = ((wachtTime - sec) / 60) % 60;
                int uur = ((wachtTime - sec) - (min * 60)) / 3600;
                this.msg = "probeer het op nieuw na " + wachtTime + " :: " + uur + "H : " + min + "M : " + sec + "S";
            }
        }
        return false;
    }

    public String ValidateDienstnummer(String dienstnummer) {
        //000 , 001 , 020, 100 ,2 ,23,20,
        int size = dienstnummer.length();
        StringBuilder out = new StringBuilder("000");
        if (size <= 3 && size > 0) {
            for (int i = size - 1, j = 2; i >= 0; i--, j--) {
                char c = dienstnummer.charAt(i);
                int comp = Character.compare(c, '0');
                if (comp < 0 || comp > 9) {
                    return "";
                } else {
                    out.setCharAt(j, c);
                }
            }
            return out.toString();
        }
        return "";
    }

    @Override
    public void exit() {
    }

    public void run() {
        this.view.show();
    }

    public String showMsg() {
        return this.msg;
    }
}

