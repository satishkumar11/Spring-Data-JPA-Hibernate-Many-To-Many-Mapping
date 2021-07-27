package com.satish.springdatajpamanytomanymapping.service;

import com.satish.springdatajpamanytomanymapping.dto.AuthorAddRequest;
import com.satish.springdatajpamanytomanymapping.dto.AuthorDTO;
import com.satish.springdatajpamanytomanymapping.dto.BookDTO;
import com.satish.springdatajpamanytomanymapping.model.Author;
import com.satish.springdatajpamanytomanymapping.model.Book;
import com.satish.springdatajpamanytomanymapping.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> addAuthors(AuthorAddRequest request) {
        List<Author> authors = new ArrayList<>();


        List<Book> books = new ArrayList<>();
        for (BookDTO bookDTO : request.getBooks()) {
            Book book = new Book();
            book.setTitle(bookDTO.getTitle());
            books.add(book);
        }

        for (AuthorDTO authorDTO : request.getAuthors()) {
            Author author = new Author();
            author.setName(authorDTO.getName());
            author.setBooks(books);
            authors.add(author);
        }

        return authorRepository.saveAll(authors);
    }
}
