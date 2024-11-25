package org.northcoders.dao;

import org.northcoders.model.BookResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.awt.print.Book;
import java.util.List;

public class FakeBooksDAO {
    public static BookResponse bookDataAccsess(){
        WebClient client = WebClient.create("https://fakerapi.it/api/v1");

     BookResponse booksResponse = client.get()
                .uri("/books").accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(BookResponse.class).block();
    return booksResponse;
    }

    public static BookResponse BookDataAccsessWithQueries(){
        WebClient client = WebClient.create("https://fakerapi.it/api/v1");
        client.get().uri(uriBuilder -> uriBuilder.path("/books")
                .queryParam("_quantity",2))

        return  new BookResponse();
    }
}
