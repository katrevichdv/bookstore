package com.example.bookstore.repository.book.specification;

import com.example.bookstore.dto.book.BookSearchParametersDto;
import com.example.bookstore.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements BookSpecificationProvider {
    @Override
    public boolean isSuitable(BookSearchParametersDto searchParameters) {
        return searchParameters.author() != null;

    }

    @Override
    public Specification<Book> getSpecification(BookSearchParametersDto searchParameters) {
        return (root, query, criteriaBuilder) -> root.get("author").in(searchParameters.author());
    }
}
