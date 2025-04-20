/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientterrainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP G1
 */
public class Database {
    ResultSet result = null;

    void chargeDriver() {
        try {
            Class.forName("com.mysql.cj."
                    + "jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Impossible de charger ce pilote.");
        }
    }

    public Connection connectionToBD() {
        Connection con = null;
        try {

            String Dburl = "jdbc:mysql://localhost:3306/clientterrain?useSSL=false&ServerTimezone=UTC";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(Dburl, user, password);
        } catch (SQLException e) {
            System.out.println("Impossible de de se connecte a,l base de données.");
        }
        return con;
    }

}
