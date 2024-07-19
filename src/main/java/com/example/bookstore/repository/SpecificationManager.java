package com.example.bookstore.repository;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationManager<T, U> {
    Specification<T> getSpecification(U searchParameters);
}
