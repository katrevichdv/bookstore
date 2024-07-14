package com.example.bookstore.repository;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T, R extends Specification<?>> {
    R build(T searchParameters);
}
