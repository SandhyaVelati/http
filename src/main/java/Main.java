import org.northcoders.dao.FakeBooksDAO;
import org.northcoders.model.BookData;
import org.northcoders.model.BookResponse;

import java.awt.print.Book;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookResponse bookResponse = FakeBooksDAO.bookDataAccsess();
        List<BookData> books = bookResponse.data();
        for(BookData book : books){
            System.out.println(book);
        }
    }
}
