package com.example.bookstore.service.impl;

import com.example.bookstore.dto.book.BookRequestDto;
import com.example.bookstore.dto.book.BookResponseDto;
import com.example.bookstore.dto.book.BookSearchParametersDto;
import com.example.bookstore.exception.EntityNotFoundException;
import com.example.bookstore.mapper.BookMapper;
import com.example.bookstore.repository.book.BookRepository;
import com.example.bookstore.repository.book.BookSpecificationManager;
import com.example.bookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationManager specificationManager;

    @Override
    public BookResponseDto save(BookRequestDto requestDto) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toModel(requestDto)));
    }

    @Override
    public List<BookResponseDto> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Can't find book by id: " + id));
    }

    @Override
    public BookResponseDto update(BookRequestDto requestDto, Long id) {
        return bookRepository.findById(id)
                .map(book -> bookMapper.update(requestDto, book))
                .map(bookRepository::save)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Can't update book by id: " + id));
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookResponseDto> search(BookSearchParametersDto searchParameters,
                                        Pageable pageable) {
        return bookRepository.findAll(specificationManager.getSpecification(searchParameters),
                        pageable)
                .stream()
                .map(bookMapper::toDto)
                .toList();
    }
}
