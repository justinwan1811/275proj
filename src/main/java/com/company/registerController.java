package com.company;

import java.sql.*;

public class registerController {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://34.83.219.17:3306/connect";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    public PreparedStatement stmt;
    public Connection con;


    public void addUserEmail(int id, String firstName, String lastName, String email, String password, String roleType)
    {
        stmt = null;
        con = null;
        try{
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO userLogin VALUES(?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, email);
            stmt.setString(5, password);
            stmt.setString(6, roleType);
            stmt.executeUpdate();
        } catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}