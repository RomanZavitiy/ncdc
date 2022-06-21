package com.ncdc.task.service;

import com.ncdc.task.entity.Book;
import java.util.List;

public interface IBookService {

  List<Book> getAllBooks();

  void addBook(Book book);
}
