package com.BookStore.Service;

import com.BookStore.Entity.Book;
import com.BookStore.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bRepo;
    public void submit(Book b){
        bRepo.save(b);

    }
    public List<Book> getAllBook(){
        return bRepo.findAll();
    }
}
