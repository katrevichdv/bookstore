package com.example.bookstore.repository.book;

import com.example.bookstore.dto.BookSearchParametersDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationBuilder;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class BookSpecificationBuilder
        implements SpecificationBuilder<BookSearchParametersDto, Specification<Book>> {
    private final BookSpecificationProviderManager bookSpecificationProviderManager;

    public BookSpecificationBuilder(BookSpecificationProviderManager specificationProviderManager) {
        this.bookSpecificationProviderManager = specificationProviderManager;
    }

    @Override
    public Specification<Book> build(BookSearchParametersDto searchParameters) {
        List<Specification<Book>> list = paramsToMap(searchParameters)
                .entrySet()
                .stream()
                .filter(e -> !e.getValue().isEmpty())
                .map(e -> bookSpecificationProviderManager
                        .getSpecificationProvider(e.getKey())
                        .getSpecification(e.getValue()))
                .toList();
        return Specification.allOf(list);
    }

    private Map<String, List<String>> paramsToMap(BookSearchParametersDto searchParameters) {
        return Map.of(
                "title", nonNullList(searchParameters.title()),
                "author", nonNullList(searchParameters.author()),
                "isbn", nonNullList(searchParameters.isbn()),
                "minPrice", nonNullList(searchParameters.minPrice()),
                "maxPrice", nonNullList(searchParameters.maxPrice()),
                "description", nonNullList(searchParameters.description())
        );
    }

    private List<String> nonNullList(List<String> list) {
        return list == null ? List.of() : list;
    }

    private List<String> nonNullList(String string) {
        return string == null ? List.of() : List.of(string);
    }
}
