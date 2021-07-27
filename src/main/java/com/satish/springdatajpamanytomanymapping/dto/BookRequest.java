package com.satish.springdatajpamanytomanymapping.dto;

import com.satish.springdatajpamanytomanymapping.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BookRequest {
    private Book book;
}
