package nu.educom.MI6;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        boolean loginCorrect = false;
        while (!loginCorrect) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("wat is jouw gebruikers naam");
                String userName = input.nextLine();
                if (userName.length() <= 3) {
                    int dienstNummer = Integer.parseInt(userName);
                    if (dienstNummer >= 1 && dienstNummer <= 956) {
                        System.out.println("wat is de geheime code?");
                        String geheimeCode = input.nextLine();
                        System.out.println(geheimeCode);
                        if (geheimeCode.equals("For ThE Royal QUEEN")) {
                            loginCorrect = true;
                            System.out.println("jij ben ingelogd jouw gebruikers naam is : " + dienstNummer);
                        } else {
                            System.out.println("geheim code niet correct >..");
                        }
                    }
                } else {
                    System.out.println("inlog gegevens niet correct >..");
                }
            } catch (NumberFormatException ex) {
                System.err.println("gegevens niet correct ");
            }
        }

    }
}