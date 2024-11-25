package org.northcoders.model;

import java.awt.print.Book;
import java.util.List;

public record BookResponse(String status, int code, String locale, Integer seed, int total, List<BookData> data ) {
    @Override
    public String toString() {
        return "BookResponse{" +
                "status='" + status + '\'' +
                ", code=" + code +
                ", locale='" + locale + '\'' +
                ", seed=" + seed +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}
