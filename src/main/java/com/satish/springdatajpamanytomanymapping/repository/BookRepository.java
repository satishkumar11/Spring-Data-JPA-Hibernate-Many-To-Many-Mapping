package com.satish.springdatajpamanytomanymapping.repository;

import com.satish.springdatajpamanytomanymapping.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
