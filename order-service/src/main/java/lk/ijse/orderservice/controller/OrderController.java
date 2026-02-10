package lk.ijse.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/order")
public class OrderController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/call-inventory")
    public  ResponseEntity<?> callToInventoryService(){
        // inventory-service kiyala call karanna puluwan une RestTemplate eka athulata @LoadBalance annotation eka dapu nisa eka damme naththan localhost eken call karanna oni.
        String URL="http://inventory-service/api/v1/inventory/details";
        String response=restTemplate.getForObject(URL, String.class);
        System.out.println("Response from Inventory Service: " + response);
        return new ResponseEntity<>("From Order service call to Inventory service success, Res: " + response, HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<?> getDetails(){
        return new ResponseEntity<>("Order service is UP!", HttpStatus.OK);
    }

    @GetMapping("/health")
    public ResponseEntity<?> getHealth(){
        return new ResponseEntity<>("Order service health GOOD!", HttpStatus.OK);
    }
}
