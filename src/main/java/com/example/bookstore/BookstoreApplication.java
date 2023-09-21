package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookstoreApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Starting Bookstore application");
        SpringApplication.run(BookstoreApplication.class, args);
        LOGGER.info("Bookstore application finished");
    }
}
