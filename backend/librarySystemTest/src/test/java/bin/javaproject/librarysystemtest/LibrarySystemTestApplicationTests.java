package bin.javaproject.librarysystemtest;

import bin.javaproject.librarysystemtest.Enum.BookStatus;
import bin.javaproject.librarysystemtest.entity.Book;
import bin.javaproject.librarysystemtest.entity.Inventory;
import bin.javaproject.librarysystemtest.repository.BookRepository;

import bin.javaproject.librarysystemtest.repository.InventoryRepository;
import bin.javaproject.librarysystemtest.repository.UserRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class LibrarySystemTestApplicationTests {
    @Autowired
    private BookRepository bookRepository;
    @Autowired 
    private InventoryRepository inventoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Test
    void addUsers(){

    }

    @Test
    void contextLoads() {
        List<Book> books = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Book book = new Book();
            book.setIsbn("ISBN-" + i);
            book.setName("Book " + i);
            book.setAuthor("Author " + i);
            book.setIntroduction("This is the introduction of Book " + i);

            books.add(book);
        }

        bookRepository.saveAll(books);

        for (Book book : books) {

            Inventory inventory = new Inventory();
            inventory.setIsbn(book.getIsbn());
            inventory.setStoreTime(LocalDateTime.now());
            inventory.setStatus(BookStatus.AVAILABLE);
            inventoryRepository.save(inventory);

        }
    }

}
