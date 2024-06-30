package com.example.bookstore.repository.book.specification;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationProvider;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class IsbnSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return "isbn";
    }

    @Override
    public Specification<Book> getSpecification(List<String> params) {
        return (root, query, criteriaBuilder) ->
            params.stream()
                    .map(p -> criteriaBuilder.like(root.get("isbn"), "%" + p + "%"))
                    .reduce(criteriaBuilder::or)
                    .orElse(null);
    }
}
