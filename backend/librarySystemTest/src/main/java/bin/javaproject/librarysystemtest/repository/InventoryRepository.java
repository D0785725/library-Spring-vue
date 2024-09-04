package bin.javaproject.librarysystemtest.repository;

import bin.javaproject.librarysystemtest.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository  extends JpaRepository<Inventory, Long> {
}
