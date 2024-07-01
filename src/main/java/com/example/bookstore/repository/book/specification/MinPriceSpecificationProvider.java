package com.example.bookstore.repository.book.specification;

import com.example.bookstore.dto.BookSearchParametersDto;
import com.example.bookstore.model.Book;
import java.math.BigDecimal;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MinPriceSpecificationProvider implements BookSpecificationProvider {
    @Override
    public boolean isSuitable(BookSearchParametersDto searchParameters) {
        return searchParameters.minPrice() != null;
    }

    @Override
    public Specification<Book> getSpecification(BookSearchParametersDto searchParameters) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.ge(root.get("price"), new BigDecimal(searchParameters.minPrice()));
    }
}
