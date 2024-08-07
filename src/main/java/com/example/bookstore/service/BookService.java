package com.example.bookstore.service;

import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.dto.BookResponseDto;
import com.example.bookstore.dto.BookSearchParametersDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookResponseDto save(BookRequestDto bookRequestDto);

    List<BookResponseDto> getAll(Pageable pageable);

    BookResponseDto getBookById(Long id);

    BookResponseDto update(BookRequestDto requestDto, Long id);

    void delete(Long id);

    List<BookResponseDto> search(BookSearchParametersDto searchParameters, Pageable pageable);
}
