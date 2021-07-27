package com.satish.springdatajpamanytomanymapping.repository;

import com.satish.springdatajpamanytomanymapping.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
