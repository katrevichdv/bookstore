package com.example.bookstore.repository.book.specification;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationProvider;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class DescriptionSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return "description";
    }

    @Override
    public Specification<Book> getSpecification(List<String> params) {
        return (root, query, criteriaBuilder) ->
            params.stream()
                    .map(p -> criteriaBuilder.like(root.get("description"), "%" + p + "%"))
                    .reduce(criteriaBuilder::and)
                    .orElse(null);
    }
}
