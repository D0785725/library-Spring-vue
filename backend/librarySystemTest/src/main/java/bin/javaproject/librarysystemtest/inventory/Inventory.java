package bin.javaproject.librarysystemtest.inventory;

import bin.javaproject.librarysystemtest.book.BookStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory")
@NoArgsConstructor
@Data
public class Inventory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="inventory_id")
    private Long inventoryId;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "store_time")
    private LocalDateTime storeTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookStatus status;

    public Inventory(String isbn,  BookStatus status) {
        this.isbn = isbn;
        this.status = status;
    }

    @PrePersist
    protected void onCreate() {
        this.storeTime = LocalDateTime.now();
    }
}
