package db;

import constants.Constants;

import java.sql.*;

public class JDBC {

    public static boolean registerUser(String name, int age, String email, String password){
        try{
            if(!checkUser(name)){
                Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);
                PreparedStatement registerUser = connection.prepareStatement("INSERT INTO " + Constants.DB_TABLE_NAME + " VALUES(?,?,?,?)");
                registerUser.setString(1, name);
                registerUser.setInt(2, age);
                registerUser.setString(3, email);
                registerUser.setString(4, password);
                registerUser.executeUpdate();
                return true;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    public static boolean checkUser(String username){
        try{
            Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);
            PreparedStatement checkUser = connection.prepareStatement("SELECT * FROM " + Constants.DB_TABLE_NAME + " WHERE username = ?");
            checkUser.setString(1, username);
            ResultSet resultSet = checkUser.executeQuery();
            if(!resultSet.isBeforeFirst()){
                return false;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean loginUser(String name, String email, String password){
        try{
            Connection connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);
            PreparedStatement loginUser = connection.prepareStatement("SELECT * FROM " + Constants.DB_TABLE_NAME + " WHERE username = ? AND password = ? AND email = ?");
            loginUser.setString(1, name);
            loginUser.setString(2, password);
            loginUser.setString(3, email);
            ResultSet resultSet = loginUser.executeQuery();
            if(!resultSet.isBeforeFirst()){
                return false;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return true;
    }

}
