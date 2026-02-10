package lk.ijse.inventoryservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/inventory")
public class InventoryController {
    @GetMapping("/details")
    public ResponseEntity<?> getDetails(){
        return new ResponseEntity<>("Inventory service is UP!", HttpStatus.OK);
    }

    @GetMapping("/health")
    public ResponseEntity<?> getHealth(){
        return new ResponseEntity<>("Inventory service health is GOOD!", HttpStatus.OK);
    }
}
