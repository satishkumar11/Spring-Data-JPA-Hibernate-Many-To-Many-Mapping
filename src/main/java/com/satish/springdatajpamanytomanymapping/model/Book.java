package com.satish.springdatajpamanytomanymapping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @JsonBackReference // @JsonBackReference annotation is not serialized; and during deserialization, its value is set to instance that has the "managed" (forward) link((Refer notes)).
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH}, mappedBy = "books")
    private List<Author> authors = new ArrayList<>();
}
