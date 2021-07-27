package com.satish.springdatajpamanytomanymapping.controller;

import com.satish.springdatajpamanytomanymapping.dto.BookRequest;
import com.satish.springdatajpamanytomanymapping.model.Book;
import com.satish.springdatajpamanytomanymapping.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping("/book")
    public Book addBook(@RequestBody BookRequest request) {
        return bookRepository.save(request.getBook());
    }
}
