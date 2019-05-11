package com.example.sarafan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private Connection connection;

    public DBConnection() {
    }

    public void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rppz?useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public List<People> getAllBuses() {
        String findAll = "SELECT * FROM information";
        ResultSet resultSet = null;
        List<People> buses = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(findAll);
            resultSet = preparedStatement.executeQuery(findAll);

            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String q = resultSet.getString(2);
                String w = resultSet.getString(3);
                String e = resultSet.getString(4);
                String r = resultSet.getString(5);
                String t = resultSet.getString(6);;
                People car = new People(id, q, w, e, r, t);
                buses.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return buses;
    }



}
