package bin.javaproject.librarysystemtest.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "book")
@NoArgsConstructor
public class Book {


    @Id
    @Column(name = "isbn", nullable = false,unique = true)
    private String isbn;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "introduction")
    private String introduction;


    public Book(String isbn, String name, String author, String introduction) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.introduction = introduction;
    }
}