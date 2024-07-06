package com.example.jackson.controllers;

import com.example.jackson.domain.Book;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class BookController {

    @GetMapping(path="/books")
    public Book retrieveBook() {
        log.info("retrieveBook called");
        return Book.builder()
                .isbn("978-0-06-112008-4")
                .title("To Kill a Mockingbird")
                .author("Harper Lee")
                .yearPublished("1960")
                .build();
    }

    @PostMapping(path="/books")
    public Book createBook(@RequestBody final Book book){
        log.info("createBook called " + book.toString());
        return book;
    }
}
