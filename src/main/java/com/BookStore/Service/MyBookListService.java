package com.BookStore.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BookStore.Entity.MyBookList;
import com.BookStore.Repository.MybookRepository;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MybookRepository mybook;

    public void saveMyBook(MyBookList book) {
        mybook.save(book);

    }

    public List<MyBookList> getAllMyBooks() {
        return mybook.findAll();
    }

    public void deleteById(int id) {
        mybook.deleteById(id);
    }
}
