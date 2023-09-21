package com.example.bookstore.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String price;
    private String description;
    private String coverImage;
}
