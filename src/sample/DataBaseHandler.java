package sample;

import sample.*;

import java.sql.*;

public class DataBaseHandler {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + "localHost" + ":" + "3306" + "/" + "a1";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, "root", "1234");
        return dbConnection;
    }

    //Авторизация
    public ResultSet getUser(Us us) {
        ResultSet resSet = null;
        String select = "SELECT * FROM userdata" + " WHERE Email" +
                "=? AND Password" + "=?";
        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, us.getLogin());
            prSt.setString(2, us.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
    public ResultSet  getRoles(Us us){
        ResultSet resSet = null;
        String select = "SELECT ID FROM userdata" + " WHERE Email"+ " =? AND Password" + " =?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, us.getLogin());
            prSt.setString(2, us.getPassword());
            resSet = prSt.executeQuery();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;

    }

}