package bin.javaproject.librarysystemtest.repository;

import bin.javaproject.librarysystemtest.entity.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRecordRepository  extends JpaRepository<BorrowingRecord, Long> {

    @Query("SELECT br FROM BorrowingRecord br WHERE br.user.id = :userId AND br.inventory.inventoryId = :inventoryId")
    Optional<BorrowingRecord> findByUserIdAndInventoryId(Long userId, Long inventoryId);
}
