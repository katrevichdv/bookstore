package com.example.bookstore.repository.book.specification;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationProvider;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MinPriceSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return "minPrice";
    }

    @Override
    public Specification<Book> getSpecification(List<String> params) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.ge(root.get("price"), new BigDecimal(params.get(0)));
    }
}
