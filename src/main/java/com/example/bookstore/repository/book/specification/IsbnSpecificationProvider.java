package com.example.bookstore.repository.book.specification;

import com.example.bookstore.dto.BookSearchParametersDto;
import com.example.bookstore.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class IsbnSpecificationProvider implements BookSpecificationProvider {
    @Override
    public boolean isSuitable(BookSearchParametersDto searchParameters) {
        return searchParameters.isbn() != null;
    }

    @Override
    public Specification<Book> getSpecification(BookSearchParametersDto searchParameters) {

        return (root, query, criteriaBuilder) ->
            searchParameters.isbn()
                    .stream()
                    .map(p -> criteriaBuilder.like(root.get("isbn"), "%" + p + "%"))
                    .reduce(criteriaBuilder::or)
                    .orElse(null);
    }
}
