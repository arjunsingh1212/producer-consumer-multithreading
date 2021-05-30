package com.assignment4.mysqlDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseOperations {
  public static void main(String[] args) {
    try {
      Connection connection = DriverManager.getConnection(
              "jdbc:mysql://localhost:3306/salesDB", "root", "");
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from sales");
      while (resultSet.next()) {
        System.out.println(resultSet.getString("name"));
        System.out.println(resultSet.getString("price"));
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
