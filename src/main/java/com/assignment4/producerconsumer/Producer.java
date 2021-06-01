package com.assignment4.producerconsumer;

import com.assignment1.item.ItemDTO;
import java.sql.ResultSet;

@SuppressWarnings({"PMD.CommentRequired","PMD.SystemPrintln"})
public class Producer implements Runnable {
  private final InMemoryDS dataStructure;
  private final ResultSet resultSet;

  public Producer(final InMemoryDS dataStructure, final ResultSet resultSet) {
    this.dataStructure = dataStructure;
    this.resultSet = resultSet;
    final Thread t = new Thread(this, "Producer");
    t.start();
  }

  @Override
  public void run() {
    try {
      while (resultSet.next()) {
        final ItemDTO item = new ItemDTO();
        item.setName(resultSet.getString("name"));
        item.setPrice(resultSet.getString("price"));
        item.setQuantity(resultSet.getString("quantity"));
        item.setType(resultSet.getString("type"));
        dataStructure.produce(item);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}