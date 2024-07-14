package com.example.bookstore.repository.book;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationProvider;
import com.example.bookstore.repository.SpecificationProviderManager;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final Map<String, SpecificationProvider<Book>> bookSpecificationProvidersMap;

    public BookSpecificationProviderManager(
            List<SpecificationProvider<Book>> bookSpecificationProviders) {
        bookSpecificationProvidersMap = bookSpecificationProviders.stream()
                .collect(Collectors.toMap(SpecificationProvider::getKey, Function.identity()));
    }

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return Optional.ofNullable(bookSpecificationProvidersMap.get(key))
                .orElseThrow(() -> new NoSuchElementException(
                        "Can't find bookSpecificationProvider for key: " + key));
    }
}
