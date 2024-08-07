package com.example.bookstore.repository;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationProvider<T, U> {
    boolean isSuitable(U searchParameters);

    Specification<T> getSpecification(U searchParameters);
}
