package com.ncdc.task.controller;

import com.ncdc.task.entity.Book;
import com.ncdc.task.service.IBookService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

  @Autowired private IBookService bookService;

  @GetMapping("/")
  public String getBooks(Model model) {
    // I'm so sorry about logic in controller, thymeleaf new to me, that was the fastest way
    List<Book> books = bookService.getAllBooks();
    if(books.isEmpty()) {
      model.addAttribute("books", books);
    }
    return "index";
  }

  @GetMapping("/newBookForm")
  public String showNewBookForm(Model model) {
    Book book = new Book();
    model.addAttribute("book", book);
    return "new-book";
  }

  @PostMapping("/addBook")
  public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult) {
    // I'm so sorry about logic in controller, thymeleaf new to me, that was the fastest way
    String[] strings = book.getAuthor().split(" ");
    for (String string : strings) {
      if (!string.toUpperCase().startsWith("A")) {
        bindingResult.addError(
            new FieldError("book", "author", "The Forename or Surname must begins with A"));
      }
    }
    if (bindingResult.hasErrors()) {
      return "new-book";
    }
    bookService.addBook(book);
    return "redirect:/";
  }

  //  @GetMapping("/delete/{id}")
  //  public String deleteUser(@PathVariable("id") long id, Model model) {
  //    Book book = bookRepository.findById(id)
  //        .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
  //    userRepository.delete(user);
  //    return "redirect:/index";
  //  }
}
