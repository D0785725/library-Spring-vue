package bin.javaproject.librarysystemtest.service;

import bin.javaproject.librarysystemtest.Enum.BookStatus;
import bin.javaproject.librarysystemtest.entity.BorrowingRecord;
import bin.javaproject.librarysystemtest.entity.Inventory;
import bin.javaproject.librarysystemtest.entity.User;
import bin.javaproject.librarysystemtest.repository.BorrowingRecordRepository;
import bin.javaproject.librarysystemtest.repository.InventoryRepository;
import bin.javaproject.librarysystemtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BorrowingRecordService {



    private final BorrowingRecordRepository borrowingRecordRepository;
    private final InventoryRepository inventoryRepository;
    private final UserRepository userRepository;

    @Autowired
    public BorrowingRecordService(BorrowingRecordRepository borrowingRecordRepository,
                                  InventoryRepository inventoryRepository,
                                  UserRepository userRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
        this.inventoryRepository = inventoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecordRepository.findAll();
    }

    @Transactional
    public void borrowBook(Long userId, Long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid inventory ID"));

        if (!BookStatus.AVAILABLE.equals(inventory.getStatus())) {
            throw new IllegalStateException("Book is not available for borrowing.");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        // 創建借閱記錄
        BorrowingRecord record = new BorrowingRecord();
        record.setUser(user);
        record.setInventory(inventory);
        borrowingRecordRepository.save(record); // 保存時，@PrePersist 自動設置 borrowingTime 和 expectedReturnTime


        inventory.setStatus(BookStatus.BORROWED);
        inventoryRepository.save(inventory);
    }

    @Transactional
    public void returnBook(Long userId, Long inventoryId) {
        Inventory inventory = inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid inventory ID"));

        BorrowingRecord record = borrowingRecordRepository.findByUserIdAndInventoryId(userId, inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Borrowing record not found."));

        // 標記為已歸還
        record.markAsReturned();
        borrowingRecordRepository.save(record);

        // 更新書籍狀態為可借閱
        inventory.setStatus(BookStatus.AVAILABLE);
        inventoryRepository.save(inventory);
    }
}