package com.example.jackson;

import com.example.jackson.domain.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JacksonTests {

    @Test
    public void testThatObjectMapperCanCreateJsonFromObject() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Book book = Book.builder()
                .isbn("978-0-06-112008-4")
                .title("To Kill a Mockingbird")
                .author("Harper Lee")
                .yearPublished("1960")
                .build();
        String result = mapper.writeValueAsString(book);

        assertThat(result).isEqualTo("{\"isbn\":\"978-0-06-112008-4\",\"title\":\"To Kill a Mockingbird\",\"author\":\"Harper Lee\",\"year\":\"1960\"}");
    }

    @Test
    public void testThatObjectMapperCanCreateJavaObjectFromJsonObject() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"isbn\":\"978-0-06-112008-4\",\"title\":\"To Kill a Mockingbird\",\"author\":\"Harper Lee\",\"yearPublished\":\"1960\"}";
        Book book = mapper.readValue(json, Book.class);

        assertThat(book).isEqualTo(Book.builder()
                .isbn("978-0-06-112008-4")
                .title("To Kill a Mockingbird")
                .author("Harper Lee")
                .yearPublished("1960")
                .build());
    }
}
