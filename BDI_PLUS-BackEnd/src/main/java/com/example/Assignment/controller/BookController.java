package com.example.Assignment.controller;

import com.example.Assignment.common.BaseResponse;
import com.example.Assignment.common.BookDto;
import com.example.Assignment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> addNewBook( @RequestBody BookDto bookDto){
        BaseResponse baseResponse = bookService.addNewBook(bookDto);
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

    @GetMapping("/get-book/{bookId}")
    public ResponseEntity<BaseResponse> fetchBookById(@PathVariable int bookId){
        BaseResponse baseResponse = bookService.fetchBookById( bookId);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<BaseResponse> fetchAllBooks(){
        BaseResponse baseResponse = bookService.fetchAllBooks();
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<BaseResponse> updateBook(@PathVariable int bookId, @Validated @RequestBody BookDto bookDto){
        BaseResponse baseResponse = bookService.updateBookById(bookId,bookDto);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<BaseResponse> deleteBookById(@PathVariable int bookId){
        BaseResponse baseResponse = bookService.deleteBookById(bookId);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/user/{name}")
    public String returnName(@PathVariable String name){
        return name;
    }

}
