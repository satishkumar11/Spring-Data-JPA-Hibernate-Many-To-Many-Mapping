package com.satish.springdatajpamanytomanymapping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthorAddRequest {
    List<AuthorDTO> authors;
    List<BookDTO> books;
}
