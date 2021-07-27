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
public class AuthorUpdateRequest {
    private String name;
    private List<BookDTO> books;
}
