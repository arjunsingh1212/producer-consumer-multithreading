package com.assignment4.producerconsumer;

import com.assignment1.item.ItemDTO;
import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings({"PMD.CommentRequired","PMD.SystemPrintln"})
public class InMemoryDS {
  private static final int MAX_SIZE = 3;
  private final Queue<ItemDTO> queue = new LinkedList<>();

  public synchronized void produce(final ItemDTO item) {
    while (queue.size() == MAX_SIZE) {
      try {
        wait();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    queue.add(item);
    //System.out.println("Put : " + item.toString());
    notifyAll();
  }

  public synchronized ItemDTO consume() {
    while (queue.size() == 0) {
      try {
        wait();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    final ItemDTO item = queue.peek();
    queue.remove();
    //System.out.println("Get : " + item.toString());
    notifyAll();
    return item;
  }

}
