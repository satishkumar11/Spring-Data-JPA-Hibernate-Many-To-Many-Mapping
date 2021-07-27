package com.satish.springdatajpamanytomanymapping.controller;

import com.satish.springdatajpamanytomanymapping.dto.AuthorAddRequest;
import com.satish.springdatajpamanytomanymapping.dto.AuthorUpdateRequest;
import com.satish.springdatajpamanytomanymapping.dto.BookDTO;
import com.satish.springdatajpamanytomanymapping.exception.ResourceNotFoundException;
import com.satish.springdatajpamanytomanymapping.model.Author;
import com.satish.springdatajpamanytomanymapping.model.Book;
import com.satish.springdatajpamanytomanymapping.repository.AuthorRepository;
import com.satish.springdatajpamanytomanymapping.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorService authorService;

    @PostMapping("/author")
    public List<Author> addAuthors(@RequestBody AuthorAddRequest request) {
        return authorService.addAuthors(request);
    }

    @PutMapping("/author/{id}")
    public Author updateAuthor(@PathVariable(value = "id") Integer id, @RequestBody AuthorUpdateRequest request) {
        return authorRepository.findById(id).map(author -> {
            author.setName(request.getName());
            List<Book> books = new ArrayList<>();
            for (BookDTO bookDTO : request.getBooks()) {
                Book book = new Book();
                book.setId(bookDTO.getId());
                book.setTitle(bookDTO.getTitle());
                books.add(book);
            }
            author.setBooks(books);
            return authorRepository.save(author);
        }).orElseThrow(() -> new ResourceNotFoundException("Author with id : " + id + " not found"));
    }

    @GetMapping("/author")
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/author/{id}")
    public ResponseEntity getAuthorById(@PathVariable(value = "id") Integer id) {
        return authorRepository.findById(id).map(author ->
                ResponseEntity.ok(author)).orElseThrow(() ->
                new ResourceNotFoundException("Author with id : " + id + " not found")
        );
    }

    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable(value = "id") Integer id) {
        return authorRepository.findById(id).map(author -> {
            authorRepository.delete(author);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Author with id : " + id + " not found"));
    }
}
