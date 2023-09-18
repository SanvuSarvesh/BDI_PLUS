package com.example.Assignment.controller;


import com.example.Assignment.common.BaseResponse;
import com.example.Assignment.common.BookDto;
import com.example.Assignment.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BookControllerTest {

    @Autowired
    private BookController bookController;

    @MockBean
    private BookServiceImpl bookService;

    BookDto books;

    @BeforeEach
    void BookObject() {
        books = new BookDto();
        books.setBookName("new book");
        books.setBookId(123);
        books.setAuthorName("new Author");
        books.setPrice(250);
        books.setNoOfPages(145);
    }

    @Test
    void addBookTest() {
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookController bookController = Mockito.mock(BookController.class);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("New book added successfully");
        baseResponse.setStatusCode(String.valueOf(HttpStatus.CREATED));

        ResponseEntity<BaseResponse> expectedResponse = new ResponseEntity<>(baseResponse, HttpStatus.OK);
        Mockito.when(bookController.addNewBook(books)).thenReturn(expectedResponse);
        Mockito.when(bookService.addNewBook(books)).thenReturn(baseResponse);
        ResponseEntity<BaseResponse> actualResponse = bookController.addNewBook(books);

        assertTrue(actualResponse.getBody().getSuccess());
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getSuccess(), actualResponse.getBody().getSuccess());

    }

    @Test
    void fetchBookByIdTest() {
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookController bookController = Mockito.mock(BookController.class);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Book fetched successfully");
        baseResponse.setStatusCode(String.valueOf(HttpStatus.OK));

        ResponseEntity<BaseResponse> expectedResponse = new ResponseEntity<>(baseResponse, HttpStatus.OK);
        Mockito.when(bookController.fetchBookById(books.getBookId())).thenReturn(expectedResponse);
        Mockito.when(bookService.fetchBookById(books.getBookId())).thenReturn(baseResponse);
        ResponseEntity<BaseResponse> actualResponse = bookController.fetchBookById(books.getBookId());

        assertTrue(actualResponse.getBody().getSuccess());
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getSuccess(), actualResponse.getBody().getSuccess());
    }

    @Test
    void updateBookTest() {
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookController bookController = Mockito.mock(BookController.class);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Book info updated successfully");
        baseResponse.setStatusCode(String.valueOf(HttpStatus.OK));

        ResponseEntity<BaseResponse> expectedResponse = new ResponseEntity<>(baseResponse, HttpStatus.OK);
        Mockito.when(bookController.updateBook(books.getBookId(), books)).thenReturn(expectedResponse);
        Mockito.when(bookService.updateBookById(books.getBookId(), books)).thenReturn(baseResponse);
        ResponseEntity<BaseResponse> actualResponse = bookController.updateBook(books.getBookId(), books);

        assertTrue(actualResponse.getBody().getSuccess());
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getSuccess(), actualResponse.getBody().getSuccess());
    }

    @Test
    void fetchAllBooksTest() {
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookController bookController = Mockito.mock(BookController.class);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("All books fetched successfully");
        baseResponse.setStatusCode(String.valueOf(HttpStatus.OK));

        ResponseEntity<BaseResponse> expectedResponse = new ResponseEntity<>(baseResponse, HttpStatus.OK);
        Mockito.when(bookController.fetchAllBooks()).thenReturn(expectedResponse);
        Mockito.when(bookService.fetchAllBooks()).thenReturn(baseResponse);
        ResponseEntity<BaseResponse> actualResponse = bookController.fetchAllBooks();

        assertTrue(actualResponse.getBody().getSuccess());
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getSuccess(), actualResponse.getBody().getSuccess());
    }

    @Test
    void deleteBookByIdTest() {
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookController bookController = Mockito.mock(BookController.class);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Book is deleted successfully.");
        baseResponse.setStatusCode(String.valueOf(HttpStatus.OK));

        ResponseEntity<BaseResponse> expectedResponse = new ResponseEntity<>(baseResponse, HttpStatus.OK);
        Mockito.when(bookController.deleteBookById(books.getBookId())).thenReturn(expectedResponse);
        Mockito.when(bookService.deleteBookById(books.getBookId())).thenReturn(baseResponse);
        ResponseEntity<BaseResponse> actualResponse = bookController.deleteBookById(books.getBookId());

        assertTrue(actualResponse.getBody().getSuccess());
        assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(expectedResponse.getBody().getSuccess(), actualResponse.getBody().getSuccess());
    }
}
