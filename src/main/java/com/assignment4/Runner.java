package com.assignment4;

import com.assignment4.mysqlDB.DatabaseOperations;
import com.assignment4.producerconsumer.Consumer;
import com.assignment4.producerconsumer.InMemoryDS;
import com.assignment4.producerconsumer.Producer;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings({"PMD.CommentRequired","PMD.SystemPrintln"})
public final class Runner {

  private Runner() {
  }

  public static void main(final String[] args) throws SQLException {
    final InMemoryDS dataStructure = new InMemoryDS();
    final DatabaseOperations dbOperate = new DatabaseOperations();
    final ResultSet rs = dbOperate.read();
    new Producer(dataStructure,rs);
    new Consumer(dataStructure);
  }
}
