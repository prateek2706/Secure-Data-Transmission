/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package securedata;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dbconnection {

    static Connection con = null;
    PreparedStatement pst = null;
    public static Connection conn = null;
    public static Statement stat = null;
    public static ResultSet rs1;
    static PreparedStatement ps = null;
    public static ResultSet rs = null;
    static String rdate = "";
    static String rtime = "";

    public static Connection openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_securedata", "root", "");
            stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("connection made");
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
    public static void closeConnection() {
        try {
            stat.close();
            conn.close();
            //rs.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    public static Connection makeConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_securedata", "root", "");

        } catch (Exception e) {
        }
        return con;
    }
}
