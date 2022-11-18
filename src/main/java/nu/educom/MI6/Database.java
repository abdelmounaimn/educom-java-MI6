package nu.educom.MI6;

import nu.educom.MI6.models.Agent;
import nu.educom.MI6.models.LoginAttempt;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Database {

    Connection conn;

    public void connection() {
        try {
            this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/m16", "root", "Mounaim");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean saveAttempt(String dienstnummer, boolean succesvol) {
        //LoginAttempt at = new LoginAttempt();
        try {
            this.connection();
            Statement statement;
            statement = this.conn.createStatement();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String sql = "INSERT INTO login_attempts ( dienstnummer, succesvol, tijdstempel ) " +
                    "VALUES ( '" + dienstnummer + "' , " + (succesvol ? 1 : 0) + " , '" + dtf.format(now) + "' )";
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

    public Agent findAgent(String dienstnummer) {
        Agent a=null;
        try {
            this.connection();
            Statement statement;
            statement = this.conn.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select * from agents where dienstnummer =" + dienstnummer);

            int code;
            String title;
            boolean hasNext = false;
            while (resultSet.next()) {
                a = new Agent();
                hasNext = true;
                a.setId(resultSet.getInt("id"));
                a.setDienstnummer(resultSet.getString("dienstnummer"));
                a.setCode(resultSet.getString("code"));
                a.setActief(resultSet.getInt("actief") == 0 ? false : true);
                a.setLicenceToKill(resultSet.getInt("licence_to_kill") == 0 ? false : true);
                a.setEindLicence(resultSet.getDate("eind_licence"));
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

    public boolean authenticateAgent(String dienstnummer, String code) {
        Agent agent = findAgent(dienstnummer);
        if (agent != null) {
            System.out.println(agent);
            if (agent.getCode().equals(code)) {
                this.saveAttempt(dienstnummer, true);
                return true;
            }
        }
        this.saveAttempt(dienstnummer, false);
        return false;
    }

    public List<LoginAttempt> getLastLoginAttempts(String dienstnummer) {
        List<LoginAttempt> lastLoginAttempts = new ArrayList<LoginAttempt>();
        try {
            this.connection();
            Statement statement;
            statement = this.conn.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("select max(id) from login_attempts where dienstnummer =" + dienstnummer + " and succesvol = 1");
            int seccesId = 0;
            while (resultSet.next()) {
                seccesId = resultSet.getInt(1);
            }
            resultSet = statement.executeQuery("select * from login_attempts where  dienstnummer =" + dienstnummer );
            if (seccesId > 0) {
                resultSet = statement.executeQuery("select * from login_attempts where  dienstnummer =" + dienstnummer + " and id >" + seccesId);
            }

                LoginAttempt at = new LoginAttempt();
                while (resultSet.next()) {
                    at = new LoginAttempt();
                    at.setId(resultSet.getInt("id"));
                    at.setSuccesvol((resultSet.getInt("succesvol") == 1) ? true : false);
                    at.setDienstnummer(resultSet.getString("dienstnummer"));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime date = LocalDateTime.parse(resultSet.getString("tijdstempel"), formatter);
                    at.setTijdstempel(date);
                    lastLoginAttempts.add(at);
                }

            resultSet.close();
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
        return lastLoginAttempts;
    }

    public int wachtTijd(String dienstnummer) {
        List<LoginAttempt> lastLoginAttempts = this.getLastLoginAttempts(dienstnummer);
        int numPog = lastLoginAttempts.size();
        if (numPog == 0) return 0;
        else {
            LocalDateTime latstTime = lastLoginAttempts.get(numPog - 1).getTijdstempel();
            LocalDateTime now = LocalDateTime.now();
            int tussenTijd = (int) Duration.between(latstTime, now).getSeconds();

            int minTussenTijd = (int) (Math.pow(2, numPog))*60;
            int result = minTussenTijd - tussenTijd;
            return result <= 0 ? 0 : result;
        }
    }


}