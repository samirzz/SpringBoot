package com.BookStore.Controller;

import com.BookStore.Entity.Book;
import com.BookStore.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
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
//    public String getAllBook() {
//        return "bookList";
    public ModelAndView getAllBook() {
        List<Book> list = service.getAllBook();
        System.out.println("this is in book list" + list);

        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/Submit")
    public String addBook(@ModelAttribute Book b) {
        System.out.println("for controller " + b);
        service.submit(b);

        return "redirect:/available_books";

    }
}
