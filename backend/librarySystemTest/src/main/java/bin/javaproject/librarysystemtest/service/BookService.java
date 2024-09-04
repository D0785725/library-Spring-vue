package bin.javaproject.librarysystemtest.service;


import bin.javaproject.librarysystemtest.Enum.BookStatus;
import bin.javaproject.librarysystemtest.entity.Book;
import bin.javaproject.librarysystemtest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }


}