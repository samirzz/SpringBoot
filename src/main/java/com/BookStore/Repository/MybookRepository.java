package com.BookStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BookStore.Entity.MyBookList;
@Repository
public interface MybookRepository extends JpaRepository<MyBookList,Integer> {

}
