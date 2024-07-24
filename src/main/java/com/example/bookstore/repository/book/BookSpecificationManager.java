package com.example.bookstore.repository.book;

import com.example.bookstore.dto.book.BookSearchParametersDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationManager;

public interface BookSpecificationManager
        extends SpecificationManager<Book, BookSearchParametersDto> {
}
