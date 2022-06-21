package com.ncdc.task.service;

import com.ncdc.task.entity.Book;
import com.ncdc.task.repository.BookRepository;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookServiceImpl implements IBookService{

  @Autowired
  private BookRepository bookRepository;

  @Override
  public List<Book> getAllBooks() {
    log.info("Getting all books");
    return bookRepository.findAll();
  }

  @Override
  public void addBook(Book book) {
    log.info("Creating a book");
    book.setId(UUID.randomUUID());
    book.setAuthor(book.getAuthor().toUpperCase());
    this.bookRepository.save(book);
    log.info("Book with title: {} created!", book.getTitle());
  }
}
