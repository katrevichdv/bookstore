package com.example.bookstore.repository.book;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.SpecificationProvider;
import com.example.bookstore.repository.SpecificationProviderManager;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Component;

@Component
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> bookSpecificationProviders;

    public BookSpecificationProviderManager(
            List<SpecificationProvider<Book>> bookSpecificationProviders) {
        this.bookSpecificationProviders = bookSpecificationProviders;
    }

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return bookSpecificationProviders.stream()
                .filter(bookSpecificationProvider -> bookSpecificationProvider.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(
                        "Can't find bookSpecificationProvider for key: " + key));
    }
}
