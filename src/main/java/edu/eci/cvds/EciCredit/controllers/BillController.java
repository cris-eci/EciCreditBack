package edu.eci.cvds.EciCredit.controllers;

import edu.eci.cvds.EciCredit.models.Bill;
import edu.eci.cvds.EciCredit.services.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {
    
    @Autowired
    private BillService billService;
    
    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        try {
            // Set purchase date if not provided
            if (bill.getPurchaseDate() == null) {
                bill.setPurchaseDate(new Date());
            }
            
            Bill processedBill = billService.processBill(bill);
            
            HttpStatus status = "APPROVED".equals(processedBill.getStatus()) ? 
                               HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(processedBill, status);
        } catch (Exception e) {
            Bill errorBill = new Bill();
            errorBill.setStatus("DECLINED");
            errorBill.setResponseMessage("Error: " + e.getMessage());
            return new ResponseEntity<>(errorBill, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Bill>> getBillsByUserId(@PathVariable int userId) {
        List<Bill> bills = billService.getBillsByUserId(userId);
        return new ResponseEntity<>(bills, HttpStatus.OK);
    }
}