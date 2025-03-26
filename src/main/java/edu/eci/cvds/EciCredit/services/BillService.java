package edu.eci.cvds.EciCredit.services;

import edu.eci.cvds.EciCredit.models.Bill;
import edu.eci.cvds.EciCredit.models.BillItem;
import edu.eci.cvds.EciCredit.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    
    @Autowired
    private BillRepository billRepository;
    
    public Bill processBill(Bill bill) {
        // Validate the bill before saving
        validateBill(bill);
        return billRepository.save(bill);
    }
    
    public List<Bill> getBillsByUserId(int userId) {
        return billRepository.findByUserId(userId);
    }
    
    private void validateBill(Bill bill) {
        // Calculate total from items
        double calculatedTotal = bill.getItems().stream()
                                     .mapToDouble(item -> item.getUnitPrice() * item.getQuantity())
                                     .sum();
        
        // Round to avoid floating point comparison issues
        calculatedTotal = Math.round(calculatedTotal * 100.0) / 100.0;
        double declaredTotal = Math.round(bill.getTotalAmount() * 100.0) / 100.0;
        
        if (calculatedTotal != declaredTotal) {
            bill.setStatus("DECLINED");
            bill.setResponseMessage("Total amount doesn't match the sum of items");
        } else {
            bill.setStatus("APPROVED");
            bill.setResponseMessage("Transaction processed successfully");
        }
    }
}