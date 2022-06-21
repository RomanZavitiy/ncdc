package com.ncdc.task.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;

  private String author;

  private String title;

  private String isbn;

  public Book() {

  }

  public Book(String author, String title, String isbn) {
    this.author = author;
    this.title = title;
    this.isbn = isbn;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  @Id
  public UUID getId() {
    return id;
  }
}
