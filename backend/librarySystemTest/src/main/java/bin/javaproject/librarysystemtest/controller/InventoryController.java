package bin.javaproject.librarysystemtest.controller;

import bin.javaproject.librarysystemtest.entity.Inventory;
import bin.javaproject.librarysystemtest.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventories")
@RequiredArgsConstructor
public class InventoryController {


    private final InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryService.saveInventory(inventory);
    }

    // 其他 API 端點
}