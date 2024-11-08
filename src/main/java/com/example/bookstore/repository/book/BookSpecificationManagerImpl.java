package com.example.bookstore.repository.book;

import com.example.bookstore.dto.book.BookSearchParametersDto;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.book.specification.BookSpecificationProvider;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationManagerImpl implements BookSpecificationManager {
    private final List<BookSpecificationProvider> providers;

    @Override
    public Specification<Book> getSpecification(BookSearchParametersDto searchParameters) {
        List<Specification<Book>> list = providers.stream()
                .filter(e -> e.isSuitable(searchParameters))
                .map(e -> e.getSpecification(searchParameters))
                .toList();
        return Specification.allOf(list);
    }
}
