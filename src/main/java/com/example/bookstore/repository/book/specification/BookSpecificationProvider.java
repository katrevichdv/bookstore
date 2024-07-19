package com.example.bookstore.repository.book.specification;

import com.example.bookstore.dto.BookSearchParametersDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationProvider;

public interface BookSpecificationProvider
        extends SpecificationProvider<Book, BookSearchParametersDto> {
}
