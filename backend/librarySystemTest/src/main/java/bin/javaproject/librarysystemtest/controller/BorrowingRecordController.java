package bin.javaproject.librarysystemtest.controller;

import bin.javaproject.librarysystemtest.service.BorrowingRecordService;
import bin.javaproject.librarysystemtest.entity.BorrowingRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowing-records")
public class BorrowingRecordController {


    private final BorrowingRecordService borrowingRecordService;
    @Autowired
    public BorrowingRecordController(BorrowingRecordService borrowingRecordService) {
        this.borrowingRecordService = borrowingRecordService;
    }

    @GetMapping("/records")
    public List<BorrowingRecord> getBorrowingRecords() {
        return borrowingRecordService.getBorrowingRecords();
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam Long userId, @RequestParam Long inventoryId) {
        borrowingRecordService.borrowBook(userId, inventoryId);
        return "Book borrowed successfully.";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Long userId, @RequestParam Long inventoryId) {
        borrowingRecordService.returnBook(userId, inventoryId);
        return "Book returned successfully.";
    }
}