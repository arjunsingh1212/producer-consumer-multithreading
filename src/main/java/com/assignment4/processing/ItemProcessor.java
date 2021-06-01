package com.assignment4.processing;

import com.assignment1.exceptions.GenericApplicationException;
import com.assignment1.item.ItemDTO;
import com.assignment1.item.ItemEntity;
import com.assignment1.parser.CommandLineParser;
import com.assignment1.parser.Parsable;
import com.assignment1.writer.WriterItem;
import com.assignment1.writer.WriterItemCLI;

@SuppressWarnings({"PMD.CommentRequired","PMD.SystemPrintln"})
public class ItemProcessor {
  public void process(final ItemDTO itemDTO) throws GenericApplicationException {
    final Parsable parser = new CommandLineParser();
    final ItemEntity itemEntity = parser.parse(itemDTO);
    final WriterItem writer = new WriterItemCLI();
    writer.write(itemEntity);
  }
}
