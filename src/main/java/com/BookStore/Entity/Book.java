package com.BookStore.Entity;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String author;
    private String price;

}
