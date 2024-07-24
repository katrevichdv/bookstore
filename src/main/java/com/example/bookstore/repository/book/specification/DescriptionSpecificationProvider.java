package com.example.bookstore.repository.book.specification;

import com.example.bookstore.dto.book.BookSearchParametersDto;
import com.example.bookstore.model.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DescriptionSpecificationProvider implements BookSpecificationProvider {
    @Override
    public boolean isSuitable(BookSearchParametersDto searchParameters) {
        return searchParameters.description() != null;
    }

    @Override
    public Specification<Book> getSpecification(BookSearchParametersDto searchParameters) {
        return (root, query, criteriaBuilder) ->
            searchParameters.description()
                    .stream()
                    .map(p -> criteriaBuilder.like(root.get("description"), "%" + p + "%"))
                    .reduce(criteriaBuilder::and)
                    .orElse(null);
    }
}
