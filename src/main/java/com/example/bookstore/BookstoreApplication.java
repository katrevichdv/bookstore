package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookstoreApplication.class);

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        LOGGER.info("Starting Bookstore application");
        SpringApplication.run(BookstoreApplication.class, args);
        LOGGER.info("Bookstore application finished");
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book book = new Book();
                book.setTitle("The Black Obelisk: A Novel");
                book.setAuthor("Erich Maria Remarque");
                book.setIsbn("978-0449912447");
                book.setPrice(BigDecimal.valueOf(100.0));
                bookService.save(book);
                System.out.println(book);
                System.out.println(bookService.findAll());
            }
        };
    }
}
