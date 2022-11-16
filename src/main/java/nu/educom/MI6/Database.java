package nu.educom.MI6;

import nu.educom.MI6.models.Agent;
import nu.educom.MI6.models.LoginAttempt;

import java.sql.*;

public class Database {

    Connection conn;

    public void connection() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/m16", "root", "Mounaim");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean saveAttempt(String diensnummer, boolean succesvol){
        LoginAttempt at = new LoginAttempt();
        try {
            this.connection();
            Statement statement;
            statement = this.conn.createStatement();
            String sql = "INSERT INTO login_attempts ( diensnummer, succesvol, tijdstempel ) "+
                    "VALUES ( '" + diensnummer + "' , "+(succesvol?1:0) + " , "+ null+" )";
            System.out.println(sql);
            statement.executeUpdate(sql);

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (this.conn != null)
                    this.conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }
    public Agent findAgent(String diensnummer) {
        Agent a = new Agent();
        try {
            this.connection();
            Statement statement;
            statement = this.conn.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from agents where diensnummer ="+diensnummer);

            int code;
            String title;
            boolean hasNext = false;
            while (resultSet.next()) {
                hasNext = true;

                a.setId(resultSet.getInt("id"));
                a.setDiensnummer(resultSet.getString("diensnummer"));
                a.setCode(resultSet.getString("code"));
                a.setActief(resultSet.getInt("actief") == 0 ? false : true);
                a.setLicentToKill(resultSet.getInt("licence_to_kill") == 0 ? false : true);
                a.setEindLicence(resultSet.getDate("eind_licence"));
                 System.out.println(a);

                System.out.println("Code : ");
            }
            resultSet.close();
            statement.close();
            return a;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (this.conn != null)
                    this.conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


}