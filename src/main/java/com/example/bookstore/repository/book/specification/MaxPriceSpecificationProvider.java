package com.example.bookstore.repository.book.specification;

import com.example.bookstore.dto.book.BookSearchParametersDto;
import com.example.bookstore.model.Book;
import java.math.BigDecimal;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MaxPriceSpecificationProvider implements BookSpecificationProvider {
    @Override
    public boolean isSuitable(BookSearchParametersDto searchParameters) {
        return searchParameters.maxPrice() != null;
    }

    @Override
    public Specification<Book> getSpecification(BookSearchParametersDto searchParameters) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.le(root.get("price"), new BigDecimal(searchParameters.maxPrice()));
    }
}
