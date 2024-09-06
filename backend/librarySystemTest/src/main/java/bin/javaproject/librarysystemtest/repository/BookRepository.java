package bin.javaproject.librarysystemtest.repository;


import bin.javaproject.librarysystemtest.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
