package com.example.Assignment.service;

import com.example.Assignment.common.BaseResponse;
import com.example.Assignment.common.BookDto;
import com.example.Assignment.repository.BookRepository;
import com.example.Assignment.service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookServiceImpl bookService;

    @MockBean
    private BookRepository bookRepository;

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
        BookRepository bookRepository = Mockito.mock(BookRepository.class);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("New book added successfully");
        baseResponse.setStatusCode(String.valueOf(HttpStatus.CREATED));

        Mockito.when(bookRepository.save(books)).thenReturn(books);
        Mockito.when(bookService.addNewBook(books)).thenReturn(baseResponse);
        BaseResponse actualResponse = bookService.addNewBook(books);

        assertTrue(actualResponse.getSuccess());
        assertEquals(baseResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(baseResponse.getSuccess(), actualResponse.getSuccess());

    }

    @Test
    void fetchBookByIdTest() {
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookRepository bookRepository = Mockito.mock(BookRepository.class);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Book fetched successfully");
        baseResponse.setStatusCode(HttpStatus.OK.toString());

        Mockito.when(bookRepository.findById(books.getBookId())).thenReturn(Optional.ofNullable(books));
        Mockito.when(bookService.fetchBookById(books.getBookId())).thenReturn(baseResponse);

        BaseResponse actualResponse = bookService.fetchBookById(books.getBookId());
        assertTrue(actualResponse.getSuccess());
        assertEquals(baseResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(baseResponse.getSuccess(), actualResponse.getSuccess());
    }

    @Test
    void updateBookTest() {
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookRepository bookRepository = Mockito.mock(BookRepository.class);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Book info updated successfully");
        baseResponse.setStatusCode(String.valueOf(HttpStatus.OK));

        Mockito.when(bookRepository.findById(books.getBookId())).thenReturn(Optional.ofNullable(books));
        Mockito.when(bookService.updateBookById(books.getBookId(), books)).thenReturn(baseResponse);
        BaseResponse actualResponse = bookService.updateBookById(books.getBookId(), books);

        assertTrue(actualResponse.getSuccess());
        assertEquals(baseResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(baseResponse.getSuccess(), actualResponse.getSuccess());
    }

    @Test
    void fetchAllBooksTest() {
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookRepository bookRepository = Mockito.mock(BookRepository.class);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("All books fetched successfully");
        baseResponse.setStatusCode(String.valueOf(HttpStatus.OK));

        Mockito.when(bookRepository.findAll()).thenReturn(new ArrayList<>());
        Mockito.when(bookService.fetchAllBooks()).thenReturn(baseResponse);
        BaseResponse actualResponse = bookService.fetchAllBooks();

        assertTrue(actualResponse.getSuccess());
        assertEquals(baseResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(baseResponse.getSuccess(), actualResponse.getSuccess());
    }

    @Test
    void deleteBookByIdTest() {
        BookServiceImpl bookService = Mockito.mock(BookServiceImpl.class);
        BookRepository bookRepository = Mockito.mock(BookRepository.class);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Book is deleted successfully.");
        baseResponse.setStatusCode(String.valueOf(HttpStatus.OK));

        Mockito.when(bookRepository.findById(books.getBookId())).thenReturn(Optional.ofNullable(books));
        Mockito.when(bookService.deleteBookById(books.getBookId())).thenReturn(baseResponse);
        BaseResponse actualResponse = bookService.deleteBookById(books.getBookId());

        assertTrue(actualResponse.getSuccess());
        assertEquals(baseResponse.getStatusCode(), actualResponse.getStatusCode());
        assertEquals(baseResponse.getSuccess(), actualResponse.getSuccess());
    }
}

