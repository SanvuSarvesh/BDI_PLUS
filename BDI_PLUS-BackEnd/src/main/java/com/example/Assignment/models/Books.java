package com.example.Assignment.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;

    private String bookName;

    private String authorName;

    private int price;

    private int noOfPages;

    private String language;

}
