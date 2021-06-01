package com.assignment4.mysqlDB;

import com.assignment1.item.ItemEntity;
import java.sql.*;

@SuppressWarnings({"PMD.CommentRequired","PMD.SystemPrintln"})
public class DatabaseOperations {

  private final Statement statement;

  public DatabaseOperations() throws SQLException {
    final Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/salesdb", "root", "");
    statement = connection.createStatement();
  }

  public void write(final ItemEntity item) {
    try {
      final String sql = "INSERT INTO sales(name, price, quantity, type) VALUES(" + item.getName()
              + ", " + item.getPrice() + ", " + item.getQuantity() + ", " + item.getType() + ")";
      statement.executeUpdate(sql);
    } catch (SQLException except) {
      System.out.println(except.getMessage());
    }
  }

  public ResultSet read() {
    ResultSet resultSet = null;
    try {
      resultSet = statement.executeQuery("select * from sales");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return resultSet;
  }
}
