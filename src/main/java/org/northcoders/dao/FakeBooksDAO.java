package org.northcoders.dao;

import org.northcoders.model.BookData;
import org.northcoders.model.BookResponse;
import org.northcoders.model.FlightDetails;
import org.northcoders.model.FlightResponse;
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

    public static void BookDataAccsessWithQueries(){
        WebClient client = WebClient.create("https://fakerapi.it/api/v1");
        BookResponse bookResponse = client.get().uri(uriBuilder -> uriBuilder.path("/books")
                        .queryParam("_quantity", 2)
                        .queryParam("_locale", "fr_FR")
                        .build())
                .retrieve()
                .bodyToMono(BookResponse.class)
                .block();
        if(bookResponse != null){
            for (BookData book : bookResponse.data()){
                System.out.println(book);
            }
        }
    }


    public static void publicFlightsAccess(){
        WebClient client = WebClient.builder()
                .defaultHeaders(httpHeaders -> {
                    httpHeaders.add("app_key","******");
                    httpHeaders.add("app_id","*****");
                    httpHeaders.add("ResourceVersion","v4");
                    httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
                })
                .baseUrl("https://api.schiphol.nl/public-flights")
                .build();
        //WebClient client = WebClient.create();
        FlightResponse flightDetails = client.get().uri(uriBuilder -> uriBuilder.path("/flights")
                        .queryParam("includedelays",false)
                        .queryParam("page",0)
                        .queryParam("sort","+scheduleTime")
                        .build())
                .retrieve()
                .bodyToMono(FlightResponse.class)
                .block();
        if(flightDetails != null){
            System.out.println(flightDetails);
        }
    }


}
