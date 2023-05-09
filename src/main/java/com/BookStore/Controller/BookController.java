package com.BookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.BookStore.Entity.Book;
import com.BookStore.Entity.MyBookList;
import com.BookStore.Service.BookService;
import com.BookStore.Service.MyBookListService;

@Controller
@RequestMapping
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private MyBookListService myBookListService;

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
        if (b.getName().equals("") || b.getPrice().equals("") || b.getAuthor().equals("")) {
            return "redirect:/book_register";
        } else {
            service.submit(b);
            return "redirect:/available_books";

        }
    }
    @GetMapping("/my_books")
    public ModelAndView myBooks() {
        List<MyBookList> list = myBookListService.getAllMyBooks();
        return new ModelAndView("myBooks", "myBook", list);
    }

    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
        myBookListService.saveMyBook(mb);
        return "redirect:/my_books";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteMyList(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/available_books";
    }
}
