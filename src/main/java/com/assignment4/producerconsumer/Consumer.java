package com.assignment4.producerconsumer;

import com.assignment1.item.ItemDTO;
import com.assignment4.processing.ItemProcessor;

@SuppressWarnings({"PMD.CommentRequired","PMD.SystemPrintln"})
public class Consumer implements Runnable {
  private final InMemoryDS dataStructure;
  private final ItemProcessor processor = new ItemProcessor();

  public Consumer(final InMemoryDS dataStructure) {
    this.dataStructure = dataStructure;
    final Thread t = new Thread(this, "Consumer");
    t.start();
  }

  @Override
  public void run() {
    try {
      while (true) {
        final ItemDTO item = dataStructure.consume();
        processor.process(item);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}