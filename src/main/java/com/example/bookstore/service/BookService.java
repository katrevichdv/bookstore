package com.example.bookstore.service;

import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.dto.BookResponseDto;
import java.util.List;

public interface BookService {
    BookResponseDto save(BookRequestDto bookRequestDto);

    List<BookResponseDto> getAll();

    BookResponseDto getBookById(Long id);

    BookResponseDto update(BookRequestDto requestDto, Long id);

    void delete(Long id);
}
