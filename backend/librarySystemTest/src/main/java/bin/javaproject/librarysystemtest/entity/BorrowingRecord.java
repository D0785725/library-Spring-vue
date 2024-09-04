package bin.javaproject.librarysystemtest.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrowing_record")
@Data
@NoArgsConstructor
public class BorrowingRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private Inventory inventory;

    @Column(name = "borrowing_time", nullable = false)
    private LocalDateTime borrowingTime;

    @Column(name = "expected_return_time", nullable = false)
    private LocalDateTime expectedReturnTime;


    @Column(name = "return_time")
    private LocalDateTime returnTime;


    @PrePersist
    protected void onBorrow() {
        this.borrowingTime = LocalDateTime.now();  // set  N day
        this.expectedReturnTime = this.borrowingTime.plusDays(7); // set N + 7 day
    }

    public void markAsReturned() {
        this.returnTime = LocalDateTime.now(); // 設置實際歸還時間為當前時間
    }
}