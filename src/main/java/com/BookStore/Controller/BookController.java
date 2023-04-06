package com.BookStore.Controller;

import com.BookStore.Entity.Book;
import com.BookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    private BookService service;
    @GetMapping("/")
    public String home() {
        System.out.println("we are entering");
        return "home";
    }
//new book register
    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public String availableBooks() {
        return "availableBooks";
    }

    @GetMapping("/my_books")
    public String myBooks() {
        return "myBooks";
    }

    @GetMapping("/book_store")
    public String bookStore() {
        return "bookStore";
    }

    @PostMapping ("/Submit")
    public String addBook(@ModelAttribute Book b){
        service.submit(b);
        return "redirect:/available_books";

    }
}
