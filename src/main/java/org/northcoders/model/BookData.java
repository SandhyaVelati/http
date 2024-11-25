package org.northcoders.model;

public record BookData(int id, String title, String author, String genre, String description, String isbn, String image, String published, String publisher) {
    @Override
    public String toString() {
        return "BookData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", isbn=" + isbn +
                ", image='" + image + '\'' +
                ", published='" + published + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
