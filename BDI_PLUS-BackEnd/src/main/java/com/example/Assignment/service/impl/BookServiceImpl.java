package com.example.Assignment.service.impl;

import com.example.Assignment.common.BaseResponse;
import com.example.Assignment.common.BookDto;
import com.example.Assignment.exception.BookServiceException;
import com.example.Assignment.models.Books;
import com.example.Assignment.repository.BookRepository;
import com.example.Assignment.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.Assignment.common.Constants.NO_BOOK_FOUND;

@Service
public class BookServiceImpl implements  BookService{

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BaseResponse addNewBook(BookDto bookDto){
        BaseResponse baseResponse = new BaseResponse();
        Books book = new Books();
        book.setBookName(bookDto.getBookName());
        book.setPrice(bookDto.getPrice());
        book.setLanguage(bookDto.getLanguage());
        book.setPrice(bookDto.getPrice());
        book.setAuthorName(bookDto.getAuthorName());
        book.setNoOfPages(bookDto.getNoOfPages());
        bookRepository.save(book);

        baseResponse.setMessage("New book added successfully");
        baseResponse.setSuccess(true);
        baseResponse.setStatusCode(HttpStatus.CREATED.toString());
        baseResponse.setPayload(book);
        return baseResponse;
    }

    @Override
    public BaseResponse fetchBookById(int bookId) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Books> book = bookRepository.findById(bookId);
        if(book.isEmpty()){
            throw new BookServiceException(NO_BOOK_FOUND+ bookId, HttpStatus.NOT_FOUND);
        }
        baseResponse.setPayload(book);
        baseResponse.setMessage("Book fetched successfully");
        baseResponse.setSuccess(true);
        baseResponse.setStatusCode(HttpStatus.OK.toString());
        return baseResponse;
    }

    @Override
    public BaseResponse updateBookById(int bookId, BookDto bookDto) {
        BaseResponse baseResponse = new BaseResponse();

        Optional<Books> bookOpt = bookRepository.findById(bookId);
        if(bookOpt.isEmpty()){
            throw new BookServiceException(NO_BOOK_FOUND+ bookId, HttpStatus.NOT_FOUND);
        }
        Books book = bookOpt.get();
        book.setBookName(bookDto.getBookName());
        book.setPrice(bookDto.getPrice());
        book.setLanguage(bookDto.getLanguage());
        book.setPrice(bookDto.getPrice());
        book.setAuthorName(bookDto.getAuthorName());
        book.setNoOfPages(bookDto.getNoOfPages());

        bookRepository.save(book);
        baseResponse.setPayload(book);
        baseResponse.setMessage("Book info updated successfully");
        baseResponse.setSuccess(true);
        baseResponse.setStatusCode(HttpStatus.OK.toString());
        return baseResponse;
    }

    @Override
    public BaseResponse fetchAllBooks() {
        BaseResponse baseResponse = new BaseResponse();
        List<Books> booksList = bookRepository.findAll();
        baseResponse.setPayload(booksList);
        baseResponse.setMessage("All books fetched successfully");
        baseResponse.setSuccess(true);
        baseResponse.setStatusCode(HttpStatus.OK.toString());
        return baseResponse;
    }

    @Override
    public BaseResponse deleteBookById(int bookId) {
        BaseResponse baseResponse = new BaseResponse();
        Optional<Books> book = bookRepository.findById(bookId);
        if(book.isEmpty()){
            throw new BookServiceException(NO_BOOK_FOUND+ bookId, HttpStatus.NOT_FOUND);
        }
        bookRepository.deleteById(bookId);
        baseResponse.setMessage("Book is deleted successfully.");
        baseResponse.setSuccess(true);
        baseResponse.setStatusCode(HttpStatus.OK.toString());
        return baseResponse;
    }

}
