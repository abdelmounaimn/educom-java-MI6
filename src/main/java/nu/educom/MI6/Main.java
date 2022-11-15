package nu.educom.MI6;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        try {
            JFrame frame = new JFrame("log in");
            boolean valid = false;
            while (!valid) {
                String userName = JOptionPane.showInputDialog(frame, "wat is jouw gebruikers naam");
                if (userName.length() <= 3) {
                    try {
                        int dienstNummer = Integer.parseInt(userName);
                        if (dienstNummer >= 1 && dienstNummer <= 956) {
                            valid = true;
                        }
                    } catch (NumberFormatException ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            }
            valid = false;
            while (!valid) {
                String code = JOptionPane.showInputDialog(frame, "wat is jouw code");
                try {
                    if (code.equals("For ThE Royal QUEEN")) {
                        valid = true;
                    }
                } catch (NumberFormatException ex) {
                    System.err.println(ex.getMessage());
                }
            }
            System.exit(0);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}